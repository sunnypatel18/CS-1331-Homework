/**
 * This class represents the Matrix Index Out Of Bounds Exception which extends
 * IndexOutOfBoundsException
 * @author Sunny Patel
 * @version 1.0
 */
public class MatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {
    /**
     * This method uses super to check for exception for matrix out of bounds.
     */
    public MatrixIndexOutOfBoundsException() {
        super("Matrix Index Out Of Bounds Exception!");
    }
    /**
     * This method takes in one string and super brings message into class.
     * @param a message
     */
    public MatrixIndexOutOfBoundsException(String message) {
        super(message);
    }
}