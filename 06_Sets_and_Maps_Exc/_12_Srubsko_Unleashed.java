package F6_Sets_and_Maps_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _12_Srubsko_Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> venueData = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            // Validate and parse input
            String[] tokens = input.split(" @");
            if (tokens.length != 2) {
                continue;
            }

            String singer = tokens[0].trim();
            String[] venueDataTokens = tokens[1].split(" ");
            if (venueDataTokens.length < 3) {
                continue;
            }

            // Extract venue and ticket info
            StringBuilder venueBuilder = new StringBuilder();
            int ticketPrice = -1;
            int ticketCount = -1;
            try {
                for (int i = 0; i < venueDataTokens.length - 2; i++) {
                    venueBuilder.append(venueDataTokens[i]).append(" ");
                }
                ticketPrice = Integer.parseInt(venueDataTokens[venueDataTokens.length - 2]);
                ticketCount = Integer.parseInt(venueDataTokens[venueDataTokens.length - 1]);
            } catch (NumberFormatException e) {
                continue;
            }

            String venue = venueBuilder.toString().trim();
            int totalMoney = ticketPrice * ticketCount;

            venueData.putIfAbsent(venue, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> singers = venueData.get(venue);
            singers.put(singer, singers.getOrDefault(singer, 0) + totalMoney);
        }

        // Output results
        for (Map.Entry<String, LinkedHashMap<String, Integer>> venueEntry : venueData.entrySet()) {
            String venue = venueEntry.getKey();
            LinkedHashMap<String, Integer> singers = venueEntry.getValue();

            System.out.println(venue);
            singers.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int result = e2.getValue().compareTo(e1.getValue());
                        if (result == 0) {
                            return 0; // preserve insertion order if values are the same
                        }
                        return result;
                    })
                    .forEach(singerEntry -> {
                        System.out.println("#  " + singerEntry.getKey() + " -> " + singerEntry.getValue());
                    });
        }
    }
}
