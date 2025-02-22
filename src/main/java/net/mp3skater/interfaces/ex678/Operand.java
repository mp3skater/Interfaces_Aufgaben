package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public abstract class Operand implements MutableTreeNode {
	protected MutableTreeNode parent;
	protected List<MutableTreeNode> children = new ArrayList<>();

	public abstract double getErgebnis();

	@Override
	public void insert(MutableTreeNode child, int index) {
		children.add(index, child);
		child.setParent(this);
	}

	@Override
	public void remove(int index) {
		MutableTreeNode child = children.remove(index);
		child.setParent(null);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if (children.remove(node)) {
			node.setParent(null);
		}
	}

	/**
	 * Standardmäßig wird bei Operationen nichts gemacht.
	 * In der Klasse Konstante wird diese Methode überschrieben,
	 * um den internen Wert anzupassen.
	 */
	@Override
	public void setUserObject(Object object) {
		// Default: tut nichts
	}

	@Override
	public void removeFromParent() {
		if (parent != null) {
			parent.remove(this);
			parent = null;
		}
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = newParent;
	}

	@Override
	public MutableTreeNode getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public MutableTreeNode getParent() {
		return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	@Override
	public Enumeration children() {
		return Collections.enumeration(children);
	}
}
