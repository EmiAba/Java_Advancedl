package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _12_The_Matrix {
    private static char[][] matrix;
    private static int rows;
    private static int cols;
    private static char fillChar;
    private static char startChar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().replace(" ", "");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        fillChar = scanner.next().charAt(0);
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        startChar = matrix[startRow][startCol];

        if (startChar != fillChar) {
            floodFill(startRow, startCol);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void floodFill(int row, int col) {
        // Check boundaries and if the current cell is not the startChar
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != startChar) {
            return;
        }

        // Change the character at the current cell
        matrix[row][col] = fillChar;

        // Recursively apply the same algorithm to neighboring cells
        floodFill(row - 1, col); // Up
        floodFill(row + 1, col); // Down
        floodFill(row, col - 1); // Left
        floodFill(row, col + 1); // Right
    }
}

