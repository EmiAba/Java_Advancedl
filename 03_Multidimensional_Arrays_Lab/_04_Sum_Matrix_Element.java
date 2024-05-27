package F3_Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Sum_Matrix_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int totalSum = 0;

        for (int row = 0; row < rows; row++) {
            totalSum += Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalSum);
    }
}
