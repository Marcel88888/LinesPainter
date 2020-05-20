package es.uv.eu.photoeditor.view;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class StatusPanel extends JPanel {
    
    private PhotoEditorView view;
    private JLabel widthText;
    private JLabel widthValueLabel;
    private JLabel color1Text;
    private JLabel color1;
    private JLabel color2Text;
    private JLabel color2;
    
    public StatusPanel(PhotoEditorView view) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(1500, 50));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.view = view;
        this.widthText = new JLabel("Thickness of the rectangle:");
        this.widthValueLabel = new JLabel(String.valueOf(view.getModel().getRectangleWidth()), SwingConstants.RIGHT);
        this.color1Text = new JLabel("Color 1:");
        this.color1 = new JLabel();
        this.color2Text = new JLabel("Color 2:");
        this.color2 = new JLabel();
        
        widthValueLabel.setPreferredSize(new Dimension(37, 20));
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
        color1.setBackground(view.getModel().getChosenColor1());
        color2.setPreferredSize(colorDimension);
        color2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        color2.setMinimumSize(color2.getPreferredSize());
        color2.setMaximumSize(color2.getPreferredSize());
        color2.setOpaque(true);
        color2.setBackground(view.getModel().getChosenColor2());
        
        Dimension smallGap = new Dimension(5, 0);
        
        this.add(Box.createRigidArea(new Dimension(70, 0)));
        this.add(widthText);
        this.add(Box.createRigidArea(smallGap));
        this.add(widthValueLabel);
        this.add(Box.createHorizontalGlue());
        this.add(color1Text);
        this.add(Box.createRigidArea(smallGap));
        this.add(color1);
        this.add(Box.createHorizontalGlue());
        this.add(color2Text);
        this.add(Box.createRigidArea(smallGap));
        this.add(color2);
        this.add(Box.createHorizontalGlue());
    }

    public JLabel getWidthValueLabel() {
        return widthValueLabel;
    } 

    public JLabel getColor1() {
        return color1;
    }

    public JLabel getColor2() {
        return color2;
    }
    
    public void updateWidthValueLabel(int width) {
        widthValueLabel.setText(String.valueOf(width));
    }
}
