package com.atos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Kamil on 16.03.2017.
 */
class VolumeTest {
    static Volume vol1, vol2, vol3;
    @BeforeAll
    static void setUp() {
        vol1 = new Volume(1, "Hobbit", "Tolkien", 1937);
        vol2 = new Volume(2, "Potop", "Sienkiewicz", 1937);
        vol3 = new Volume(3, "Hobbit", "Tolkien", 1937);
    }

    @Test
    void toStringTest() {
        assertTrue(vol1.toString()
                .equals("id=1, title='Hobbit', author='Tolkien', year=1937, lent=false, owner='null'"));
    }

    @Test
    void hashCodeTest() {
        assertTrue(vol1.hashCode() == vol3.hashCode());
    }

    @Test
    void getIdTest() {
        assertTrue(vol1.getId() == 1);
    }

    @Test
    void isLentTest() {
        assertTrue(vol1.isLent() == false);
    }

    @Test
    void setLentTest() {
        assertTrue(vol2.isLent() == false);
        vol2.setLent(true);
        assertTrue(vol2.isLent() == true);
    }

    @Test
    void getOwnerTest() {
        assertTrue(vol2.getOwner() == null);
    }

    @Test
    void setOwnerTest() {
        assertTrue(vol3.getOwner() == null);
        vol3.setOwner("John");
        assertTrue(vol3.getOwner().equals("John"));
    }

}