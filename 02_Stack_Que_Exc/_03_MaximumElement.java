package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <commandsCount ; i++) {
            int [] input= Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();


            switch(input[0]){
                case 1->stack.push(input[1]);
                case 2->stack.pop();
                case 3-> System.out.println(Collections.max(stack));
            }


        }


    }
}
