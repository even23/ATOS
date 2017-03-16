package com.atos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Kamil on 16.03.2017.
 */
class BookTest {
    static Book book1, book2, book3;
    @BeforeAll
    static void  setUp() {
        book1 = new Book("Hobbit", "Tolkien", 1937);
        book2 = new Book("Potop", "Sienkiewicz", 1937);
        book3 = new Book("Hobbit", "Tolkien", 1937);
    }

    @Test
    void hashCodeTest() {
        assertTrue(book1.hashCode() == book3.hashCode());
        assertFalse(book1.hashCode() == book2.hashCode());
    }

    @Test
    void toStringTest() {
        assertTrue(book1.toString().equals("title='Hobbit', author='Tolkien', year=1937"));
        assertFalse(book1.toString().equals("title='Hobbit', author='Tolkien', year=1938"));
        assertTrue(book1.toString().equals(book3.toString()));
    }

    @Test
    void equalsTest() {
        assertFalse(book1.equals(book2));
        assertTrue(book1.equals(book3));
    }

    @Test
    void getTitleTest() {
        assertTrue(book1.getTitle().equals("Hobbit"));
        assertFalse(book2.getTitle().equals("Hobbit"));
    }

    @Test
    void getAuthorTest() {
        assertTrue(book1.getAuthor().equals("Tolkien"));
        assertFalse(book2.getAuthor().equals("Tolkien"));
    }

    @Test
    void getYearTest() {
        assertTrue(book1.getYear() == 1937);
        assertFalse(book2.getYear() == 1938);
    }

}