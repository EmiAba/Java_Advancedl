import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();

        // Ensure the indexes are valid before performing the swap
        if (index1 >= 0 && index1 < n && index2 >= 0 && index2 < n) {
            box.swap(index1, index2);
        } else {
            System.out.println("Invalid indexes for swapping.");
        }

        System.out.println(box);
    }
}
