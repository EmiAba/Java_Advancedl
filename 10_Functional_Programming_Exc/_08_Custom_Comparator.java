package F10_Functional_Programming_Exc;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08_Custom_Comparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//comparator: compares 2 numbers here and returns (-1, 0, 1)


        Comparator<Integer> comparator=(first, second)->{
            //if first is even , second -odd-> then 1 do not replace places
            if (first %2!=0 &second%2==0){
                return 1;
            }
            //if first is odd, second-even-> then 1-replace locations
            if (first %2==0 & second% 2!=0){
                return -1;
            }

            //first-even second -even

            //first odd second odd
            return first.compareTo(second);

        };

numbers.stream().sorted(comparator).forEach(num-> System.out.print(num+ " "));

    }
}
