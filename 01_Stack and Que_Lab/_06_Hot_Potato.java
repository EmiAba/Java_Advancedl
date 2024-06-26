package F1_Stacks_and_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] nameChildren=scanner.nextLine().split("\\s+");
        int n=Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : nameChildren) {
            queue.offer(name);


        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
