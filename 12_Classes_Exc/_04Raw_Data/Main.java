package F12_Classes_Exc._04Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> carList = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, cargoType);
            ArrayList<Tire> tires = new ArrayList<>();
            tires.add(new Tire(tire1Pressure, tire1Age));
            tires.add(new Tire(tire2Pressure, tire2Age));
            tires.add(new Tire(tire3Pressure, tire3Age));
            tires.add(new Tire(tire4Pressure, tire4Age));

            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            List<String> model = new ArrayList<>();
            for (Car car : carList) {
                for (Tire tire : car.getTires()) {
                    if (tire.getTirePressure() < 1) {
                        model.add(car.getModel());
                        break;
                    }
                }
            }
            model.forEach(System.out::println);
        } else {
            carList.forEach(car -> {
                if (car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250) {
                    System.out.printf("%s%n", car.getModel());
                }
            });
        }
    }
}
