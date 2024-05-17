package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _02_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        String[][] matrix = new String[row][col];

        //method which fills the  matrix with palindromes
        fillMatrix(matrix);

        //method printing matrix
        printMatrix(matrix);


    }

    private static void fillMatrix(String[][] matrix) {

        int asciiValueA = 97;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char firstLetter = (char) (asciiValueA + row);
                char middleLetter =(char) (asciiValueA +row+ col) ;
                char lastLetter = (char) (asciiValueA + row);


                String palindrome = String.format("%c%c%c", firstLetter, middleLetter, lastLetter);
matrix[row][col]=palindrome;
            }

        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }
    }
}


//second option
//public class_02_Matrix_of_Palindromes {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Read input for rows (r) and columns (c)
//        int r = scanner.nextInt();
//        int c = scanner.nextInt();
//
//        // Generate the palindrome matrix
//        generatePalindromeMatrix(r, c);
//    }
//
//    private static void generatePalindromeMatrix(int rows, int cols) {
//        for (int i = 0; i < rows; i++) {
//            StringBuilder row = new StringBuilder();
//            for (int j = 0; j < cols; j++) {
//                // First and last letter are determined by the row
//                char firstLastLetter = (char) ('a' + i);
//                // Middle letter is determined by the row and the column
//                char middleLetter = (char) ('a' + i + j);
//
//                // Form the palindrome string
//                String palindrome = "" + firstLastLetter + middleLetter + firstLastLetter;
//
//                // Append to the row string
//                row.append(palindrome);
//
//                if (j < cols - 1) {
//                    row.append(" ");
//                }
//            }
//            // Print the row
//            System.out.println(row.toString());
//        }
//    }
//}
