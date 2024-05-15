package F2_Stack_Que_Exc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class _10_RoboticsV2 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        // Read and parse robots data
        String[] robotsInput = scanner.nextLine().split(";");
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : robotsInput) {
            String[] robotData = robot.split("-");
            robots.put(robotData[0], Integer.parseInt(robotData[1]));
        }

        // Read and parse the start time
        String startTimeInput = scanner.nextLine();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date startTime = timeFormat.parse(startTimeInput);

        // Initialize structures to track robot availability
        Map<String, Integer> robotsProcessingTime = new LinkedHashMap<>();
        for (String robot : robots.keySet()) {
            robotsProcessingTime.put(robot, 0);
        }

        // Initialize the product deque
        ArrayDeque<String> products = new ArrayDeque<>();

        // Read products until the "End" command
        String product;
        while (!(product = scanner.nextLine()).equals("End")) {
            products.offer(product);
        }

        // Simulate the processing of products
        int currentTimeInSeconds = 0;
        while (!products.isEmpty()) {
            currentTimeInSeconds++;
            Date currentTime = new Date(startTime.getTime() + TimeUnit.SECONDS.toMillis(currentTimeInSeconds));

            boolean productProcessed = false;
            String currentProduct = products.poll();

            for (Map.Entry<String, Integer> entry : robotsProcessingTime.entrySet()) {
                String robotName = entry.getKey();
                int robotFreeIn = entry.getValue();

                if (robotFreeIn <= currentTimeInSeconds) {
                    robotsProcessingTime.put(robotName, currentTimeInSeconds + robots.get(robotName));
                    System.out.println(String.format("%s - %s [%s]", robotName, currentProduct, timeFormat.format(currentTime)));
                    productProcessed = true;
                    break;
                }
            }

            if (!productProcessed) {
                products.offer(currentProduct);
            }
        }

        scanner.close();
    }
}
