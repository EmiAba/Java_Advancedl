package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char parenthesis : expression.toCharArray()) {
            if (parenthesis == '{' || parenthesis == '[' || parenthesis == '(') {
                stack.push(parenthesis);
            } else {
                // Check if the stack is empty before popping
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                boolean isValidMatching = areMatchingBrackets(stack.pop(), parenthesis);
                if (!isValidMatching) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        // Check if the stack is empty at the end
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean areMatchingBrackets(char openParenthesis, char closedParenthesis) {
        if (openParenthesis == '{') {
            return closedParenthesis == '}';
        } else if (openParenthesis == '[') {
            return closedParenthesis == ']';
        } else {
            return closedParenthesis == ')';
        }
    }
}
