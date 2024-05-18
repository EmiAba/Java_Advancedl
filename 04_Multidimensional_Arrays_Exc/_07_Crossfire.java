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
        int[][] matrix = new int[rows][cols];
        boolean[][] destroyed = new boolean[rows][cols];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
                destroyed[i][j] = false;
            }
        }

        // Process destruction commands
        String line;
        while (!(line = scanner.nextLine()).equals("Nuke it from orbit")) {
            String[] parts = line.split(" ");
            int targetRow = Integer.parseInt(parts[0]);
            int targetCol = Integer.parseInt(parts[1]);
            int radius = Integer.parseInt(parts[2]);

            // Destroy cells in a cross-like pattern
            for (int r = targetRow - radius; r <= targetRow + radius; r++) {
                if (r >= 0 && r < rows && targetCol >= 0 && targetCol < cols) {
                    destroyed[r][targetCol] = true;
                }
            }
            for (int c = targetCol - radius; c <= targetCol + radius; c++) {
                if (targetRow >= 0 && targetRow < rows && c >= 0 && c < cols) {
                    destroyed[targetRow][c] = true;
                }
            }
        }

        // Print the final state of the matrix
        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                if (!destroyed[i][j]) {
                    currentRow.add(matrix[i][j]);
                }
            }
            if (!currentRow.isEmpty()) {
                for (int k = 0; k < currentRow.size(); k++) {
                    if (k > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(currentRow.get(k));
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}