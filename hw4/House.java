import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
* This class represents House for the Game of Thrones Simulation.
* @author Sunny Patel
* @version 1.0
*/
public abstract class House {
    protected ImageIcon image;
    protected String imageFilename;
    protected int xPos;
    protected int yPos;
    protected int x = 1;
    protected int y = 1;
    protected int age;
    protected int health = 100;
    protected int count = 0;
    protected int speed = 5;
    protected Rectangle bounds;
    /**
     * This method takes in xPos, yPos, and bounds
     * @param xPos, yPos, bounds
     */
    public House(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
        if (Math.random() <= 0.5) {
            x = -x;
        }
        if (Math.random() <= 0.5) {
            y = -y;
        }
    }
    /**
     * This method draws the image on the GUI
     * @param g
     * @return void
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
    /**
     * This method moves the image in the GUI
     * @return void
     */
    protected void move() {
        if (Math.random() <= 0.05) {
            x = -x;
        } else {
            x = x;
        }
        xPos = xPos + x * (int) (Math.random() * 10) * speed;
        if (Math.random() <= 0.05) {
            y = -y;
        } else {
            y = y;
        }
        yPos = yPos + y * (int) (Math.random() * 10) * speed;
        if (yPos <= 0) {
            yPos = 0;
            y = -y;
        }
        if (xPos <= 0) {
            xPos = 0;
            x = -x;
        }
        if (yPos + image.getIconHeight() >= bounds.getHeight()) {
            yPos = (int) bounds.getHeight() - image.getIconHeight();
            y = -y;
        }
        if (xPos + image.getIconWidth() >= bounds.getWidth()) {
            xPos = (int) bounds.getWidth() - image.getIconWidth();
            x = -x;
        }
        count++;
    }
    /**
     * This method determines if two Houses collide
     * @param otherHouse
     * @return if they collide with other house
     */
    protected boolean collidesWithHouse(House otherHouse) {
        return (otherHouse.getPos().intersects(getPos()));
    }
    /**
     * This method determines if two Houses can reproduce
     * @param otherHouse
     * @return if they can reproduce
     */
    protected abstract boolean canReproduceWithHouse(House otherHouse);
    /**
     * This method states which House can reproduce with what House
     * @param otherHouse
     * @return if they can reproduce
     */
    protected abstract House reproduceWithHouse(House otherHouse);
    /**
     * This method determines if two Houses are old
     * @return if the current age is less than the max age
     */
    protected boolean isOld() {
        if (age < 0) {
            return false;
        }
        return (count >= age);
    }
    /**
     * This method determines if one house can harm the other
     * @param otherHouse
     * @return if this house can reproduce with the other house
     */
    protected abstract boolean canHarmHouse(House otherHouse);
    /**
     * This method harms the other house
     * @param otherHouse
     * @return void
     */
    protected abstract void harmHouse(House otherHouse);
    /**
     * This method kills the house
     * @return void
     */
    protected void die() {
        health = 0;
    }
    /**
     * This method determines if the house is dead
     * @return if the house is dead (health is less than or equal to 0)
     */
    protected boolean isDead() {
        return (health <= 0);
    }
    /**
     * This method gives the bounds of the image as a rectangle
     * @return bounds of image
     */
    protected Rectangle getPos() {
        return new Rectangle(xPos, yPos, image.getIconWidth(),
            image.getIconHeight());
    }
    /**
     * This method decreases the health of the house
     * @return void
     */
    protected void getHealth() {
        health = health - 10;
    }
}