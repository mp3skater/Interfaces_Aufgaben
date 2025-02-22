package main.java.net.mp3skater.interfaces.ex678;

import net.mp3skater.abstr.exceptions.NegativeArgumentException;

public class Argument extends Konstante {
    public Argument(double ergebnis) throws NegativeArgumentException {
        super(ergebnis);
        int erg = (int)(ergebnis);
        if(erg > 0) {
            this.setErgebnis(erg);
        }
        else {
            throw new NegativeArgumentException();
        }
    }
}
