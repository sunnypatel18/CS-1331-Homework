import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
/**
 * This class represents the paint application.
 * @author Sunny Patel
 * @version 1.0
 */
public class PaintFX extends Application {
    private int toolNumber = 1;
    private Canvas canv;
    private GraphicsContext graph;

    private static final int WIDTH = 1920, HEIGHT = 1080;
    /**
    * Method of controlling all parts of the canvas and GUI
    *
    * @param stage The stage object
    */
    public void start(Stage stage) {
        canv = new Canvas(WIDTH, HEIGHT);
        graph = canv.getGraphicsContext2D();
        graph.setFill(Color.WHITE);
        graph.fillRect(0, 0, WIDTH, HEIGHT);
        graph.setLineWidth(10);
        VBox mainPane = new VBox();
        HBox toolsPane = new HBox();
        ColorPicker colorPick = new ColorPicker();
        colorPick.setValue(Color.BLACK);
        Button clear = new Button("Clear");
        Button pencil = new Button("Pencil");
        Button rectangle = new Button("Rectangle");
        Button eraser = new Button("Eraser");
        colorPick.setOnAction(a -> {
                if (toolNumber < 3) {
                    graph.setStroke(colorPick.getValue());
                }
            });
        clear.setOnAction(a -> {
                graph.clearRect(0, 0, WIDTH, HEIGHT);
                graph.setFill(Color.WHITE);
                graph.fillRect(0, 0, WIDTH, HEIGHT);
            });
        pencil.setOnAction(a -> {
                toolNumber = 1;
                graph.setStroke(colorPick.getValue());
                graph.setLineWidth(10);
            });
        rectangle.setOnAction(a  -> {
                toolNumber = 2;
                graph.setFill(colorPick.getValue());
                graph.setLineWidth(10);
            });
        eraser.setOnAction(a -> {
                toolNumber = 3;
            });
        toolsPane.getChildren().addAll(colorPick, clear, pencil,
            rectangle, eraser);
        mainPane.getChildren().addAll(toolsPane, canv);
        PencilTool pencilTool = new PencilTool();
        RectangleTool rectangleTool = new RectangleTool();
        EraserTool eraserTool = new EraserTool();
        canv.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                if (toolNumber == 1) {
                    pencilTool.onPress(e, graph);
                } else if (toolNumber == 2) {
                    rectangleTool.onPress(e, graph);
                } else if (toolNumber == 3) {
                    eraserTool.onPress(e, graph);
                }
            });
        canv.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent e) -> {
                if (toolNumber == 1) {
                    pencilTool.onDrag(e, graph);
                } else if (toolNumber == 2) {
                    rectangleTool.onDrag(e, graph);
                } else if (toolNumber == 3) {
                    eraserTool.onDrag(e, graph);
                }
            });
        canv.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
                if (toolNumber == 1) {
                    pencilTool.onRelease(e, graph);
                } else if (toolNumber == 2) {
                    rectangleTool.onRelease(e, graph);
                } else if (toolNumber == 3) {
                    eraserTool.onRelease(e, graph);
                }
            });
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage.setTitle("Paint");
        stage.setScene(scene);
        stage.show();
    }
}