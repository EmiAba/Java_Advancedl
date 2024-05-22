package F6_Sets_and_Maps_Exc;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the sizes of the two sets
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Using LinkedHashSet to maintain the insertion order
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        // Read elements for the first set
        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextInt());
        }

        // Read elements for the second set
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextInt());
        }

        // Find intersection
        firstSet.retainAll(secondSet);

        // Print intersection
        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }
    }
}
