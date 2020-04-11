package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import es.uv.eu.photoeditor.view.PhotoEditorView;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class PhotoEditorController {
    
    private PhotoEditorModel model;
    private PhotoEditorView view;
    
    public PhotoEditorController(PhotoEditorModel model, PhotoEditorView view) {
        this.model = model;
        this.view = view;
        view.addWindowListener(new PhotoEditorWindowListener());
        view.setChangeListener(new PhotoEditorChangeListener());
    }
    
    class PhotoEditorWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    class PhotoEditorChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            int currentWidth = ((JSlider)ce.getSource()).getValue();
            view.getStatusPanel().getWidthValueLabel().setText(String.valueOf(currentWidth));
        }
    }
    
}
