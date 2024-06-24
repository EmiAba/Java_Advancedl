import java.util.Scanner;

public class Beesy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        char[][] field = new char[n][n];
        int beeRow = -1, beeCol = -1;


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            if (line.contains("B")) {
                beeRow = i;
                beeCol = line.indexOf('B');
            }
        }

        // Initialize bee's properties
        int energy = 15;
        int nectarCollected = 0;
        boolean energyRestored = false;
        boolean hiveReached = false;


        while (scanner.hasNextLine() && energy > 0 && !hiveReached) {
            String command = scanner.nextLine();
            int[] newPositions = getNewPosition(beeRow, beeCol, command, n);
            int newBeeRow = newPositions[0];
            int newBeeCol = newPositions[1];


            energy--;


            char cell = field[newBeeRow][newBeeCol];

            if (cell == 'H') {

                hiveReached = true;
                updateField(field, beeRow, beeCol, newBeeRow, newBeeCol);
                break;
            } else if (Character.isDigit(cell)) {

                nectarCollected += Character.getNumericValue(cell);
                field[newBeeRow][newBeeCol] = '-';
            }


            updateField(field, beeRow, beeCol, newBeeRow, newBeeCol);
            beeRow = newBeeRow;
            beeCol = newBeeCol;


            if (energy == 0 && nectarCollected >= 30 && !energyRestored) {
                int extraEnergy = nectarCollected - 30;
                energy = extraEnergy;
                nectarCollected = 30;
                energyRestored = true;
            }
        }


        printResults(hiveReached, nectarCollected, energy);


        printField(field);
    }

    private static int[] getNewPosition(int beeRow, int beeCol, String command, int n) {
        switch (command) {
            case "up": beeRow--; break;
            case "down": beeRow++; break;
            case "left": beeCol--; break;
            case "right": beeCol++; break;
        }

        // Wrap around if the bee goes out of the field boundaries
        if (beeRow < 0) beeRow = n - 1;
        if (beeRow >= n) beeRow = 0;
        if (beeCol < 0) beeCol = n - 1;
        if (beeCol >= n) beeCol = 0;

        return new int[]{beeRow, beeCol};
    }

    private static void updateField(char[][] field, int oldRow, int oldCol, int newRow, int newCol) {
        field[oldRow][oldCol] = '-';
        field[newRow][newCol] = 'B';
    }

    private static void printResults(boolean hiveReached, int nectarCollected, int energy) {
        if (hiveReached) {
            if (nectarCollected >= 30) {
                System.out.println("Great job, Beesy! The hive is full. Energy left: " + energy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        } else {
            if (energy == 0) {
                System.out.println("This is the end! Beesy ran out of energy.");
            }
        }
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            System.out.println(new String(row));
        }
    }
}
