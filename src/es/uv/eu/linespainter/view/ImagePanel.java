package es.uv.eu.linespainter.view;

import es.uv.eu.linespainter.model.LinesPainterModel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class ImagePanel extends JPanel {
    
    private LinesPainterModel model;
    
    public ImagePanel(LinesPainterModel model) {
        this.model = model;
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    }
    
    @Override
    protected void paintComponent(Graphics graphic) { 
        super.paintComponent(graphic);
        graphic.drawImage(model.getImage(), 0, 0, this);
    }
    
    public void setMouseListener (MouseAdapter ma) {
        this.addMouseListener(ma);
    }
}
