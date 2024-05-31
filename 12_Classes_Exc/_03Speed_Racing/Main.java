package F12_Classes_Exc._03Speed_Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Car> cars=new ArrayList<>();

        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String[] data= scanner.nextLine().split("\\s+");
            String model=data[0];
           double fuel=Double.parseDouble(data[1]);
            double fuelCostPerKM=Double.parseDouble(data[2]);

            Car car=new Car(model, fuel, fuelCostPerKM);
            cars.add(car);

        }

        String input= scanner.nextLine();

        while(!input.equals("End")){
            String model=input.split("\\s+")[1];
                    int kmToDrive=Integer.parseInt(input.split("\\s+")[2]);

Car car=getCarByModel(cars, model);
            car.drive(kmToDrive);



            input= scanner.nextLine();
        }


        cars.forEach(car-> System.out.println(car));
    }

    private static Car getCarByModel(List<Car> cars, String model) {
        for(Car car: cars){
            if(car.getModel().equals(model)){
                return car;
            }

        }
        return null;
    }
}
