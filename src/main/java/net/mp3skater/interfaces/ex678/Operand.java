package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Enumeration;

public abstract class Operand implements TreeNode
{
	public abstract double getErgebnis();
	protected TreeNode parent;

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public int getChildCount() {
		return 0; // Standardmäßig keine Kinder (für Konstanten)
	}

	@Override
	public boolean getAllowsChildren() {
		return false; // Konstanten haben keine Kinder
	}

	@Override
	public boolean isLeaf() {
		return true; // Konstanten sind Blätter im Baum
	}

	@Override
	public Enumeration<TreeNode> children() {
		return Collections.emptyEnumeration(); // Keine Kinder
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1; // Keine Kinder, daher ungültiger Index
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null; // Keine Kinder
	}
}
