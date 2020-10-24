package es.uv.eu.linespainter.controller;

import es.uv.eu.linespainter.model.LinesPainterModel;
import es.uv.eu.linespainter.view.LoadImage;
import es.uv.eu.linespainter.view.LinesPainterView;
import es.uv.eu.linespainter.view.SaveImage;
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

public class LinesPainterController {
    
    private LinesPainterModel model;
    private LinesPainterView view;
    
    public LinesPainterController(LinesPainterModel model, LinesPainterView view) {
        this.model = model;
        this.view = view;
        view.addWindowListener(new LinesPainterWindowListener());
        view.setChangeListener(new LinesPainterChangeListener());
        view.setActionListener(new LinesPainterActionListener());
        view.setMouseListener(new LinesPainterMouseListener());
    }
    
    private class LinesPainterActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            if (ae.getSource() instanceof JButton) {
                JButton button = (JButton) ae.getSource();
                switch (command) {
                    case "changeColor1":
                        model.setChosenColor1(view.getColor1ByButton(button));
                        view.updateStatusPanelColor1(model.getChosenColor1());
                        break;
                    case "changeColor2":
                        model.setChosenColor2(view.getColor2ByButton(button));
                        view.updateStatusPanelColor2(model.getChosenColor2());
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
    
    private class LinesPainterWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    private class LinesPainterChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            int currentWidth = ((JSlider)ce.getSource()).getValue();
            model.setRectangleWidth(currentWidth);
            view.updateStatusPanelWidthValue(model.getRectangleWidth());
        }
    }
    
    private class LinesPainterMouseListener extends MouseAdapter {
        
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
                        model.getRectangleWidth(),
                        model.getChosenColor1(), 
                        model.getChosenColor2());
                view.getImagePanel().repaint();
            }
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON3 && model.getChosenColor1() != model.getChosenColor2()) {
                model.setChosenColor2(model.getChosenColor1());
                view.updateStatusPanelColor2(model.getChosenColor2());
            }
        }
    }
}
