package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import es.uv.eu.photoeditor.view.LoadImage;
import es.uv.eu.photoeditor.view.PhotoEditorView;
import es.uv.eu.photoeditor.view.SaveImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
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
        view.setActionListener(new PhotoEditorActionListener());
        view.setMouseListener(new PhotoEditorMouseListener());
    }
    
    class PhotoEditorActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            if (ae.getSource() instanceof JButton) {
                JButton button = (JButton) ae.getSource();
                switch (command) {
                    case "changeColor1":
                        view.getStatusPanel().getColor1().setBackground(button.getBackground());
                        break;
                    case "changeColor2":
                        view.getStatusPanel().getColor2().setBackground(button.getBackground());
                        break;
                    default:
                        System.out.println("Controller: Command " + command + 
                            " no recognised.");
                        break;
                }
            }
            else {
                switch (command) {
                    case "loadImage":
                        LoadImage imageLoader = new LoadImage();
                        model.loadImage(imageLoader.getFile());
                        view.getImagePanel().repaint();
                        break;
                    case "saveImage":
                        SaveImage imageSaver = new SaveImage();
                        model.saveImage(imageSaver.getFile());
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("Controller: Command " + command + 
                            " no recognised.");
                        break;    
                }
            }
        }
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
    
    class PhotoEditorMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1)
            {
                System.out.println(me.getX());
                System.out.println(me.getY());
                model.drawRectangle(me.getX(), me.getY(), 100, 100, 50, Color.black, Color.black);
                view.getImagePanel().repaint();
            }
            else if(me.getButton() == MouseEvent.BUTTON3)
            {
                System.err.println("bbb");
            }
        }
    }
}
