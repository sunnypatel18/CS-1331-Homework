/**
 * This class represents the Vector Index Out Of Bounds Exception which extends
 * IndexOutOfBoundsException
 * @author Sunny Patel
 * @version 1.0
 */
public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    /**
     * This method uses super to check for exception for vector out of bounds.
     */
    public VectorIndexOutOfBoundsException() {
        super("Vector Index Out Of Bounds Exception!");
    }
    /**
     * This method takes in one string and super brings message into class.
     * @param a message
     */
    public VectorIndexOutOfBoundsException(String message) {
        super(message);
    }
}