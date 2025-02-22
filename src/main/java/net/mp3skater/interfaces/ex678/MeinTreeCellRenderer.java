package main.java.net.mp3skater.interfaces.ex678;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MeinTreeCellRenderer extends DefaultTreeCellRenderer {

    private ImageIcon additionIcon;
    private ImageIcon subtraktionIcon;
    private ImageIcon multiplikationIcon;
    private ImageIcon divisionIcon;
    private ImageIcon konstanteIcon;

    public MeinTreeCellRenderer() {
        // Icons laden (Bilder müssen im Ressourcen-Ordner sein)
        additionIcon = loadIcon("icons/addition.gif");
        subtraktionIcon = loadIcon("icons/subtraktion.gif");
        multiplikationIcon = loadIcon("icons/multiplikation.gif");
        divisionIcon = loadIcon("icons/division.gif");
        konstanteIcon = loadIcon("icons/konstante.gif");
    }

    private ImageIcon loadIcon(String path) {
        URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Konnte Icon nicht laden: " + path);
            return null;
        }
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (value instanceof Addition) {
            label.setIcon(additionIcon);
        } else if (value instanceof Subtraktion) {
            label.setIcon(subtraktionIcon);
        } else if (value instanceof Multiplikation) {
            label.setIcon(multiplikationIcon);
        } else if (value instanceof Division) {
            label.setIcon(divisionIcon);
        } else if (value instanceof Konstante) {
            label.setIcon(konstanteIcon);
        }

        return label;
    }
}