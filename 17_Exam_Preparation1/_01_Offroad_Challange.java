package F19_Exam_Preparation1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _01_Offroad_Challange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial fuel quantities
        String[] fuelInput = scanner.nextLine().split(" ");
        Stack<Integer> initialFuel = new Stack<>();
        for (String fuel : fuelInput) {
            initialFuel.push(Integer.parseInt(fuel));
        }

        // Read the additional consumption indexes
        String[] consumptionInput = scanner.nextLine().split("\\s+");
        Stack<Integer> consumptionIndexes = new Stack<>();
        for (int i = consumptionInput.length - 1; i >= 0; i--) {
            consumptionIndexes.push(Integer.parseInt(consumptionInput[i]));
        }

        // Read the necessary amount of fuel to reach each altitude
        String[] neededFuelInput = scanner.nextLine().split(" ");
        Stack<Integer> neededFuel = new Stack<>();
        for (int i = neededFuelInput.length - 1; i >= 0; i--) {
            neededFuel.push(Integer.parseInt(neededFuelInput[i]));
        }

        // Processing the challenge
        int altitudeCounter = 1;
        boolean reachedAnyAltitude = false;
        boolean reachedAllAltitudes = true;

        while (!initialFuel.isEmpty() && !consumptionIndexes.isEmpty() && !neededFuel.isEmpty()) {
            int currentFuel = initialFuel.pop();
            int currentConsumption = consumptionIndexes.pop();
            int requiredFuel = neededFuel.pop();

            int result = currentFuel - currentConsumption;

            if (result >= requiredFuel) {
                System.out.println("John has reached: Altitude " + altitudeCounter);
                altitudeCounter++;
                reachedAnyAltitude = true;
            } else {
                System.out.println("John did not reach: Altitude " + altitudeCounter);
                reachedAllAltitudes = false;
                break;
            }
        }

        if (!neededFuel.isEmpty() && !reachedAllAltitudes) {
            if (reachedAnyAltitude) {
                System.out.print("John failed to reach the top.\nReached altitudes: ");
                for (int i = 1; i < altitudeCounter; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    System.out.print("Altitude " + i);
                }
                System.out.println();
            } else {
                System.out.println("John failed to reach the top.\nJohn didn't reach any altitude.");
            }
        } else if (reachedAllAltitudes) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
    }

