package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class PhotoEditorView extends JFrame {
    
    private PhotoEditorModel model;
    private ImagePanel imagePanel;
    private WidthPanel widthPanel;
    private StatusPanel statusPanel;
    private SelectPanel selectPanel;
    private PhotoEditorMenuBar menu;
    
    
    public PhotoEditorView(PhotoEditorModel model) {
        
        super("PhotoEditor");
        this.setLayout(new BorderLayout(17, 8));
        this.setSize(1675, 1000);
        
        this.model = model;
        this.imagePanel = new ImagePanel(model);
        this.widthPanel = new WidthPanel(this);
        this.statusPanel = new StatusPanel(this, widthPanel);
        widthPanel.setStatusPanel(statusPanel);
        this.selectPanel = new SelectPanel();
        this.menu = new PhotoEditorMenuBar();
        
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(widthPanel, BorderLayout.NORTH);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(selectPanel, BorderLayout.WEST);
        this.setJMenuBar(menu);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, this.getBackground()));
        this.setVisible(true);
    }

    public PhotoEditorModel getModel() {
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
}
