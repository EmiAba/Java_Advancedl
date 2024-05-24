package F6_Sets_and_Maps_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _09_Population_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> countryData = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("report")) {
                break;
            }

            String[] parts = input.split("\\|");
            String city = parts[0];
            String country = parts[1];
            long population = Long.parseLong(parts[2]);

            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryData.get(country).put(city, population);

            countryPopulation.put(country, countryPopulation.getOrDefault(country, 0L) + population);
        }

        countryPopulation.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .forEach(countryEntry -> {
                    String country = countryEntry.getKey();
                    long totalPopulation = countryEntry.getValue();
                    System.out.println(country + " (total population: " + totalPopulation + ")");

                    countryData.get(country).entrySet().stream()
                            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                            .forEach(cityEntry -> {
                                System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue());
                            });
                });
    }
}
