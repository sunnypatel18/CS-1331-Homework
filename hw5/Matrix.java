/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer
 * @version 1.2
 */
public final class Matrix {
    private final double[][] matrix;
    private final int height;
    private final int width;
    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.height = matrix.length;
        this.width = matrix[0].length;
    }
    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     * @throws MatrixIndexOutOfBoundsException if matrix is indexed out of
     *         bounds
     */
    public double get(int i, int j) {
        if (i < height && i >= 0 && j < width && j >= 0) {
            return matrix[i][j];
        } else {
            throw new MatrixIndexOutOfBoundsException("User tried to"
                + " index at" + i + " , " + j + " . Width of matrix is "
                + getWidth() + " and height of matrix is " + getHeight()
                + ".");
        }
    }
    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return height;
    }
    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return width;
    }
    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String string = "";
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                string = string + matrix[i][j] + "\t";
            }
            string = string + "\n";
        }
        return string;
    }
}