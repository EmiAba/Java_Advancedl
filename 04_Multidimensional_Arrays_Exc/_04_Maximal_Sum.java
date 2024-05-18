package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _04_Maximal_Sum {
    public static void main(String[] args) {
Scanner scanner  =new Scanner(System.in);


    int row= scanner.nextInt();
    int col= scanner.nextInt();

    int[][] matrix=new int[row][col];

        fillMatrix(scanner,  matrix);




    }
    private static void fillMatrix(Scanner scanner,  int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }

        }
    }
}
