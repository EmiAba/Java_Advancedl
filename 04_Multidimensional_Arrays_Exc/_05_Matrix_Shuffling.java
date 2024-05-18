package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _05_Matrix_Shuffling {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix dimensions
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Initialize and read matrix
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        // Process commands
        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            String[] parts = command.split(" ");
            if (parts.length == 5 && parts[0].equals("swap")) {
                try {
                    int row1 = Integer.parseInt(parts[1]);
                    int col1 = Integer.parseInt(parts[2]);
                    int row2 = Integer.parseInt(parts[3]);
                    int col2 = Integer.parseInt(parts[4]);

                    if (isValidCoordinate(row1, col1, rows, cols) && isValidCoordinate(row2, col2, rows, cols)) {
                        // Perform the swap
                        String temp = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = temp;

                        // Print the matrix after swap
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }

        scanner.close();
    }

    private static boolean isValidCoordinate(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}
