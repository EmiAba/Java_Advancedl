import java.util.*;
import java.util.stream.Collectors;

public class DeliverySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> packages = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> couriers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int totalWeight = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()) {
            int packageWeight = packages.pollLast();
            int courierCapacity = couriers.pollFirst();

            if (courierCapacity >= packageWeight) {
                // Courier can deliver the package
                totalWeight += packageWeight;

                int newCapacity = courierCapacity - 2 * packageWeight;
                if (newCapacity > 0) {
                    couriers.offerLast(newCapacity);
                }

            } else {

                totalWeight += courierCapacity;
                packageWeight -= courierCapacity;
                packages.offerLast(packageWeight); // Update package weight
            }
        }

        // Output results
        System.out.println("Total weight: " + totalWeight + " kg");

        if (packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Unfortunately, there are no more available couriers to deliver the following packages: " +
                    packages.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else if (packages.isEmpty()) {
            System.out.println("Couriers are still on duty: " +
                    couriers.stream().map(String::valueOf).collect(Collectors.joining(", ")) +
                    " but there are no more packages to deliver.");
        }
    }
}
