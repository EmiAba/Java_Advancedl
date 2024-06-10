import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack customStack = new CustomStack();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (command.startsWith("Push")) {
                String[] parts = command.substring(5).split(", ");
                for (String part : parts) {
                    customStack.push(Integer.parseInt(part));
                }
            } else if (command.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }
            }
            command = scanner.nextLine();
        }

        printStack(customStack);
        printStack(customStack);

        scanner.close();
    }

    private static void printStack(CustomStack stack) {
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
