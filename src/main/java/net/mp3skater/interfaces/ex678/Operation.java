package main.java.net.mp3skater.interfaces.ex678;

public abstract class Operation extends Operand {
	protected Operand[] operand = new Operand[2];
	protected char symbol;

	public Operation(Operand operand0, Operand operand1) {
		this.setOperand(operand0);
		this.setOperand(operand1);
	}

	public Operation() {
		super();
	}

	public void setOperand(Operand op) {
		if (this.operand[0] == null) {
			this.operand[0] = op;
			this.insert(op, getChildCount());
		} else if (this.operand[1] == null) {
			this.operand[1] = op;
			this.insert(op, getChildCount());
		}
	}

	public Operand getOperand(int position) {
		if (position >= 0 && position <= 1)
			return this.operand[position];
		else
			return null;
	}

	public void vertausche() {
		if (this.operand[0] != null && this.operand[1] != null) {
			Operand temp = this.operand[0];
			this.operand[0] = this.operand[1];
			this.operand[1] = temp;
		}
	}

	public void loescheOperand(int position) {
		if (position == 0) {
			if (this.operand[1] != null) {
				this.operand[0] = this.operand[1];
				this.operand[1] = null;
			} else {
				this.operand[0] = null;
			}
		} else if (position == 1) {
			this.operand[1] = null;
		}
	}

	public abstract double getErgebnis();

	// Für Operationen wird setUserObject nicht verwendet
	@Override
	public void setUserObject(Object object) {
		// Nichts tun
	}

	@Override
	public String toString() {
		try {
			return "(" + operand[0] + symbol + operand[1] + "=" + getErgebnis() + ")";
		} catch (RuntimeException e) {
			return "Error";
		}
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
