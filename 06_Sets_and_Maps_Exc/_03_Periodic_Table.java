package F6_Sets_and_Maps_Exc;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> table = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");
            for (String element : elements) {
                table.add(element);
            }
        }

        table.forEach(e -> System.out.print(e + " "));
    }
}
