import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ListyIterator listyIterator = null;

        if (command.startsWith("Create")) {
            String[] elements = command.split("\\s+");
            List<String> list = new ArrayList<>();
            if (elements.length > 1) {
                list = Arrays.asList(elements).subList(1, elements.length);
            }
            listyIterator = new ListyIterator(list);
        }

        command = scanner.nextLine();
        while (!command.equals("END")) {
            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            command = scanner.nextLine();
        }
        scanner.close();
    }
    }




