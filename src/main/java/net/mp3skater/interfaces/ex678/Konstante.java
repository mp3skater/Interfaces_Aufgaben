package main.java.net.mp3skater.interfaces.ex678;

public class Konstante extends Operand {
	private double ergebnis;

	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public double getErgebnis() {
		return this.ergebnis;
	}

	@Override
	public String toString() {
		return String.valueOf(this.ergebnis);
	}
}
