package F4_Multidimensional_Arrays_Exc;
import java.util.*;

public class _06_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the rotation angle
        String rotationInput = scanner.nextLine().replace("Rotate(", "").replace(")", "");
        int rotationAngle = Integer.parseInt(rotationInput) % 360;

        // Read the lines of the matrix
        List<String> lines = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            lines.add(line);
            line = scanner.nextLine();
        }

        // Determine the dimensions of the matrix
        int rows = lines.size();
        int cols = lines.stream().mapToInt(String::length).max().orElse(0);

        // Initialize the matrix with spaces
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], ' ');
            String currentLine = lines.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                matrix[i][j] = currentLine.charAt(j);
            }
        }

        // Rotate the matrix according to the angle
        char[][] rotatedMatrix = rotateMatrix(matrix, rotationAngle);

        // Print the rotated matrix
        printMatrix(rotatedMatrix);
    }

    private static char[][] rotateMatrix(char[][] matrix, int angle) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] rotatedMatrix;
        switch (angle) {
            case 90:
                rotatedMatrix = new char[cols][rows];
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        rotatedMatrix[i][j] = matrix[rows - 1 - j][i];
                    }
                }
                break;
            case 180:
                rotatedMatrix = new char[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        rotatedMatrix[i][j] = matrix[rows - 1 - i][cols - 1 - j];
                    }
                }
                break;
            case 270:
                rotatedMatrix = new char[cols][rows];
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        rotatedMatrix[i][j] = matrix[j][cols - 1 - i];
                    }
                }
                break;
            case 0:
            default:
                rotatedMatrix = matrix;
                break;
        }

        return rotatedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
