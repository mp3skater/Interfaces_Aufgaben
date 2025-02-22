package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

public class JTreeExample {
    public static void main(String[] args) {
        // Knoten erstellen
        Konstante zwei = new Konstante(2);
        Konstante drei = new Konstante(3);
        Konstante vier = new Konstante(4);
        Konstante sieben = new Konstante(7);

        Addition c = new Addition(drei, vier);
        Addition b = new Addition(c, zwei);
        Subtraktion d = new Subtraktion(sieben, zwei);
        TreeNode a = new Division(b, d);

        TreeModel treeModel = new DefaultTreeModel(a);
        JTree jTree = new JTree(treeModel);

        // Renderer setzen
        jTree.setCellRenderer(new MeinTreeCellRenderer());

        // GUI-Fenster erstellen
        JFrame frame = new JFrame("Mathematische Ausdrücke");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(jTree));
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
