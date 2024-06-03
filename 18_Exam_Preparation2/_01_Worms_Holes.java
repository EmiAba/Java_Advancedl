package F18_Exam_Preparation2;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Worms_Holes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the worms sequence
        String[] wormsInput = scanner.nextLine().split(" ");
        Deque<Integer> worms = new ArrayDeque<>();
        for (String worm : wormsInput) {
            worms.push(Integer.parseInt(worm));
        }

        // Read the holes sequence
        String[] holesInput = scanner.nextLine().split(" ");
        Queue<Integer> holes = new ArrayDeque<>();
        for (String hole : holesInput) {
            holes.offer(Integer.parseInt(hole));
        }

        int matchesCount = 0;

        while (!worms.isEmpty() && !holes.isEmpty()) {
            int currentWorm = worms.pop();
            int currentHole = holes.poll();

            if (currentWorm == currentHole) {
                matchesCount++;
            } else {
                currentWorm -= 3;
                if (currentWorm > 0) {
                    worms.push(currentWorm);
                }
            }
        }

        // Printing the results
        if (matchesCount > 0) {
            System.out.println("Matches: " + matchesCount);
        } else {
            System.out.println("There are no matches.");
        }

        if (worms.isEmpty()) {
            if (matchesCount == wormsInput.length) {
                System.out.println("Every worm found a suitable hole!");
            } else {
                System.out.println("Worms left: none");
            }
        } else {
            System.out.print("Worms left: ");
            List<Integer> wormsList = new ArrayList<>(worms);
            Collections.reverse(wormsList); // To maintain the original order of input
            System.out.println(wormsList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.print("Holes left: ");
            System.out.println(holes.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
