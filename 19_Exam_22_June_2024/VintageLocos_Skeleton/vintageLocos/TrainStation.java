package vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() >= capacity) {
            System.out.println("This train station is full!");
        } else if (locomotive.getGauge() != railGauge) {
            int difference = Math.abs(railGauge - locomotive.getGauge());
            System.out.println("The rail gauge of this station does not match the locomotive gauge! Difference: " + difference + " mm.");
        } else {
            locomotives.add(locomotive);
        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive() {
        return locomotives.stream()
                .max(Comparator.comparingInt(Locomotive::getMaxSpeed))
                .map(loco -> loco.getName() + " is the fastest locomotive with a maximum speed of " + loco.getMaxSpeed() + " km/h.")
                .orElse("There are no locomotives.");
    }

    public Locomotive getLocomotive(String name) {
        return locomotives.stream()
                .filter(locomotive -> locomotive.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {
        return locomotives.stream()
                .min(Comparator.comparing(Locomotive::getBuildDate))
                .map(Locomotive::getName)
                .orElse("There are no locomotives.");
    }

    public String getStatistics() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives departing from " + name + " station.";
        }

        StringBuilder statistics = new StringBuilder("Locomotives departed from " + name + ":\n");
        for (int i = 0; i < locomotives.size(); i++) {
            statistics.append(i + 1).append(". ").append(locomotives.get(i).getName()).append("\n");
        }

        return statistics.toString().trim();
    }
}
