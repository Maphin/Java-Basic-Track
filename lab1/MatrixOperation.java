import java.util.InputMismatchException;
import java.util.Random;

/**
 * Class MatrixOperation provides operations on matrices
 * such as XOR between matrices and summing maximum elements
 * in columns.
 */
public class MatrixOperation {

    /**
     * Executes the matrix operations: XOR and column maximum sum.
     */
    public void execute() {
        try {
            int rows = 3;
            int cols = 3;

            float[][] A = generateMatrix(rows, cols);
            float[][] B = generateMatrix(rows, cols);

            System.out.println("Matrix A:");
            printMatrix(A);

            System.out.println("Matrix B:");
            printMatrix(B);

            int[][] C = xorMatrices(A, B);

            System.out.println("Result Matrix C (A XOR B):");
            printMatrix(C);

            int columnMaxSum = calculateColumnMaxSum(C);
            System.out.println("Sum of maximum elements in each column: " + columnMaxSum);

        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please ensure that the matrix elements are numbers.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Generates a matrix with random float values.
     *
     * @param rows the number of rows in the matrix
     * @param cols the number of columns in the matrix
     * @return the generated matrix
     */
    private float[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        float[][] matrix = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextFloat() * 100;
            }
        }
        return matrix;
    }

    /**
     * Performs bitwise XOR between corresponding elements of two matrices A and B.
     * First, the float values are rounded, then XOR is applied.
     *
     * @param A the first matrix
     * @param B the second matrix
     * @return the resulting matrix after XOR
     */
    private int[][] xorMatrices(float[][] A, float[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aInt = Math.round(A[i][j]);
                int bInt = Math.round(B[i][j]);

                int xorResult = aInt ^ bInt;

                C[i][j] = xorResult;
            }
        }
        return C;
    }

    /**
     * Calculates the sum of the maximum elements in each column of the matrix.
     *
     * @param matrix the matrix
     * @return the sum of maximum elements in each column
     */
    private int calculateColumnMaxSum(int[][] matrix) {
        int cols = matrix[0].length;
        int sum = 0;

        for (int j = 0; j < cols; j++) {
            int maxElement = Integer.MIN_VALUE;
            for (int[] row : matrix) {
                if (row[j] > maxElement) {
                    maxElement = row[j];
                }
            }
            sum += maxElement;
        }
        return sum;
    }

    /**
     * Prints a float matrix in a formatted manner.
     *
     * @param matrix the matrix to print
     */
    private void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    /**
     * Prints an int matrix in a formatted manner.
     *
     * @param matrix the matrix to print
     */
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%d ", value);
            }
            System.out.println();
        }
    }

    /**
     * Main method to run the MatrixOperation class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        MatrixOperation matrixOperation = new MatrixOperation();
        matrixOperation.execute();
    }
}
