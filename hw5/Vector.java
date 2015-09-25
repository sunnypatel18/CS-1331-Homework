/**
 * Immutable abstraction for Vector
 *
 * @author Michael Maurer
 * @version 1.2
 */
public final class Vector {
    private final double[] vector;
    private final int length;
    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(double[] vector) {
        this.vector = vector;
        this.length = vector.length;
    }
    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return double located at index 'i' in vector
     * @throws VectorIndexOutOfBoundsException if vector is indexed out of
     *         bounds
     */
    public double get(int i) {
        if (i < length && i >= 0) {
            return vector[i];
        } else {
            throw new VectorIndexOutOfBoundsException("User tried to"
                + " index at" + i + " . Length of vector is " + getLength()
                + ".");
        }
    }
    /**
     * Get's the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }
    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String string = "";
        for (int i = 0; i < length; i++) {
            string = string + vector[i] + "\t";
        }
        return string;
    }
}