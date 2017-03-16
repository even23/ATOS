package com.atos;

/**
 * Created by Kamil on 16.03.2017.
 * Abstract object in system.
 * It has information how many available/lent volumes of a book are in the library
 */
public class Position extends Book {

    private int available;
    private int lent;

    Position(String title, String author, int year) {
        super(title, author, year);
        this.available = 1;
        this.lent = 0;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", available=" + available +
                ", lent=" + lent;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    int getAvailable() {
        return available;
    }

    void increaseAvailable() {
        this.available++;
    }

    void decreaseAvailable() {
        this.available--;
    }

    int getLent() {
        return lent;
    }

    void increaseLent() {
        this.lent++;
    }

    void decreaseLent() {
        this.lent--;
    }
}
