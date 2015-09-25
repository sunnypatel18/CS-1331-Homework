/**
 * This class represents different linear algebra operations.
 * @author Sunny Patel
 * @version 1.0
 */
public class LinearAlgebra {
    /**
     * This method takes in two variables m(matrix) and v(vector)
     * @param m matrix
     * @param v vector
     * @return result of matrix and vector multiplied
     * @throws IllegalOperandException if matrix width and vector length not
     *         equal to each other.
     */
    public static Vector matrixVectorMultiply(Matrix m, Vector v)
        throws IllegalOperandException {
        if (m.getWidth() != v.getLength()) {
            throw new IllegalOperandException("Cannot multiply a matrix"
                + " of width " + m.getWidth() + " with a vector of length "
                + v.getLength() + ".");
        } else {
            double[] newVector = new double[m.getHeight()];
            for (int i = 0; i < m.getHeight(); i++) {
                for (int j = 0; j < m.getWidth(); j++) {
                    newVector[i] = newVector[i] + m.get(i, j) * v.get(i);
                }
            }
            return new Vector(newVector);
        }
    }
    /**
     * This method takes in two varibles m1(matrix1) and m2(matrix2)
     * @param m1 matrix1
     * @param m2 matrix 2
     * @return result of adding two matrix together
     * @throws IllegalOperandException if matrix width and matrix height not
     *         equal to each other.
     */
    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {
        if (m1.getWidth() != m2.getWidth()
            || m1.getHeight() != m2.getHeight()) {
            throw new IllegalOperandException("User tried to"
                + " add a matrix with another matrix with different dimensions."
                + " Matrix 1 has width of " + m1.getWidth() + " and height of "
                + m1.getHeight() + ". Matrix 2 has width of " + m2.getWidth()
                + " and height of " + m2.getHeight() + ".");
        } else {
            double[][] newMatrix = new double[m1.getHeight()][m1.getWidth()];
            for (int i = 0; i < m1.getHeight(); i++) {
                for (int j = 0; j < m1.getWidth(); j++) {
                    newMatrix[i][j] = m1.get(i, j) + m2.get(i, j);
                }
            }
            return new Matrix(newMatrix);
        }
    }
    /**
     * This method takes in two variables v1(vector1) and v2(vector2)
     * @param v1 vector 1
     * @param v2 vector 2
     * @return result of performing dot product on the two vectors
     * @throws IllegalOperandException if vector1 length and vector2 length not
     *         equal to each other.
     */
    public static double dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("User tried to"
                + " perform dot product with two different length vectors."
                + " Vector 1 has length of " + v1.getLength()
                + " and vector 2 has length of " + v2.getLength() + ".");
        } else {
            double newVector = 0;
            for (int i = 0; i < v1.getLength(); i++) {
                newVector = newVector + (v1.get(i) * v2.get(i));
            }
            return newVector;
        }
    }
    /**
     * This method takes in two variables v1(vector1) and v2(vector2)
     * @param v1 vector 1
     * @param v2 vector 2
     * @return result of adding two vectors
     * @throws IllegalOperandException if vector1 length and vector2 length not
     *         equal to each other.
     */
    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("User tried to"
                + " add vectors with two different length vectors."
                + " Vector 1 has length of " + v1.getLength()
                + " and vector 2 has length of " + v2.getLength() + ".");
        } else {
            double[] newVector = new double[v1.getLength()];
            for (int i = 0; i < v1.getLength(); i++) {
                newVector[i] = v1.get(i) + v2.get(i);
            }
            return new Vector(newVector);
        }
    }
}