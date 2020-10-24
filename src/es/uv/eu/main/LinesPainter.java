package es.uv.eu.main;

import es.uv.eu.linespainter.controller.LinesPainterController;
import es.uv.eu.linespainter.model.LinesPainterModel;
import es.uv.eu.linespainter.view.LinesPainterView;

public class LinesPainter {

    public static void main(String[] args) {
        LinesPainterModel model = new LinesPainterModel();
        LinesPainterView view = new LinesPainterView(model);
        new LinesPainterController(model, view);
    }
}
