package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _10_Predicate_Party {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the initial list of guests
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        // Process commands until "Party!" is received
        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] commandParts = command.split("\\s+");
            String action = commandParts[0];
            String criteria = commandParts[1];
            String parameter = commandParts[2];

            Predicate<String> predicate;
            switch (criteria) {
                case "StartsWith":
                    predicate = name -> name.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = name -> name.endsWith(parameter);
                    break;
                case "Length":
                    int length = Integer.parseInt(parameter);
                    predicate = name -> name.length() == length;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown criteria: " + criteria);
            }

            switch (action) {
                case "Remove":
                    guests.removeIf(predicate);
                    break;
                case "Double":
                    List<String> toAdd = guests.stream().filter(predicate).collect(Collectors.toList());
                    guests.addAll(toAdd);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown action: " + action);
            }

            command = scanner.nextLine();
        }

        // Print the result
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests.sort(String::compareTo);
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }
}
