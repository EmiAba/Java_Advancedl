package F5_Sets_and_Maps_Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Count_Real_Numbers {
    public static void main(String[] args) {

           Scanner scanner = new Scanner(System.in);

        double[] numbs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurences = new LinkedHashMap<>();

        for (int i = 0; i < numbs.length; i++) {

            if (occurences.containsKey(numbs[i])) {
                // incrementirame
                int currentocurrences = occurences.get(numbs[i]);
                occurences.put(numbs[i], 1 + currentocurrences);

            } else {
                occurences.put(numbs[i], 1);
            }


        }
//printirane
        for (Double num : occurences.keySet()) {
            System.out.printf("%.1f -> %d%n", num, occurences.get(num));

        }

    }
    }
