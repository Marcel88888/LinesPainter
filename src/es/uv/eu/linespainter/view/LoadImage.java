package es.uv.eu.linespainter.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadImage extends JFileChooser {
    
    private static final String[] EXTENSIONS = { "jpg", "jpeg", "png", "gif",
        "tiff", "JPG", "JPEG" };
    
    public LoadImage() {
        super();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Images", EXTENSIONS);
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.setDialogType(JFileChooser.OPEN_DIALOG);
        this.setFileFilter(extensionFilter);
        this.setVisible(true);
    }
  
    public File getFile() {
        int ret = showDialog(null, "Open image");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        }
        else {
            return null;
        }
    }
}