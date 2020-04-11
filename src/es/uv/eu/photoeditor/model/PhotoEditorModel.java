package es.uv.eu.photoeditor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PhotoEditorModel {
    private BufferedImage image;
    private String imageFileName = "";

    public PhotoEditorModel() {
        try {
            imageFileName = "images/image.jpg";
            image = ImageIO.read(new File(imageFileName));
        }
        catch (IOException e) {
            System.out.println("Error during reading the image '" + this.imageFileName + "'.");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void loadImage(File imageFile) {
        if (imageFile != null) {
            this.imageFileName = imageFile.getName();
            try {
                image = ImageIO.read(imageFile);
            }
            catch (IOException e) {
                System.out.println("Error during reading the image '" + this.imageFileName + "'.");
                System.out.println("Reason: " + e.getLocalizedMessage());
            }
        }
    }

    public void saveImage(File imagenFile) {
        if (imagenFile != null) {
            try {
                this.imageFileName = imagenFile.getName();
                ImageIO.write(image,"jpg",imagenFile);
            } 
            catch (IOException e) {
                System.out.println("Error during saving the image '" + imagenFile.getName() + "'.");
                System.out.println("Reason: " + e.getLocalizedMessage());
            }
        }
    }
    public void drawRectangle (int x, int y, int x2, int y2, int width, Color color2, Color color1){
        Graphics2D gr = (Graphics2D)image.getGraphics();
        GradientPaint gradient= new GradientPaint(0,0,color2, 175,175, color1, true);
        
        gr.setPaint(gradient);
        gr.setStroke(new BasicStroke(width));
        gr.draw(new Line2D.Double(x,y,x2,y2));   
    }
     
}
