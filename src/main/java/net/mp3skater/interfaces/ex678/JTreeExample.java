package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class JTreeExample {
    public static void main(String[] args) {
        // Erzeuge einen unsichtbaren Wurzelknoten
        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("unsichtbareWurzel");
        // Beispiel: Hänge eine Konstante an die Wurzel
        wurzel.add(new Konstante(3.0));

        DefaultTreeModel treeModel = new DefaultTreeModel(wurzel);
        JTree jTree = new JTree(treeModel);
        jTree.setEditable(true);
        jTree.setRootVisible(false);

        // GUI-Fenster
        JFrame frame = new JFrame("Mathematische Ausdrücke");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(jTree));
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
