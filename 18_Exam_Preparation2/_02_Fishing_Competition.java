package F18_Exam_Preparation2;

import java.util.Scanner;

public class _02_Fishing_Competition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the size of the matrix
        int n = Integer.parseInt(scanner.nextLine());
        char[][] fishingArea = new char[n][n];

        int shipRow = -1, shipCol = -1;

        // Read the matrix and find the initial position of the ship
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                fishingArea[i][j] = line.charAt(j);
                if (fishingArea[i][j] == 'S') {
                    shipRow = i;
                    shipCol = j;
                }
            }
        }

        int fishCaught = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("collect the nets")) {
                break;
            }

            fishingArea[shipRow][shipCol] = '-'; // Mark previous position as empty

            // Update ship's position based on command
            switch (command) {
                case "up":
                    shipRow = (shipRow == 0) ? n - 1 : shipRow - 1;
                    break;
                case "down":
                    shipRow = (shipRow == n - 1) ? 0 : shipRow + 1;
                    break;
                case "left":
                    shipCol = (shipCol == 0) ? n - 1 : shipCol - 1;
                    break;
                case "right":
                    shipCol = (shipCol == n - 1) ? 0 : shipCol + 1;
                    break;
            }

            // Check new position
            char currentPosition = fishingArea[shipRow][shipCol];

            if (Character.isDigit(currentPosition)) {
                fishCaught += Character.getNumericValue(currentPosition);
                fishingArea[shipRow][shipCol] = '-'; // Replace fish passage with empty
            } else if (currentPosition == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", shipRow, shipCol);
                return;
            }

            fishingArea[shipRow][shipCol] = 'S'; // Update ship's position
        }

        if (fishCaught >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - fishCaught);
        }

        if (fishCaught > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", fishCaught);
        }

        // Print the final state of the fishing area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(fishingArea[i][j]);
            }
            System.out.println();
        }
    }
}