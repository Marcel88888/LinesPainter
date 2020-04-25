package es.uv.eu.photoeditor.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class SelectPanel extends JPanel {
    
    private Color[] colors = {Color.BLACK, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    private String[] colorsNames = {"Black", "Cyan", "Dark grey", "Grey", "Light grey", "Magenta", "Orange",
    "Pink", "Yellow", "White", "Red", "Blue", "Green"};
    private ColorPanel colorPanel1;
    private ColorPanel colorPanel2;
    
    public SelectPanel() {
        this.setLayout(new GridLayout(2, 1, 0, 5));
        this.colorPanel1 = new ColorPanel(1, colors, colorsNames, "Color 1:");
        this.colorPanel2 = new ColorPanel(2, colors, colorsNames, "Color 2:");
        this.add(colorPanel1);
        this.add(colorPanel2);
    }
    
    public void setActionListener (ActionListener al) {
        colorPanel1.setActionListener(al);
        colorPanel2.setActionListener(al);
    }

    public Color[] getColors() {
        return colors;
    }

    public ColorPanel getColorPanel1() {
        return colorPanel1;
    }

    public ColorPanel getColorPanel2() {
        return colorPanel2;
    }
}
