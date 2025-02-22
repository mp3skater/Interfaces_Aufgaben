package main.java.net.mp3skater.interfaces.ex678;

public class Konstante extends Operand {
	private double ergebnis;

	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public Konstante() {
		this(0.0);
	}

	public double getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	/**
	 * Wird aufgerufen, wenn der Benutzer den Knoten editieren will (F2).
	 * Hier wird der interne Wert aktualisiert.
	 */
	@Override
	public void setUserObject(Object object) {
		if (object instanceof Number) {
			setErgebnis(((Number) object).doubleValue());
		} else {
			try {
				setErgebnis(Double.parseDouble(object.toString()));
			} catch (NumberFormatException e) {
				// Bei ungültiger Eingabe wird nichts geändert
			}
		}
	}

	@Override
	public String toString() {
		return String.valueOf(ergebnis);
	}
}
