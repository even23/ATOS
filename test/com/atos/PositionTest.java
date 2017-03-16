package com.atos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Kamil on 16.03.2017.
 */
class PositionTest {
    static Position pos1, pos2, pos3;
    @BeforeAll
    static void setUp() {
        pos1 = new Position("Hobbit", "Tolkien", 1937);
        pos2 = new Position("Potop", "Sienkiewicz", 1937);
        pos3 = new Position("Hobbit", "Tolkien", 1937);
    }

    @Test
    void equalsTest() {
        assertTrue(pos1.equals(pos3));
        assertFalse(pos1.equals(pos2));
    }

    @Test
    void toStringTest() {
        assertTrue(pos1.toString().equals("title='Hobbit', author='Tolkien', year=1937, available=1, lent=0"));
    }

    @Test
    void hashCodeTest() {
        assertTrue(pos1.hashCode() == pos3.hashCode());
        assertFalse(pos1.hashCode() == pos2.hashCode());
    }

    @Test
    void getAvailable() {
        assertTrue(pos1.getAvailable() == 1);
    }

    @Test
    void increaseAvailable() {
        assertTrue(pos2.getAvailable() == 1);
        pos2.increaseAvailable();
        assertFalse(pos2.getAvailable() == 1);
        assertTrue(pos2.getAvailable() == 2);
    }

    @Test
    void decreaseAvailable() {
        assertTrue(pos3.getAvailable() == 1);
        pos3.decreaseAvailable();
        assertFalse(pos3.getAvailable() == 1);
        assertTrue(pos3.getAvailable() == 0);
    }

    @Test
    void getLent() {
        assertTrue(pos1.getLent() == 0);
    }

    @Test
    void increaseLent() {
        assertTrue(pos2.getLent() == 0);
        pos2.increaseLent();
        assertFalse(pos2.getLent() == 0);
        assertTrue(pos2.getLent() == 1);
    }

    @Test
    void decreaseLent() {
        pos3.increaseLent();
        pos3.increaseLent();
        assertTrue(pos3.getLent() == 2);
        pos3.decreaseLent();
        assertFalse(pos3.getLent() == 2);
        assertTrue(pos3.getLent() == 1);
    }

}