package es.uv.eu.photoeditor.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

public class WidthPanel extends JPanel {
    
    private PhotoEditorView view;
    private JLabel sliderTitle;
    private JSlider widthSlider;
    
    public WidthPanel(PhotoEditorView view) {
        this.setLayout(new BorderLayout());
        this.sliderTitle = new JLabel("Thickness of the rectangle:");
        this.widthSlider = new JSlider(1, 1000);
        this.view = view;
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        sliderTitle.setFont(new Font("Dialog", Font.BOLD, 13));
        sliderTitle.setBorder(BorderFactory.createEmptyBorder(10, 8, 0, 0));
        
        widthSlider.setMajorTickSpacing(100);
        widthSlider.setMinorTickSpacing(10);
        widthSlider.setValue(view.getModel().getRectangleWidth());
        widthSlider.setPaintTicks(true);
        widthSlider.setPaintLabels(true);
        widthSlider.setFont(new Font("Symbol", Font.PLAIN, 15));   
        
        this.add(widthSlider, BorderLayout.CENTER);
        this.add(sliderTitle, BorderLayout.NORTH);
    }

    public JSlider getWidthSlider() {
        return widthSlider;
    }
    
    public void setChangeListener(ChangeListener cl) {
        widthSlider.addChangeListener(cl);
    }
}
