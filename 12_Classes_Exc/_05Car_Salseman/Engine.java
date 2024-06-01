package F12_Classes_Exc._05Car_Salseman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = (displacement != null) ? displacement : "n/a";
        this.efficiency = (efficiency != null) ? efficiency : "n/a";
    }

    public Engine(String model, int power) {
        this(model, power, null, null);
    }

    public Engine(String model, int power, String displacementOrEfficiency) {
        this(model, power,
                (isNumeric(displacementOrEfficiency) ? displacementOrEfficiency : null),
                (!isNumeric(displacementOrEfficiency) ? displacementOrEfficiency : null));
    }

    @Override
    public String toString() {
        return String.format("%s:\nPower: %d\nDisplacement: %s\nEfficiency: %s", model, power, displacement, efficiency);
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
