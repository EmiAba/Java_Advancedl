package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputLine = scanner.nextLine();


        StringTokenizer tokenizer = new StringTokenizer(inputLine);


        ArrayDeque<Integer> stack = new ArrayDeque<>();


        while (tokenizer.hasMoreTokens()) {
            int number = Integer.parseInt(tokenizer.nextToken());
            stack.push(number);
        }


        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // Close the scanner
        scanner.close();
    }
}

