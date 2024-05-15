package F2_Stack_Que_Exc;

import java.util.*;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //for the n, s,x input data
        int[] input = Arrays.stream((scanner.nextLine())
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int number = scanner.nextInt();

            stack.push(number);

        }
        for (int i = 0; i <s && !stack.isEmpty(); i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }


    }
}
