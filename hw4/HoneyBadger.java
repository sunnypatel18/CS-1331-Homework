import java.util.Random;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
* This class represents HoneyBadger house for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public class HoneyBadger extends House {
    private Random randomInt = new Random();
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public HoneyBadger(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        imageFilename = "honeybadger.jpg";
        image = new ImageIcon(imageFilename);
        age = -1;
    }
    /**
     * This method determines if two Houses can reproduce
     * @param otherHouse
     * @return if they can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        return false;
    }
    /**
     * This method states which House can reproduce with what House
     * @param otherHouse
     * @return if they can reproduce
     */
    public House reproduceWithHouse(House otherHouse) {
        return null;
    }
    /**
     * This method determines if one house can harm the other
     * @param otherHouse
     * @return if this house can reproduce with the other house
     */
    public boolean canHarmHouse(House otherHouse) {
        return true;
    }
    /**
     * This method harms the other house
     * @param otherHouse
     * @return void
     */
    public void harmHouse(House otherHouse) {
        otherHouse.getHealth();
        otherHouse.getHealth();
        otherHouse.getHealth();
    }
}