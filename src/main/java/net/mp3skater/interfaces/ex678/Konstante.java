package main.java.net.mp3skater.interfaces.ex678;

public class Konstante extends Operand {
	protected double ergebnis;

	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public Konstante() {
		this(0.0);
	}

	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public double getErgebnis() {
		return ergebnis;
	}

	// Konstanten dürfen keine Kinder haben
	@Override
	public void insert(javax.swing.tree.MutableTreeNode child, int index) {
		throw new UnsupportedOperationException("Konstante kann keine Kinder haben.");
	}

	@Override
	public void remove(int index) {
		throw new UnsupportedOperationException("Konstante hat keine Kinder.");
	}

	@Override
	public void remove(javax.swing.tree.MutableTreeNode node) {
		throw new UnsupportedOperationException("Konstante hat keine Kinder.");
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	/**
	 * Wird beim Bearbeiten des Knotens (z. B. F2) aufgerufen.
	 * Hier wird versucht, den übergebenen String in einen double-Wert
	 * zu konvertieren und als neuen Wert zu setzen.
	 */
	@Override
	public void setUserObject(Object object) {
		try {
			double value = Double.parseDouble(object.toString());
			this.ergebnis = value;
		} catch (NumberFormatException e) {
			System.err.println("Ungültiger Wert: " + object);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(ergebnis);
	}
}
