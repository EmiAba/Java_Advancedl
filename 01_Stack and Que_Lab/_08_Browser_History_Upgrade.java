package F1_Stacks_and_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        String currentUrl = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backStack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    forwardStack.push(currentUrl);
                    currentUrl = backStack.pop();
                    System.out.println(currentUrl);
                }
            } else if (input.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    backStack.push(currentUrl);
                    currentUrl = forwardStack.pop();
                    System.out.println(currentUrl);
                }
            } else {
                if (currentUrl != null) {
                    backStack.push(currentUrl);
                }
                currentUrl = input;
                forwardStack.clear(); // Clear forward history on a new visit
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }

        scanner.close();
    }
    }

