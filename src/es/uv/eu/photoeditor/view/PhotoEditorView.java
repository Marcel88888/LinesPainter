package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class PhotoEditorView extends JFrame {
    
    PhotoEditorModel model;
    ImagePanel imagePanel;
    WidthPanel widthPanel;
    StatusPanel statusPanel;
    SelectPanel selectPanel;
    PhotoEditorMenuBar menu;
    
    
    public PhotoEditorView(PhotoEditorModel model) {
        
        super("PhotoEditor");
        this.setLayout(new BorderLayout(17, 8));
        this.setSize(1500, 1000);
        
        this.model = model;
        this.imagePanel = new ImagePanel();
        this.widthPanel = new WidthPanel();
        this.statusPanel = new StatusPanel(widthPanel);
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
    
    public void setChangeListener(ChangeListener cl) {
        widthPanel.setChangeListener(cl);
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }
}
