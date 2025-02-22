package main.java.net.mp3skater.interfaces.ex678;

public class Wurzel extends ArgOperation
{
	public Wurzel(Operand operand, Argument argument) {
		super(operand, argument);
		this.name = "Wurzel";
	}
	public double getErgebnis() {
		assert(this.operand != null);
		assert(this.argument != null);
		if(this.argument.getErgebnis()%2==0 && this.operand.getErgebnis()<0)
			throw new ArithmeticException("Value underneath the root cannot be negative.");
		return Math.pow(this.operand.getErgebnis(), 1/this.argument.getErgebnis());
	}
}
