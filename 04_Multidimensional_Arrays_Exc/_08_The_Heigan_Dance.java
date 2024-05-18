package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _08_The_Heigan_Dance {
    private static final int GRID_SIZE = 15;
    private static final int PLAYER_START_ROW = 7;
    private static final int PLAYER_START_COL = 7;
    private static final int PLAYER_INITIAL_HEALTH = 18500;
    private static final double HEIGAN_INITIAL_HEALTH = 3000000.0;
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        int playerRow = PLAYER_START_ROW;
        int playerCol = PLAYER_START_COL;
        int playerHealth = PLAYER_INITIAL_HEALTH;
        double heiganHealth = HEIGAN_INITIAL_HEALTH;

        boolean hasActiveCloud = false;
        String lastSpell = "";

        while (true) {
            heiganHealth -= damageToHeigan;
            if (hasActiveCloud) {
                playerHealth -= CLOUD_DAMAGE;
                hasActiveCloud = false;
                if (playerHealth <= 0) {
                    lastSpell = "Plague Cloud";
                    break;
                }
            }

            if (heiganHealth <= 0) {
                break;
            }

            String[] spellData = scanner.nextLine().split(" ");
            String spell = spellData[0];
            int spellRow = Integer.parseInt(spellData[1]);
            int spellCol = Integer.parseInt(spellData[2]);

            if (isPlayerInDamageZone(playerRow, playerCol, spellRow, spellCol)) {
                if (!isPlayerInDamageZone(playerRow - 1, playerCol, spellRow, spellCol) && isWithinBounds(playerRow - 1)) {
                    playerRow--;
                } else if (!isPlayerInDamageZone(playerRow, playerCol + 1, spellRow, spellCol) && isWithinBounds(playerCol + 1)) {
                    playerCol++;
                } else if (!isPlayerInDamageZone(playerRow + 1, playerCol, spellRow, spellCol) && isWithinBounds(playerRow + 1)) {
                    playerRow++;
                } else if (!isPlayerInDamageZone(playerRow, playerCol - 1, spellRow, spellCol) && isWithinBounds(playerCol - 1)) {
                    playerCol--;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHealth -= CLOUD_DAMAGE;
                        hasActiveCloud = true;
                        lastSpell = "Plague Cloud";
                    } else if (spell.equals("Eruption")) {
                        playerHealth -= ERUPTION_DAMAGE;
                        lastSpell = "Eruption";
                    }

                    if (playerHealth <= 0) {
                        break;
                    }
                }
            }
        }

        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);

        scanner.close();
    }

    private static boolean isPlayerInDamageZone(int playerRow, int playerCol, int spellRow, int spellCol) {
        return playerRow >= spellRow - 1 && playerRow <= spellRow + 1 &&
                playerCol >= spellCol - 1 && playerCol <= spellCol + 1;
    }

    private static boolean isWithinBounds(int coordinate) {
        return coordinate >= 0 && coordinate < GRID_SIZE;
    }
}