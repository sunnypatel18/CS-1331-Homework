import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
/**
 * This class represents the pencil tool.
 * @author Sunny Patel
 * @version 1.0
 */
public class PencilTool implements Tool {
    /**
    * Tool method that is called when the mouse is pressed.
    * Usually involves beginning drawing something.
    *
    * @param e The mouseevent that fired this onPress.
    * @param g The current graphics context.
    */
    @Override
    public void onPress(MouseEvent e, GraphicsContext g) {
        g.beginPath();
        g.moveTo(e.getX(), e.getY());
        g.stroke();
    }
    /**
    * Tool method that is called when the mouse is dragged.
    * Usually involves updating the drawing location.
    *
    * @param e The mouseevent that fired this onDrag.
    * @param g The current graphics context.
    */
    @Override
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.lineTo(e.getX(), e.getY());
        g.stroke();
    }
    /**
    * Tool method that is called when the mouse is released.
    * Usually involves completing an individual stroke/shape.
    *
    * @param e The mouseevent that fired this onRelease.
    * @param g The current graphics context.
    */
    @Override
    public void onRelease(MouseEvent e, GraphicsContext g) { }
    /**
    * The name of this tool.
    *
    * @return This tool's name.
    */
    @Override
    public String getName() {
        return "Pencil";
    }
}
