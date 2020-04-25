package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import es.uv.eu.photoeditor.view.LoadImage;
import es.uv.eu.photoeditor.view.PhotoEditorView;
import es.uv.eu.photoeditor.view.SaveImage;
import es.uv.eu.photoeditor.view.SelectPanel;
import es.uv.eu.photoeditor.view.StatusPanel;
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
    
    private class PhotoEditorActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            if (ae.getSource() instanceof JButton) {
                JButton button = (JButton) ae.getSource();
                SelectPanel selectPanel = view.getSelectPanel();
                switch (command) {
                    case "changeColor1":
                        model.setChosenColor1(selectPanel.getColors()[selectPanel.getColorPanel1().getColorButtons().indexOf(button)]);
                        view.getStatusPanel().getColor1().setBackground(model.getChosenColor1());
                        break;
                    case "changeColor2":
                        model.setChosenColor2(selectPanel.getColors()[selectPanel.getColorPanel2().getColorButtons().indexOf(button)]);
                        view.getStatusPanel().getColor2().setBackground(model.getChosenColor2());
                        break;
                    default:
                        System.out.println("Controller: Command " + command + 
                            " not recognised.");
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
                            " not recognised.");
                        break;    
                }
            }
        }
    }
    
    private class PhotoEditorWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    private class PhotoEditorChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            int currentThickness = ((JSlider)ce.getSource()).getValue();
            model.setRectangleThickness(currentThickness);
            view.getStatusPanel().getWidthValueLabel().setText(String.valueOf(model.getRectangleThickness()));
        }
    }
    
    private class PhotoEditorMouseListener extends MouseAdapter {
        
        private int xStartingPoint, yStartingPoint;

        @Override
        public void mousePressed(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1) {
                xStartingPoint = me.getX();
                yStartingPoint = me.getY();
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1) {
                model.drawRectangle(xStartingPoint, yStartingPoint, me.getX(), me.getY(),
                        model.getRectangleThickness(),
                        model.getChosenColor1(), 
                        model.getChosenColor2());
                view.getImagePanel().repaint();
            }
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON3 && model.getChosenColor1() != model.getChosenColor2()) {
                StatusPanel statusPanel = view.getStatusPanel();
                model.setChosenColor2(model.getChosenColor1());
                statusPanel.getColor2().setBackground(model.getChosenColor1());
            }
        }
    }
}
