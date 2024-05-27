package F5_Sets_and_Maps_Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_Academy_Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            String[] scoresStrings = scanner.nextLine().split("\\s+");
            Double[] scores = new Double[scoresStrings.length];

            for (int j = 0; j < scoresStrings.length; j++) {
                scores[j] = Double.parseDouble(scoresStrings[j]);
            }
            graduationList.put(name, scores);
        }

        // TODO print results
        for (Map.Entry<String, Double[]> entry : graduationList.entrySet()) {
            String name = entry.getKey();
            Double[] scores = entry.getValue();
            double averageScore = calculateAverage(scores);
            System.out.printf("%s is graduated with %.3f%n", name, averageScore);
        }
    }

    private static double calculateAverage(Double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}
