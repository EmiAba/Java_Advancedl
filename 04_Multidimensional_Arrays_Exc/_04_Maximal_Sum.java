package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _04_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int maxSum = Integer.MIN_VALUE;
        int[][] matrix = new int[row][col];
        int maxMatrixRow = 0;
        int maxMatrixCol = 0;

        fillMatrix(scanner, matrix);
        int sumMatrix;

        // Loop through the matrix, but avoid the last two rows and columns to stay within bounds
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                sumMatrix = matrix[r][c] + matrix[r][c+1] + matrix[r][c+2] +
                        matrix[r+1][c] + matrix[r+1][c+1] + matrix[r+1][c+2] +
                        matrix[r+2][c] + matrix[r+2][c+1] + matrix[r+2][c+2];

                // Debugging output to track the sum of each 3x3 submatrix
               // System.out.printf("Sum of submatrix starting at (%d, %d): %d%n", r, c, sumMatrix);

                if (sumMatrix > maxSum) {
                    maxSum = sumMatrix;
                    maxMatrixRow = r;
                    maxMatrixCol = c;
                }
            }
        }

        System.out.printf("Sum=%d%n", maxSum);
        printMatrix(matrix, maxMatrixRow, maxMatrixCol);
    }

    private static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
