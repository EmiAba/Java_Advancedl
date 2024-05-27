package F9_Functional_Programming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _02_Sum_Numbers_V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .toList();


        System.out.println("Count = "+list.size());


        System.out.println("Sum = "+ list.stream().mapToInt(e->e).sum());
    }
}
