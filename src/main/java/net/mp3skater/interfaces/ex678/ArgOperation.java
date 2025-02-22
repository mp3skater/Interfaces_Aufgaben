package main.java.net.mp3skater.interfaces.ex678;

import net.mp3skater.abstr.exceptions.NoSymbolException;

public abstract class ArgOperation extends Operation {
    protected Operand operand;
    protected Argument argument;
    public String name;

    public ArgOperation(Operand operand, Argument argument) {
        this.operand = operand;
        this.argument = argument;
    }
    public String toString() throws NoSymbolException {
        return "(" + name + "(" + argument + "," + operand + ")=" + getErgebnis() + ")";
    }
    public abstract double getErgebnis();
}
