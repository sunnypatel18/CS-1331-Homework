import java.awt.Rectangle;
/**
* This house represents the North house for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public abstract class SouthHouse extends House {
    private Rectangle south;
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public SouthHouse(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        south = new Rectangle(0, (int) bounds.getHeight() / 2,
            (int) bounds.getWidth(), (int) bounds.getHeight() / 2);
    }
    /**
     * This method overrides the move method and includes the modifier
     * @return void
     */
    public void move() {
        if (south.contains(getPos())) {
            speed = 15;
        } else {
            speed = 5;
        }
        super.move();
    }
}
