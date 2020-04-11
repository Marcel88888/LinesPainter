package es.uv.eu.photoeditor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class StatusPanel extends JPanel {
    
    WidthPanel widthPanel;
    JLabel widthText;
    JLabel widthValueLabel;
    JLabel color1Text;
    JLabel color1;
    JLabel color2Text;
    JLabel color2;
    
    public StatusPanel(WidthPanel widthPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(1500, 50));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.widthPanel = widthPanel;
        this.widthText = new JLabel("Thickness of the rectangle:");
        this.widthValueLabel = new JLabel(String.valueOf(widthPanel.getWidthSlider().getValue()), SwingConstants.RIGHT);
        this.color1Text = new JLabel("Color 1:");
        this.color1 = new JLabel();
        this.color2Text = new JLabel("Color 2:");
        this.color2 = new JLabel();
        
        widthValueLabel.setPreferredSize(new Dimension(37, 20));
        widthValueLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        widthValueLabel.setMinimumSize(widthValueLabel.getPreferredSize());
        widthValueLabel.setMaximumSize(widthValueLabel.getPreferredSize());
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 1);
        Border border = BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);
        widthValueLabel.setBorder(border);
        
        Dimension colorDimension = new Dimension(80, 25);
        color1.setPreferredSize(colorDimension);
        color1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        color1.setMinimumSize(color1.getPreferredSize());
        color1.setMaximumSize(color1.getPreferredSize());
        color1.setOpaque(true);
        color1.setBackground(Color.BLACK);
        color2.setPreferredSize(colorDimension);
        color2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        color2.setMinimumSize(color2.getPreferredSize());
        color2.setMaximumSize(color2.getPreferredSize());
        color2.setOpaque(true);
        color2.setBackground(Color.BLACK);
        
        Dimension smallGap = new Dimension(5, 0);
        Dimension bigGap = new Dimension(270, 0);
        
        this.add(Box.createRigidArea(new Dimension(70, 0)));
        this.add(widthText);
        this.add(Box.createRigidArea(smallGap));
        this.add(widthValueLabel);
        this.add(Box.createRigidArea(bigGap));
        this.add(color1Text);
        this.add(Box.createRigidArea(smallGap));
        this.add(color1);
        this.add(Box.createRigidArea(bigGap));
        this.add(color2Text);
        this.add(Box.createRigidArea(smallGap));
        this.add(color2);
    }

    public JLabel getWidthValueLabel() {
        return widthValueLabel;
    }  
}
