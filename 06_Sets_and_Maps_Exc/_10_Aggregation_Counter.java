package F6_Sets_and_Maps_Exc;

import java.util.*;

public class _10_Aggregation_Counter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> userDurations = new TreeMap<>();
        Map<String, Set<String>> userIPs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String ip = parts[0];
            String user = parts[1];
            int duration = Integer.parseInt(parts[2]);

            userDurations.put(user, userDurations.getOrDefault(user, 0) + duration);
            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);
        }

        for (String user : userDurations.keySet()) {
            int totalDuration = userDurations.get(user);
            Set<String> ips = userIPs.get(user);
            System.out.println(user + ": " + totalDuration + " " + ips);
        }


    }
}
