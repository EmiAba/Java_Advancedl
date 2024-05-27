package F4_Multidimensional_Arrays_Exc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix dimensions
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Initialize matrix
        List<List<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(value++);
            }
            matrix.add(row);
        }

        // Process destruction commands
        String line;
        while (!(line = scanner.nextLine()).equals("Nuke it from orbit")) {
            String[] parts = line.split(" ");
            int targetRow = Integer.parseInt(parts[0]);
            int targetCol = Integer.parseInt(parts[1]);
            int radius = Integer.parseInt(parts[2]);

            // Destroy cells in a cross-like pattern
            destroyCells(matrix, targetRow, targetCol, radius);
        }

        // Print the final state of the matrix
        printMatrix(matrix);

        scanner.close();
    }

    private static void destroyCells(List<List<Integer>> matrix, int targetRow, int targetCol, int radius) {
        // Destroy vertical cells
        for (int r = Math.max(0, targetRow - radius); r <= Math.min(matrix.size() - 1, targetRow + radius); r++) {
            if (targetCol >= 0 && targetCol < matrix.get(r).size()) {
                matrix.get(r).set(targetCol, null);
            }
        }

        // Destroy horizontal cells
        if (targetRow >= 0 && targetRow < matrix.size()) {
            for (int c = Math.max(0, targetCol - radius); c <= Math.min(matrix.get(targetRow).size() - 1, targetCol + radius); c++) {
                matrix.get(targetRow).set(c, null);
            }
        }

        // Cleanup matrix: remove null values and empty rows
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).removeIf(cell -> cell == null);
            if (matrix.get(i).isEmpty()) {
                matrix.remove(i);
                i--; // Adjust index after removal
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int i = 0; i < row.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row.get(i));
            }
            System.out.println();
        }
    }
}
