package F12_Classes_Exc._03Speed_Racing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostPerKM;
    private  int distanceTraveled;

    public Car(String model, double fuel, double fuelCostPerKM) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKM = fuelCostPerKM;
        this.distanceTraveled=0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelCostPerKM() {
        return fuelCostPerKM;
    }

    public void setFuelCostPerKM(double fuelCostPerKM) {
        this.fuelCostPerKM = fuelCostPerKM;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void drive(int kmToDrive) {
        double requiredFuel=kmToDrive*fuelCostPerKM;

        if(fuel>=requiredFuel){
            fuel-=requiredFuel;
            distanceTraveled+=kmToDrive;

        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }
    public String toString(){
        return String.format("%s %.2f %d", model, fuel, distanceTraveled);
    }
}
