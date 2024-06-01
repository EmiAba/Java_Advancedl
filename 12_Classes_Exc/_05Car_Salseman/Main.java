package F12_Classes_Exc._05Car_Salseman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            Engine engine;
            if (engineData.length == 4) {
                engine = new Engine(model, power, engineData[2], engineData[3]);
            } else if (engineData.length == 3) {
                engine = new Engine(model, power, engineData[2]);
            } else {
                engine = new Engine(model, power);
            }

            engines.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            Engine engine = engines.get(carData[1]);

            Car car;
            if (carData.length == 4) {
                car = new Car(model, engine, carData[2], carData[3]);
            } else if (carData.length == 3) {
                if (isNumeric(carData[2])) {
                    car = new Car(model, engine, carData[2], null);
                } else {
                    car = new Car(model, engine, null, carData[2]);
                }
            } else {
                car = new Car(model, engine);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
