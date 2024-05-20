package F5_Sets_and_Maps_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Numbered_Game_Voina {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        LinkedHashSet<Integer>  firstDeck= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer>  secondDeck= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds=50;
        while(rounds-->0){
            //vadene na karti na ograchi

            int firstCard=firstDeck.iterator().next();
            firstDeck.remove(firstCard);

            int secondCard=secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if(firstCard<secondCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }



            if(firstDeck.isEmpty()|| secondDeck.isEmpty()){
                break;
            }


        }

        if(firstDeck.size()>secondDeck.size()){
            System.out.println("First player win!");
        }else if(firstDeck.size()<secondDeck.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }

    }
}

    }
}
