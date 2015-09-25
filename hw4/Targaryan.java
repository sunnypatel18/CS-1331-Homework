import java.util.Random;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
* This class represents Targaryan house for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public class Targaryan extends House {
    private Random randomInt = new Random();
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public Targaryan(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        imageFilename = "dragon.png";
        image = new ImageIcon(imageFilename);
        age = -1;
    }
    /**
     * This method determines if two Houses can reproduce
     * @param otherHouse
     * @return if they can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Targaryan);
    }
    /**
     * This method states which House can reproduce with what House
     * @param otherHouse
     * @return if they can reproduce
     */
    public House reproduceWithHouse(House otherHouse) {
        if (canReproduceWithHouse(otherHouse)) {
            if (randomInt.nextInt(100) < 1) {
                return new Targaryan(xPos, yPos, bounds);
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
        return (!(otherHouse instanceof Baratheon) && !(otherHouse
            instanceof Targaryan) && !(otherHouse instanceof HoneyBadger));
    }
    /**
     * This method harms the other house
     * @param otherHouse
     * @return void
     */
    public void harmHouse(House otherHouse) {
        if (!(otherHouse instanceof Baratheon) && !(otherHouse
            instanceof Targaryan) && !(otherHouse instanceof HoneyBadger)) {
            otherHouse.getHealth();
        }
    }
}