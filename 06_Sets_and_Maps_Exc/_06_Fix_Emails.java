package F6_Sets_and_Maps_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_Fix_Emails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> validEmails = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("stop")) {
                break;
            }
            String email = scanner.nextLine();
            if (email.equalsIgnoreCase("stop")) {
                break;
            }

            if (isValidEmail(email)) {
                validEmails.put(name, email);
            }
        }

        validEmails.forEach((name, email) ->
                System.out.println(name + " -> " + email)
        );
    }

    private static boolean isValidEmail(String email) {
        String lowerCaseEmail = email.toLowerCase();
        return !(lowerCaseEmail.endsWith(".us") || lowerCaseEmail.endsWith(".uk") || lowerCaseEmail.endsWith(".com"));
    }
}