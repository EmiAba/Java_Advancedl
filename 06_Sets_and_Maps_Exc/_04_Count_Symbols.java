package F6_Sets_and_Maps_Exc;

import java.sql.SQLOutput;
import java.util.*;

public class _04_Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<Character, Integer> symbolCount = new TreeMap<>();

        String line = scanner.nextLine();

        for (char symbol : line.toCharArray()) {

            //1 imam li zapis koito pazi broikata poqvi za tazi bukva
            if (symbolCount.containsKey(symbol)) {
                //ako imam takyv zapis uvelichavam broq s edno
                int count = symbolCount.get(symbol) + 1;
                symbolCount.put(symbol, count);

            } else {
                //ako nqmam-pravq nov zapis s broi edno
                symbolCount.put(symbol, 1);
            }

        }
        symbolCount.entrySet().forEach(e-> System.out.println(e.getKey()+": " + e.getValue() +" time/s"));


    }

}