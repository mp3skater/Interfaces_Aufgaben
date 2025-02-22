package main.java.net.mp3skater.interfaces.ex3;

/**
 * Aufgabe 3
 *
 * Es wird das gegebene Programm so umgeschrieben, dass statt der abstrakten Klasse Funktion ein Interface Funktion verwendet wird.
 * Die Klassen Quadrat und Wurzel implementieren nun das Interface Funktion.
 */

interface Funktion {
    double compute(double x);
}

class Quadrat implements Funktion {
    @Override
    public double compute(double x) {
        return x * x;
    }
}

class Wurzel implements Funktion {
    @Override
    public double compute(double x) {
        return Math.sqrt(x);
    }
}

public class Aufgabe3 {
    public static void printTable(Funktion funktion) {
        System.out.println("Wertetabelle für " + funktion.getClass().getName());
        for (double x = 0.0; x <= 5.0; x += 1) {
            System.out.println(x + " -> " + funktion.compute(x));
        }
    }

    public static void main(String[] args) {
        printTable(new Wurzel());
        printTable(new Quadrat());
    }
}
