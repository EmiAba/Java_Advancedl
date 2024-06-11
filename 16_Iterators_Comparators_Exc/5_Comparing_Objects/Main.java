import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, town, age);
            people.add(person);
            line = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= people.size()) {
            System.out.println("Invalid index");
            return;
        }

        Person myPerson = people.get(index);
        int equalCount = 0;
        int notEqualCount = 0;

        for (Person person : people) {
            if (person.compareTo(myPerson) == 0) {
                equalCount++;
            } else {
                notEqualCount++;
            }
        }

        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", equalCount, notEqualCount, people.size());
        }
    }
}
