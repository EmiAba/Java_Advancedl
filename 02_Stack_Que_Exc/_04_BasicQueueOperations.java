package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //for the n, s,x input data
        int[] input = Arrays.stream((scanner.nextLine())
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int number = scanner.nextInt();

            queue.offer(number);

        }
        for (int i = 0; i <s && !queue.isEmpty(); i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }




    }
}
