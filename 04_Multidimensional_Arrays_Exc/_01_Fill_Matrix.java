package F4_Multidimensional_Arrays_Exc;

import java.util.Scanner;

public class _01_Fill_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix=new int[n][n];

        //check the pattern
        //call the right method

        switch(pattern){
            case  "A"->fillMatrixPatternA(matrix);
            case  "B"->fillMatrixPatternB(matrix);

        }


        //print the matrix
        printMatrix(matrix);
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int counter=1;
        for (int col = 0; col <matrix.length ; col++) {
            //col is even the row starts form 0 till the end
            if(col%2==0){
                for (int row = 0; row < matrix.length ; row++) {
                    matrix[row][col]=counter++;

                }

           //from last till 0 row
            }else{
                for (int row = matrix.length-1; row >=0 ; row--) {
                    matrix[row][col]=counter++;

                }

            }

        }

    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int counter=1;
        for (int col = 0; col < matrix.length ; col++) {
            for (int row = 0; row <matrix.length ; row++) {
                matrix[row][col]=counter++;

            }

        }



    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+ " ");

            }
            System.out.println();

        }
    }
}
