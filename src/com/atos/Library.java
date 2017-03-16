package com.atos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil on 15.03.2017.
 *
 * Class Library represents the library from the task.
 * It contains:
 * volumes - physical objects, which can be lent to somebody;
 * positions - abstract objects that represent books in system;
 * (e.g. library can have "Hobbit" position in system and 5 volumes of it)
 * id - unique id generated for volumes
 *
 */
public class Library {
    private static int id = 1;
    private ArrayList<Volume> volumes;
    private HashMap<Integer, Position> positions;

    Library() {
        this.volumes = new ArrayList<>();
        this.positions = new HashMap<>();
    }

    void addPosition(Integer key, Position value) {
        if(positions.containsKey(key)) {
            positions.get(key).increaseAvailable();
        }
        else {
            positions.put(key, value);
        }
    }

    void removePosition(Integer key) {
        Position position = positions.get(key);
        if(position.getAvailable() + position.getLent() == 1) {
            positions.remove(key);
        }
        else {
            position.decreaseAvailable();
        }
    }

    void showPositions() {
        Collection collection = positions.values();
        String temp = "Positions:\n";
        for (Object object: collection
                ) {
            temp = temp + object.toString() + ",\n";
        }
        System.out.print(temp);
    }

    void addVolume(String title, String author, int year) {
        volumes.add(new Volume(id, title, author, year));

        Position value = new Position(title, author, year);
        Integer key = value.hashCode();
        addPosition(key, value);

        id++;
    }

    Volume removeVolume(int id) {
        Volume volume = findByID(id);
        if(volume != null) {
            if(volume.isLent()) {
                System.out.println("The book with such ID is currently lent!");
            }
            else {
                removePosition(volume.hashCode());
                volumes.remove(volume);
                System.out.println("Book removed:\n" + volume);
                return volume;
            }
        }
        else {
            System.out.println("The book with such ID doesn't exist!");
        }
        return null;
    }

    void lendVolume(int id, String owner) {
        Volume volume = findByID(id);
        if(volume != null) {
            if(volume.isLent()) {
                System.out.println("The book with such ID is currently lent!");
            }
            else {
                volume.setLent(true);
                volume.setOwner(owner);

                Position position = positions.get(volume.hashCode());
                position.decreaseAvailable();
                position.increaseLent();

                System.out.println("Book lent\n" + volume);
            }
        }
        else {
            System.out.println("The book with such ID doesn't exist!");
        }
    }

    void returnVolume(int id) {
        Volume volume = findByID(id);
        if(volume != null) {
            if(volume.isLent()) {
                volume.setLent(false);
                volume.setOwner(null);

                Position position = positions.get(volume.hashCode());
                position.decreaseLent();
                position.increaseAvailable();

                System.out.println("Book returned\n" + volume);
            }
            else {
                System.out.println("The book with such ID isn't currently lent!");
            }
        }
        else {
            System.out.println("The book with such ID doesn't exist!");
        }

    }

    void showVolumes() {
        String temp = "Volumes:\n";
        for (Volume volume: volumes
                ) {
            temp = temp + volume.toString() + ",\n";
        }
        System.out.print(temp);
    }

    Volume findByID(int id) {
        for (Volume volume: volumes) {
            if(volume.getId() == id)
                return volume;
        }
        return null;
    }

    ArrayList<Volume> getVolumes() {
        return this.volumes;
    }

    HashMap<Integer, Position> getPositions() {
        return this.positions;
    }

    /**
     * Overloaded function findBook
     * If the title is given - the first one should be used
     * If the title is not given, but author is given - the second one should be used
     * If only the year is given - the third one should be used
     */
    List<Volume> findBook(String title, String author, Integer year) {

        List<Volume> result;
        result = volumes.stream()
                .filter(x -> title.equals(x.getTitle()))
                .collect(Collectors.toList());

        if(author != null)
            result = result.stream()
                    .filter(x -> author.equals(x.getAuthor()))
                    .collect(Collectors.toList());

        if(year != null)
            result = result.stream()
                    .filter(x -> year.equals(x.getYear()))
                    .collect(Collectors.toList());

        return result;
    }

    List<Volume> findBook(String author, Integer year) {

        List<Volume> result;
        result = volumes.stream()
                .filter(x -> author.equals(x.getAuthor()))
                .collect(Collectors.toList());

        if(year != null)
            result = result.stream()
                    .filter(x -> year.equals(x.getYear()))
                    .collect(Collectors.toList());

        return result;
    }

    List<Volume> findBook(Integer year) {

        List<Volume> result;
        result = volumes.stream()
                .filter(x -> year.equals(x.getYear()))
                .collect(Collectors.toList());

        return result;
    }
}
