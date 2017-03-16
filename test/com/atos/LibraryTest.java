package com.atos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Kamil on 16.03.2017.
 */
class LibraryTest {
    static Library library;
    @BeforeAll
    static void setUp() {
        library = new Library();
        library.addVolume("W pustyni i w puszczy", "Sienkiewicz", 1978);
        library.addVolume("Hobbit", "Tolkien", 1988);
        library.addVolume("Harry Potter", "Rowling", 2000);
        library.lendVolume(2, "Steven");
    }

    @Test
    void addPositionTest() {
        Position pos = new Position("Harry Potter", "Rowling", 2000);
        library.addPosition(pos.hashCode(), pos);
        assertTrue(library.getPositions().get(pos.hashCode()).getAvailable() == 2);

     }

    @Test
    void addVolumeTest() {
        assertTrue(library.getVolumes().get(2)
                .equals(new Volume(3, "Harry Potter", "Rowling", 2000)));
    }

    @Test
    void removeVolumeTest() {
        assertTrue(library.removeVolume(0) == null);
    }

    @Test
    void lendVolumeTest() {
        library.lendVolume(1, "Kamil");
        Volume volume = library.getVolumes().get(0);
        assertTrue(volume.getOwner().equals("Kamil"));
        assertTrue(volume.isLent() == true);

        assertTrue(library.getPositions().get(volume.hashCode()).getAvailable() == 0);
        assertTrue(library.getPositions().get(volume.hashCode()).getLent() == 1);
    }

    @Test
    void returnVolumeTest() {
        library.returnVolume(2);
        Volume volume = library.getVolumes().get(1);
        assertTrue(volume.getOwner() == null);
        assertTrue(volume.isLent() == false);

        assertTrue(library.getPositions().get(volume.hashCode()).getAvailable() == 1);
        assertTrue(library.getPositions().get(volume.hashCode()).getLent() == 0);
    }

    @Test
    void findByIDTest() {
        assertTrue(library.getVolumes().get(0) == library.findByID(1));
        assertTrue(library.findByID(0) == null);
    }

    @Test
    void findBookTest() {
        assertTrue(library.findBook("Hobbit", null, null).size() == 1);
    }
}