package main.java.net.mp3skater.interfaces.ex678;

public class Potenz extends Operation {
    public Potenz(Operand operand0, Operand operand1) {
        super(operand0, operand1);
        setSymbol('^');
    }
    public Potenz() {
        super();
    }
    public double getErgebnis() {
        assert(this.getOperand(0) != null);
        assert(this.getOperand(1) != null);
        return Math.pow(this.getOperand(0).getErgebnis(), this.getOperand(1).getErgebnis());
    }
}
