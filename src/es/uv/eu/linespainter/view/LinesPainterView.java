package es.uv.eu.linespainter.view;

import es.uv.eu.linespainter.model.LinesPainterModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class LinesPainterView extends JFrame {
    
    private LinesPainterModel model;
    private ImagePanel imagePanel;
    private WidthPanel widthPanel;
    private StatusPanel statusPanel;
    private SelectPanel selectPanel;
    private LinesPainterMenuBar menu;
    
    
    public LinesPainterView(LinesPainterModel model) {
        
        super("LinesPainter");
        this.setLayout(new BorderLayout(17, 8));
        this.setSize(1675, 1000);
        
        this.model = model;
        this.imagePanel = new ImagePanel(model);
        this.widthPanel = new WidthPanel(this);
        this.statusPanel = new StatusPanel(this);
        this.selectPanel = new SelectPanel();
        this.menu = new LinesPainterMenuBar();
        
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(widthPanel, BorderLayout.NORTH);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(selectPanel, BorderLayout.WEST);
        this.setJMenuBar(menu);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, this.getBackground()));
        this.setVisible(true);
    }

    public LinesPainterModel getModel() {
        return model;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public SelectPanel getSelectPanel() {
        return selectPanel;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public WidthPanel getWidthPanel() {
        return widthPanel;
    }
    
    public void setChangeListener(ChangeListener cl) {
        widthPanel.setChangeListener(cl);
    }
     
    public void setActionListener(ActionListener al) {
        selectPanel.setActionListener(al);
        menu.setActionListener(al);
    }
    
    public void setMouseListener(MouseAdapter ma) {
        imagePanel.setMouseListener(ma);
    }
    
    public void updateStatusPanelWidthValue(int width) {
        statusPanel.updateWidthValueLabel(width);
    }
    
    public void updateStatusPanelColor1(Color color1) {
        statusPanel.getColor1().setBackground(color1);
    }
    
    public void updateStatusPanelColor2(Color color2) {
        statusPanel.getColor2().setBackground(color2);
    }
    
    public Color getColor1ByButton(JButton button) {
        return selectPanel.getColor1ByButton(button);
    }
    
    public Color getColor2ByButton(JButton button) {
        return selectPanel.getColor2ByButton(button);
    }
}
