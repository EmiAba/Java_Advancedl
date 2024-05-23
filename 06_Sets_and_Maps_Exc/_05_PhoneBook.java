package F6_Sets_and_Maps_Exc;

import java.util.*;

public class _05_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("search")) {
                break;
            }

            String[] parts = input.split("-");
            String name = parts[0];
            String number = parts[1];

            phonebook.put(name, number);
        }

        while (true) {
            String searchName = scanner.nextLine();

            if (searchName.equals("stop")) {
                break;
            }

            if (phonebook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phonebook.get(searchName));
            } else {
                System.out.println("Contact " + searchName + " does not exist.");
            }
        }
    }
}
