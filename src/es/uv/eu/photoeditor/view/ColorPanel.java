package es.uv.eu.photoeditor.view;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class ColorPanel extends JPanel {
    
    private int colorNumber;
    private JLabel colorLabel;
    private ArrayList<JButton> colorButtons = new ArrayList<>();
    private Color[] colors;
    private String[] colorsNames;
    
    public ColorPanel(int colorNumber, Color[] colors, String[] colorsNames, String label) {
        this.setLayout(new GridLayout(7, 2, 10, 10));
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border emptyBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        Border border = BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);
        this.setBorder(border);
        this.colorNumber = colorNumber;
        this.colors = colors;
        this.colorsNames = colorsNames;
        this.colorLabel = new JLabel(label);
        this.add(colorLabel);
        for (int i=0; i<colors.length; i++) {
            JButton newButton = new JButton(colorsNames[i]);
            newButton.setBackground(colors[i]);
            if (colors[i] == Color.BLACK || colors[i] == Color.DARK_GRAY || colors[i] == Color.BLUE)
                newButton.setForeground(Color.WHITE);
            colorButtons.add(newButton);
            this.add(newButton);
        }
    }
    
    public void setActionListener (ActionListener al) {
        for (JButton colorButton: colorButtons) {
            colorButton.addActionListener(al);
            colorButton.setActionCommand("changeColor" + colorNumber);
        }
    }

    public ArrayList<JButton> getColorButtons() {
        return colorButtons;
    }
}
