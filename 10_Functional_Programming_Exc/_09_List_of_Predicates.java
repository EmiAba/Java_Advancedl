package F10_Functional_Programming_Exc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09_List_of_Predicates {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // Read N
        int n = Integer.parseInt(scanner.nextLine());

        // Read the sequence of numbers
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

       List<Predicate<Integer>>predicates=new ArrayList<>();

        for (Integer divisor : divisors) {
            Predicate<Integer> predicate=num->num%divisor==0;
            predicates.add(predicate);

        }

        for (int number = 1; number <=n ; number++) {
            boolean isDivisible=true;
            for(Predicate<Integer> predicate: predicates){
                if(!predicate.test(number)){
                    isDivisible=false;

                }
            }
            if(isDivisible){
                System.out.print(number+ " ");
            }
        }


    }
}
