package F11_Classes_Lab.Car;

public class Car {
    private String brand;
    private String model;
    private int horsePower;




    public void setBrand(String brand) { //setteryt pozvolqva na horata da promenqy
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() { //ako iskash nqkoi da go chete
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    // @Override
    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", brand, model, horsePower);
    }
}

