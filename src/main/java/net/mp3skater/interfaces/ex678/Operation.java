package main.java.net.mp3skater.interfaces.ex678;

import net.mp3skater.abstr.exceptions.NoSymbolException;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public abstract class Operation extends Operand {
	private Operand[] operand = new Operand[2];
	protected char symbol;

	public Operation(Operand operand0, Operand operand1) {
		this.setOperand(operand0);
		this.setOperand(operand1);
	}

	public Operation() {
		super();
	}

	// Fügt einen Operanden hinzu und setzt den Parent des Operanden
	public void setOperand(Operand op) {
		if (this.operand[0] == null) {
			this.operand[0] = op;
			op.setParent(this);
		} else if (this.operand[1] == null) {
			this.operand[1] = op;
			op.setParent(this);
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

	// TreeNode-Methoden, die überschrieben werden müssen:

	@Override
	public TreeNode getChildAt(int childIndex) {
		List<Operand> children = new ArrayList<>();
		if (operand[0] != null) children.add(operand[0]);
		if (operand[1] != null) children.add(operand[1]);
		if (childIndex < 0 || childIndex >= children.size())
			throw new ArrayIndexOutOfBoundsException("Index " + childIndex + " out of range");
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		int count = 0;
		if (operand[0] != null) count++;
		if (operand[1] != null) count++;
		return count;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return getChildCount() == 0;
	}

	@Override
	public Enumeration<TreeNode> children() {
		List<TreeNode> children = new ArrayList<>();
		if (operand[0] != null) children.add(operand[0]);
		if (operand[1] != null) children.add(operand[1]);
		return Collections.enumeration(children);
	}

	@Override
	public int getIndex(TreeNode node) {
		if (operand[0] == node) return 0;
		if (operand[1] == node) return 1;
		return -1;
	}

	@Override
	public String toString() throws NoSymbolException {
		try {
			return "(" + operand[0] + symbol + operand[1] + "=" + getErgebnis() + ")";
		} catch (RuntimeException e) {
			throw new NoSymbolException(e.getMessage());
		}
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	// Diese Methode muss von konkreten Operationen implementiert werden.
	public abstract double getErgebnis();
}
