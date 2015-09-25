import java.awt.Rectangle;
/**
* This house represents the North house for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public abstract class NorthHouse extends House {
    private Rectangle north;
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public NorthHouse(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        north = new Rectangle(0, 0, (int) bounds.getWidth(),
            (int) bounds.getHeight() / 2);
    }
    /**
     * This method overrides the move method and includes the modifier
     * @return void
     */
    public void move() {
        if (north.contains(getPos())) {
            health = health + 1;
        }
        super.move();
    }
}
