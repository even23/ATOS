package com.atos;

public class Main {

    public static void main(String[] args) {

	    Library library = new Library();
	    library.addVolume("W pustyni i w puszczy", "Sienkiewicz", 1978);
	    library.addVolume("Hobbit", "Tolkien", 1988);

	    library.showVolumes();

	    System.out.println("Lending:");
	    library.lendVolume(1, "Kamil");
	    library.lendVolume(1, "Krzysiek");
	    library.lendVolume(3, "Marek");
        library.lendVolume(2, "Krzysiek");

        System.out.println("Returning:");
        library.returnVolume(1);
        library.returnVolume(1);
        library.returnVolume(3);

        System.out.println("Removing:");
        library.removeVolume(1);
        library.removeVolume(1);
        library.removeVolume(2);

        library.showVolumes();

        library.showPositions();

        library.removeVolume(2);
        library.removeVolume(3);
        library.removeVolume(4);

        library.showPositions();
        library.addVolume("Hobbit", "Tolkien2", 1988);
        library.showVolumes();
        library.showPositions();

        library.findBook("Tolkien", null).forEach(System.out::println);
    }
}
