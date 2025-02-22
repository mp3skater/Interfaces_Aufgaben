package main.java.net.mp3skater.interfaces.ex678;

public class Division extends Operation
{
	public Division(Operand operand0, Operand operand1) {
		super(operand0, operand1);
		setSymbol('/');
	}
	public Division() {
		super();
	}
	public double getErgebnis() {
		assert(this.getOperand(0) != null);
		assert(this.getOperand(1) != null);
		if(this.getOperand(1).getErgebnis() == 0)
			throw new ArithmeticException();
		return this.getOperand(0).getErgebnis() / this.getOperand(1).getErgebnis();
	}
}
