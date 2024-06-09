import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Box<Integer> box = new Box<>();
        for (int row = 0; row < n; row++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        System.out.println(box);
    }
}
