package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_2V_01 {
    public static void main(String[] args) {
        // Create a scanner to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayDeque (stack) to store integers
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Read the entire line of input and split by spaces
        String[] inputNumbers = scanner.nextLine().split(" ");

        // Push each integer from the input into the stack
        for (String num : inputNumbers) {
            stack.push(Integer.parseInt(num));
        }

        // Pop and print each integer from the stack (this will print them in reverse order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // Close the scanner
        scanner.close();
    }
}