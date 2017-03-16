package com.atos;

/**
 * Created by Kamil on 16.03.2017.
 * Physical instance of book in library
 * It has unique id, information if it's lent and by whom - owner
 */
public class Volume extends Book {

    private int id;
    private boolean lent;
    private String owner;

    Volume(int id, String title, String author, int year) {

        super(title, author, year);
        this.id = id;
        this.lent = false;
        this.owner = null;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", " + super.toString() +
                ", lent=" + lent +
                ", owner='" + owner + '\'';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    int getId() {
        return id;
    }

    boolean isLent() {
        return lent;
    }

    void setLent(boolean lent) {
        this.lent = lent;
    }

    String getOwner() {
        return owner;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }
}
