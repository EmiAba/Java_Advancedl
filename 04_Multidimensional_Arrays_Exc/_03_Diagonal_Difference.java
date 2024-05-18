package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _03_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read matrix from console

        int n=scanner.nextInt();

        int [][] matrix= new int[n][n];
        //read matrix from console
        fillMatrix(scanner,  matrix);

        //sum of the diagonal
        int primaryDiagonalSum=getPrimaryDiagonalSum(matrix);

        //sum of the secondary diagonal
        int secondaryDiagonalSum=getSecondaryDiagonalSum(matrix);

        //absolute value of the difference of the sum's
        int absoluteValue=Math.abs(primaryDiagonalSum-secondaryDiagonalSum);
        System.out.println(absoluteValue);
        




        
    }

    private static void fillMatrix(Scanner scanner,  int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }

        }
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum=0;
        int counter=0;

        for (int index = matrix.length-1; index >=0; index--) {
            sum+=matrix[index][counter];
            counter++;

        }



        return sum;

    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {

        int sum=0;
        for (int index = 0; index < matrix.length ; index++) {
            sum+=matrix[index][index];

        }
         return sum;

    }
}
