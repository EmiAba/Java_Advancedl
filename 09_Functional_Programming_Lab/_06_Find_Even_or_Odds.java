package F9_Functional_Programming_Lab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06_Find_Even_or_Odds {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);


        String [] data=scanner.nextLine().split(" ");

        int begin=Integer.parseInt(data[0]);
        int end=Integer.parseInt(data[1]);

        String filter= scanner.nextLine();

        //trqbvat nii vsichkite chisla v range inclusive
        IntPredicate predicate= n-> filter.equals("odd") == (n % 2 != 0);
        System.out.println(IntStream.rangeClosed(begin, end)
                .filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));




    }
}
