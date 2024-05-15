package F2_Stack_Que_Exc;

import java.util.Scanner;
import java.util.Stack;

public class _08_InfixTOPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(convertToPostfix(expression));
    }

    public static String convertToPostfix(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token) || isVariable(token)) {
                output.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove the "(" from the stack
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private static boolean isNumeric(String token) {
        return token.matches("\\d+");
    }

    private static boolean isVariable(String token) {
        return token.matches("[a-z]");
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }
}
