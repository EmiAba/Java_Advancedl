package F11_Classes_Lab.Car2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] carData = scanner.nextLine().split(" ");
            Car car;

            if(carData.length==1) {
                car = new Car(carData[0]);
            }else{
                car=new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            }
            carsList.add(car);
        }

        carsList.forEach(car-> System.out.println(car.carInfo()));
        // System.out.println(String.format("The car is: %s %s - %d HP.", car.getBrand(), car.getModel(), car.getHorsePower()));

    }
}