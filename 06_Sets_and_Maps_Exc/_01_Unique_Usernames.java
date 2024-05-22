package F6_Sets_and_Maps_Exc;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        Set<String> names=new LinkedHashSet<>();


        for (int i = 1; i <=n ; i++) {
            names.add(scanner.nextLine());

        }

        for (String name : names) {
            System.out.println( name);

        }

    }
}
