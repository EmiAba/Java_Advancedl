package F19_Exam_Preparation1;

import java.util.Scanner;

public class _02_The_Gambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the board
        int n = Integer.parseInt(scanner.nextLine());

        // Initialize the game board and gambler's position
        char[][] board = new char[n][n];
        int gamblerRow = -1;
        int gamblerCol = -1;

        // Read the board rows
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'G') {
                    gamblerRow = i;
                    gamblerCol = j;
                }
            }
        }

        // Initial amount
        int amount = 100;

        // Process commands
        String command;
        boolean gameEnd = false;
        while (!(command = scanner.nextLine()).equals("end")) {
            board[gamblerRow][gamblerCol] = '-'; // Mark previous position as empty

            switch (command) {
                case "up":
                    gamblerRow--;
                    break;
                case "down":
                    gamblerRow++;
                    break;
                case "left":
                    gamblerCol--;
                    break;
                case "right":
                    gamblerCol++;
                    break;
            }

            // Check boundaries
            if (gamblerRow < 0 || gamblerRow >= n || gamblerCol < 0 || gamblerCol >= n) {
                System.out.println("Game over! You lost everything!");
                gameEnd = true;
                break;
            }

            // Check new position
            char position = board[gamblerRow][gamblerCol];
            if (position == 'W') {
                amount += 100;
            } else if (position == 'P') {
                amount -= 200;
            } else if (position == 'J') {
                amount += 100000;
                board[gamblerRow][gamblerCol] = 'G'; // Update the final position
                System.out.println("You win the Jackpot!");
                System.out.println("End of the game. Total amount: " + amount + "$");
                gameEnd = true;
                break;
            }

            // Check amount
            if (amount <= 0) {
                System.out.println("Game over! You lost everything!");
                gameEnd = true;
                break;
            }

            board[gamblerRow][gamblerCol] = 'G'; // Mark new position
        }

        if (!gameEnd && amount > 0) {
            System.out.println("End of the game. Total amount: " + amount + "$");
        }

        if (!gameEnd) {
            // Print the final board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
    }
