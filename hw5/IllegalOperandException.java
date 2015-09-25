/**
 * This class represents Illegal Operand Exception which extends Exception.
 * @author Sunny Patel
 * @version 1.0
 */
public class IllegalOperandException extends Exception {
    /**
     * This method uses super to check for exception.
     */
    public IllegalOperandException() {
        super("Illegal Operand Exception!");
    }
    /**
     * This method takes in one string and super brings message into class
     * @param a message
     */
    public IllegalOperandException(String message) {
        super(message);
    }
}