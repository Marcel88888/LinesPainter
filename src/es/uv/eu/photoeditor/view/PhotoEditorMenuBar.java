package es.uv.eu.photoeditor.view;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PhotoEditorMenuBar extends JMenuBar {
    
    private JMenu file;
    private JMenuItem load;
    private JMenuItem save;
    private JMenuItem exit;
    
    public PhotoEditorMenuBar() {
        
        this.file = new JMenu("File");
        
        this.load = new JMenuItem("Load");
        this.save = new JMenuItem("Save");
        this.exit = new JMenuItem("Exit");
        
        load.setActionCommand("loadImage");
        save.setActionCommand("saveImage");
        exit.setActionCommand("exit");
        
        file.add(load);
        file.add(save);
        file.add(exit);
        
        this.add(file);
    }
    
    public void setActionListener(ActionListener al) {
        load.addActionListener(al);
        save.addActionListener(al);
        exit.addActionListener(al);
    }  
}