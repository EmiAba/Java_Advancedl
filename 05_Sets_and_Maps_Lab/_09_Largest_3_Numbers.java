package F5_Sets_and_Maps_Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the list of integers
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Sort the list in descending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Determine the number of elements to print (3 or less)
        int elementsToPrint = Math.min(3, sortedNumbers.size());

        // Print the largest elements
        for (int i = 0; i < elementsToPrint; i++) {
            System.out.print(sortedNumbers.get(i) + " ");
        }
    }
    }

