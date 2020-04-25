package es.uv.eu.photeditor;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import es.uv.eu.photoeditor.model.PhotoEditorModel;
import es.uv.eu.photoeditor.view.PhotoEditorView;

public class PhotoEditor {

    public static void main(String[] args) {
        PhotoEditorModel model = new PhotoEditorModel();
        PhotoEditorView view = new PhotoEditorView(model);
        new PhotoEditorController(model, view);
    }
}
