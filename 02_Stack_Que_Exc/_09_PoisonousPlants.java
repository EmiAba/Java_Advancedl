package F2_Stack_Que_Exc;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _09_PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] pesticides = new int[N];
        for (int i = 0; i < N; i++) {
            pesticides[i] = scanner.nextInt();
        }

        System.out.println(daysUntilNoPlantDies(pesticides));
    }

    public static int daysUntilNoPlantDies(int[] pesticides) {
        int n = pesticides.length;
        int[] days = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            int maxDaysToDie = 0;

            while (!stack.isEmpty() && pesticides[stack.peek()] >= pesticides[i]) {
                maxDaysToDie = Math.max(maxDaysToDie, days[stack.pop()]);
            }

            if (!stack.isEmpty()) {
                days[i] = maxDaysToDie + 1;
                maxDays = Math.max(maxDays, days[i]);
            }

            stack.push(i);
        }

        return maxDays;
    }
}