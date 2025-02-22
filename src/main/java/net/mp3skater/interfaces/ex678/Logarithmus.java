package main.java.net.mp3skater.interfaces.ex678;

public class Logarithmus extends ArgOperation
{
	public Logarithmus(Operand operand, Argument argument) {
		super(operand, argument);
		this.name = "Log";
	}
	public double getErgebnis() {
		assert(this.argument != null);
		assert(this.operand != null);
		if(argument.getErgebnis() == 1)
			throw new ArithmeticException("Can't have a logarithmic base of 1.");
		if(operand.getErgebnis() == 0)
			throw new ArithmeticException("Can't have a log of 0.");
		return Math.log(this.operand.getErgebnis()) / Math.log(this.argument.getErgebnis());
	}
}
