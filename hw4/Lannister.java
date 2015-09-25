import java.util.Random;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
* This class represents Lannister house for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public class Lannister extends SouthHouse {
    private Random randomInt = new Random();
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public Lannister(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        imageFilename = "lion.png";
        image = new ImageIcon(imageFilename);
        age = 100;
    }
    /**
     * This method determines if two Houses can reproduce
     * @param otherHouse
     * @return if they can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Baratheon
            || otherHouse instanceof Lannister);
    }
    /**
     * This method states which House can reproduce with what House
     * @param otherHouse
     * @return if they can reproduce
     */
    public House reproduceWithHouse(House otherHouse) {
        if (canReproduceWithHouse(otherHouse)) {
            if (randomInt.nextInt(100) < 1) {
                return new Lannister(xPos, yPos, bounds);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * This method determines if one house can harm the other
     * @param otherHouse
     * @return if this house can reproduce with the other house
     */
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Stark || otherHouse instanceof Tully);
    }
    /**
     * This method harms the other house
     * @param otherHouse
     * @return void
     */
    public void harmHouse(House otherHouse) {
        if (otherHouse instanceof Stark) {
            if (randomInt.nextInt(10) < 6) {
                otherHouse.getHealth();
            }
        } else if (otherHouse instanceof Tully) {
            if (randomInt.nextInt(10) < 8) {
                otherHouse.getHealth();
            }
        }
    }
}
