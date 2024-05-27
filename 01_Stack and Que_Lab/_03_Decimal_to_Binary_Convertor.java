package F1_Stacks_and_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_Decimal_to_Binary_Convertor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(num == 0){
            System.out.println(0);
        } else {
            while (num > 0) {
                int r = num % 2;

                // pushing the remainder inside the stack
                stack.push(r);
                num /= 2;
            }
        }
        //  System.out.print("Binary equivalent: ");

        while (!(stack.isEmpty())) {
            // printing the resultant binary number stored in the
            // stack in LIFO manner
            System.out.print(stack.pop());
        }
    }
}
