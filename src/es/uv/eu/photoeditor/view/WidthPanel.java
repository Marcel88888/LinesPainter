package es.uv.eu.photoeditor.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

public class WidthPanel extends JPanel {
    
    StatusPanel statusPanel;
    JLabel sliderTitle;
    JSlider widthSlider;
    
    public WidthPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.sliderTitle = new JLabel("Thickness of the rectangle:");
        this.widthSlider = new JSlider(1, 1000);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        /*sliderTitle.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        widthSlider.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        /*sliderTitle.setPreferredSize(new Dimension(210, 20));
        sliderTitle.setMinimumSize(sliderTitle.getPreferredSize());
        sliderTitle.setMaximumSize(sliderTitle.getPreferredSize());*/
        
        sliderTitle.setFont(new Font("Dialog", Font.BOLD, 13));
        
        widthSlider.setPreferredSize(new Dimension(1480, 75));
        widthSlider.setMinimumSize(widthSlider.getPreferredSize());
        widthSlider.setMaximumSize(widthSlider.getPreferredSize());
        widthSlider.setMajorTickSpacing(100);
        widthSlider.setMinorTickSpacing(10);
        widthSlider.setPaintTicks(true);
        widthSlider.setPaintLabels(true);
        widthSlider.setFont(new Font("Symbol", Font.PLAIN, 15));   
        
        this.add(sliderTitle);
        this.add(widthSlider);
    }

    public void setStatusPanel(StatusPanel statusPanel) {
        this.statusPanel = statusPanel;
    }

    public JSlider getWidthSlider() {
        return widthSlider;
    }
    
    public void setChangeListener(ChangeListener cl) {
        widthSlider.addChangeListener(cl);
    }
}
