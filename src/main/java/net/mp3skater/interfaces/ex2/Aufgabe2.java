package main.java.net.mp3skater.interfaces.ex2;

/**
 * Aufgabe 2
 *
 * Es wird erweitert, dass Autos, Fussballfelder und Papierblätter anhand ihrer Grundfläche
 * (Länge * Breite) miteinander vergleichbar sind. Dazu implementieren alle Klassen neben
 * Groesse auch das Interface Comparable. Anschließend wird ein unsortiertes Array mit 3 Autos,
 * 2 Fussballfeldern und 5 Papierblättern angelegt und mittels "Sortieren durch Minimumsuche" sortiert.
 */

interface Groesse {
    int getLaenge();
    int getBreite();
    int getHoehe();
}

class Auto implements Groesse, Comparable {
    private int laenge;
    private int breite;
    private int hoehe;

    public Auto() { }

    public void setLaenge(int laenge) { this.laenge = laenge; }
    public void setBreite(int breite) { this.breite = breite; }
    public void setHoehe(int hoehe) { this.hoehe = hoehe; }

    public int getLaenge() { return laenge; }
    public int getBreite() { return breite; }
    public int getHoehe() { return hoehe; }

    public int grundFlaeche() {
        return laenge * breite;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Groesse))
            throw new ClassCastException("Nicht kompatibles Objekt");
        Groesse other = (Groesse) o;
        int thisArea = this.getLaenge() * this.getBreite();
        int otherArea = other.getLaenge() * other.getBreite();
        return Integer.compare(thisArea, otherArea);
    }

    @Override
    public String toString() {
        return "Auto (" + laenge + " x " + breite + " x " + hoehe + " mm)";
    }
}

class Fussballfeld implements Groesse, Comparable {
    private final int laenge = 105000;
    private final int breite = 70000;
    private final int hoehe = 0;

    public int getLaenge() { return laenge; }
    public int getBreite() { return breite; }
    public int getHoehe() { return hoehe; }

    public int grundFlaeche() {
        return laenge * breite;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Groesse))
            throw new ClassCastException("Nicht kompatibles Objekt");
        Groesse other = (Groesse) o;
        int thisArea = this.getLaenge() * this.getBreite();
        int otherArea = other.getLaenge() * other.getBreite();
        return Integer.compare(thisArea, otherArea);
    }

    @Override
    public String toString() {
        return "Fussballfeld (" + laenge + " x " + breite + " mm)";
    }
}

class Papierblatt implements Groesse, Comparable {
    private final int laenge;
    private final int breite;
    private final int hoehe = 0;

    public Papierblatt(int format) {
        switch(format) {
            case 0:
                laenge = 1189; breite = 841;
                break;
            case 1:
                laenge = 841; breite = 594;
                break;
            case 2:
                laenge = 594; breite = 420;
                break;
            case 3:
                laenge = 420; breite = 297;
                break;
            case 4:
                laenge = 297; breite = 210;
                break;
            default:
                laenge = 0; breite = 0;
        }
    }

    public int getLaenge() { return laenge; }
    public int getBreite() { return breite; }
    public int getHoehe() { return hoehe; }

    public int grundFlaeche() {
        return laenge * breite;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Groesse))
            throw new ClassCastException("Nicht kompatibles Objekt");
        Groesse other = (Groesse) o;
        int thisArea = this.getLaenge() * this.getBreite();
        int otherArea = other.getLaenge() * other.getBreite();
        return Integer.compare(thisArea, otherArea);
    }

    @Override
    public String toString() {
        String format;
        if (laenge == 1189 && breite == 841) format = "A0";
        else if (laenge == 841 && breite == 594) format = "A1";
        else if (laenge == 594 && breite == 420) format = "A2";
        else if (laenge == 420 && breite == 297) format = "A3";
        else if (laenge == 297 && breite == 210) format = "A4";
        else format = "unbekannt";
        return "Papierblatt " + format + " (" + laenge + " x " + breite + " mm)";
    }
}

public class Aufgabe2 {
    public static void main(String[] args) {
        // Array mit 10 Elementen: 3 Autos, 2 Fussballfelder, 5 Papierblätter
        Groesse[] g = new Groesse[10];

        // Drei Autos
        Auto auto1 = new Auto();
        auto1.setLaenge(4000); auto1.setBreite(1800); auto1.setHoehe(1400);
        Auto auto2 = new Auto();
        auto2.setLaenge(4200); auto2.setBreite(1900); auto2.setHoehe(1500);
        Auto auto3 = new Auto();
        auto3.setLaenge(3900); auto3.setBreite(1750); auto3.setHoehe(1350);

        // Zwei Fussballfelder
        Fussballfeld feld1 = new Fussballfeld();
        Fussballfeld feld2 = new Fussballfeld();

        // Fünf Papierblätter (verschiedene Formate)
        Papierblatt p0 = new Papierblatt(0);
        Papierblatt p1 = new Papierblatt(1);
        Papierblatt p2 = new Papierblatt(2);
        Papierblatt p3 = new Papierblatt(3);
        Papierblatt p4 = new Papierblatt(4);

        g[0] = auto1;
        g[1] = auto2;
        g[2] = auto3;
        g[3] = feld1;
        g[4] = feld2;
        g[5] = p0;
        g[6] = p1;
        g[7] = p2;
        g[8] = p3;
        g[9] = p4;

        // Sortieren durch Minimumsuche (Selection Sort)
        for (int i = 0; i < g.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < g.length; j++) {
                if (((Comparable)g[j]).compareTo(g[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Tausch
            Groesse temp = g[i];
            g[i] = g[minIndex];
            g[minIndex] = temp;
        }

        // Ausgabe der sortierten Liste anhand der berechneten Grundfläche
        System.out.println("Sortierte Liste (nach Grundfläche):");
        for (Groesse obj : g) {
            int area = obj.getLaenge() * obj.getBreite();
            System.out.println(obj.toString() + "  -> Grundfläche: " + area + " mm²");
        }
    }
}
