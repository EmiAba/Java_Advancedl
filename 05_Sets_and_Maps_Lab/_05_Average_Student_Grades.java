package F5_Sets_and_Maps_Lab;

import java.util.*;

public class _05_Average_Student_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentRecords = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            studentRecords.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentRecords.entrySet()) {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.print(name + " -> ");
            for (Double grade : grades) {
                System.out.print(String.format("%.2f ", grade));
            }
            System.out.println(String.format("(avg: %.2f)", average));
        }

        scanner.close();
    }
}