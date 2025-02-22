package main.java.net.mp3skater.interfaces.ex678;

public class Multiplikation extends Operation
{
	public Multiplikation(Operand operand0, Operand operand1) {
		super(operand0, operand1);
		setSymbol('*');
	}
	public Multiplikation() {
		super();
	}
	public double getErgebnis() {
		assert(this.getOperand(0) != null);
		assert(this.getOperand(1) != null);
		return this.getOperand(0).getErgebnis() * this.getOperand(1).getErgebnis();
	}
}
