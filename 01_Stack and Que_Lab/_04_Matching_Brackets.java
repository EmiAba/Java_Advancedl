package F1_Stacks_and_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <expression.length() ; i++) {
            char currentSymbol=expression.charAt(i);

            if(currentSymbol=='('){
                stack.push(i);
            }else if(currentSymbol==')'){
                int startIndex=stack.pop();
                int endIndex=i;
                String subexpression=  expression.substring(startIndex, endIndex+1);
                System.out.println(subexpression);
            }

        }

    }
}
