package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _09_Parking_System {

        private static boolean[][] parkingLot;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Read dimensions
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Initialize parking lot (all spots are initially free)
            parkingLot = new boolean[rows][cols];

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("stop")) {
                    break;
                }

                String[] parts = line.split(" ");
                int entryRow = Integer.parseInt(parts[0]);
                int targetRow = Integer.parseInt(parts[1]);
                int targetCol = Integer.parseInt(parts[2]);

                int distance = parkCar(entryRow, targetRow, targetCol);
                if (distance == -1) {
                    System.out.println("Row " + targetRow + " full");
                } else {
                    System.out.println(distance);
                }
            }

            scanner.close();
        }

        private static int parkCar(int entryRow, int targetRow, int targetCol) {
            // Check if the desired spot is free
            if (!parkingLot[targetRow][targetCol]) {
                parkingLot[targetRow][targetCol] = true;
                return Math.abs(entryRow - targetRow) + targetCol + 1;
            }

            // Find the closest free spot on the same row
            int distance = Integer.MAX_VALUE;
            int bestCol = -1;

            for (int col = 1; col < parkingLot[targetRow].length; col++) {
                if (!parkingLot[targetRow][col]) {
                    int currentDistance = Math.abs(col - targetCol);
                    if (currentDistance < distance) {
                        distance = currentDistance;
                        bestCol = col;
                    } else if (currentDistance == distance && col < bestCol) {
                        bestCol = col;
                    }
                }
            }

            if (bestCol != -1) {
                parkingLot[targetRow][bestCol] = true;
                return Math.abs(entryRow - targetRow) + bestCol + 1;
            } else {
                return -1;
            }
        }
    }


