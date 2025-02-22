package main.java.net.mp3skater.interfaces.ex1;
/**
 * Aufgabe 1
 *
 * Es werden das Interface Groesse sowie die Klassen Auto, Fussballfeld und Papierblatt implementiert.
 * Autos verfügen über Setter-Methoden, Fussballfelder haben feste Maße (105 m x 70 m, 0 m Höhe)
 * und Papierblätter werden beim Konstruktor auf einen der Formate A0 bis A4 festgelegt.
 * Im Testprogramm wird ein Array mit zwei Autos, einem Fussballfeld und fünf Papierblättern
 * angelegt und deren Grundfläche (Länge * Breite) ausgegeben.
 */

interface Groesse {
    int getLaenge();
    int getBreite();
    int getHoehe();
}

class Auto implements Groesse {
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
    public String toString() {
        return "Auto (" + laenge + " x " + breite + " x " + hoehe + " mm)";
    }
}

class Fussballfeld implements Groesse {
    // Maße in Millimetern: 105 m = 105000 mm, 70 m = 70000 mm
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
    public String toString() {
        return "Fussballfeld (" + laenge + " x " + breite + " mm)";
    }
}

class Papierblatt implements Groesse {
    // Papierformate (Festwerte in mm)
    // A0: 1189 x 841, A1: 841 x 594, A2: 594 x 420, A3: 420 x 297, A4: 297 x 210
    private final int laenge;
    private final int breite;
    private final int hoehe = 0; // Papier hat keine Höhe

    public Papierblatt(int format) {
        // format 0 = A0, 1 = A1, 2 = A2, 3 = A3, 4 = A4
        switch(format) {
            case 0:
                laenge = 1189;
                breite = 841;
                break;
            case 1:
                laenge = 841;
                breite = 594;
                break;
            case 2:
                laenge = 594;
                breite = 420;
                break;
            case 3:
                laenge = 420;
                breite = 297;
                break;
            case 4:
                laenge = 297;
                breite = 210;
                break;
            default:
                laenge = 0;
                breite = 0;
        }
    }

    public int getLaenge() { return laenge; }
    public int getBreite() { return breite; }
    public int getHoehe() { return hoehe; }

    public int grundFlaeche() {
        return laenge * breite;
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

public class Aufgabe1 {
    public static void main(String[] args) {
        Groesse[] g = new Groesse[8];

        // Zwei Autos anlegen und ihre Maße setzen
        Auto auto1 = new Auto();
        auto1.setLaenge(4000);
        auto1.setBreite(1800);
        auto1.setHoehe(1400);

        Auto auto2 = new Auto();
        auto2.setLaenge(4200);
        auto2.setBreite(1900);
        auto2.setHoehe(1500);

        // Ein Fussballfeld anlegen
        Fussballfeld feld = new Fussballfeld();

        // Fünf Papierblätter in verschiedenen Formaten anlegen (A0 bis A4)
        Papierblatt p0 = new Papierblatt(0);
        Papierblatt p1 = new Papierblatt(1);
        Papierblatt p2 = new Papierblatt(2);
        Papierblatt p3 = new Papierblatt(3);
        Papierblatt p4 = new Papierblatt(4);

        // Array befüllen
        g[0] = auto1;
        g[1] = auto2;
        g[2] = feld;
        g[3] = p0;
        g[4] = p1;
        g[5] = p2;
        g[6] = p3;
        g[7] = p4;

        // Ausgabe der Objekte und ihrer Grundfläche (Länge * Breite)
        for (Groesse obj : g) {
            int grundFlaeche = obj.getLaenge() * obj.getBreite();
            System.out.println(obj.toString() + "  -> Grundfläche: " + grundFlaeche + " mm²");
        }
    }
}
