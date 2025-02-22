package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.KeyEvent;

public class JTreeExample {
    public static void main(String[] args) {
        // Erstellen des unsichtbaren Wurzelknotens
        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("unsichtbareWurzel");
        // Als Startknoten wird eine Konstante hinzugefügt
        wurzel.add(new Konstante(3.0));

        DefaultTreeModel treeModel = new DefaultTreeModel(wurzel);
        JTree jTree = new JTree(treeModel);
        jTree.setEditable(true);
        jTree.setRootVisible(false);

        // GUI-Fenster erstellen
        JFrame frame = new JFrame("Mathematische Ausdrücke bearbeiten");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(jTree));
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Beispielhafter KeyListener: Mit der Taste INSERT wird ein neuer Konstante-Knoten eingefügt
        jTree.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
                    if (jTree.getSelectionPath() == null) {
                        // Kein Knoten ausgewählt – neuer Knoten wird an die Wurzel gehängt,
                        // falls die Wurzel noch keinen Kindknoten besitzt
                        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                        if (root.getChildCount() == 0) {
                            model.insertNodeInto(new Konstante(0.0), root, 0);
                            model.reload();
                        }
                    } else {
                        // Es wurde ein Knoten ausgewählt – neuer Knoten wird diesem hinzugefügt,
                        // wenn es sich um einen Operation-Knoten handelt und noch Platz für einen zweiten Operanden besteht.
                        MutableTreeNode selectedNode = (MutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
                        if (selectedNode instanceof Operation && selectedNode.getChildCount() < 2) {
                            model.insertNodeInto(new Konstante(0.0), selectedNode, 0);
                            TreePath treePath = jTree.getSelectionPath();
                            model.reload();
                            jTree.expandPath(treePath);
                        }
                    }
                }
            }
        });
    }
}
