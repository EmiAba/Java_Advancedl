package spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LaunchPad {

    private final List<Spacecraft> spacecrafts;
    private final String name;
    private final int capacity;

    public LaunchPad(String name, int capacity) {
        this.spacecrafts = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (spacecrafts.size() >= capacity) {
            System.out.println("This launchpad is at full capacity!");
        } else if (spacecrafts.stream().anyMatch(s -> s.getName().equals(spacecraft.getName()))) {
            throw new RuntimeException("This spacecraft already exists!");
        } else {
            spacecrafts.add(spacecraft);
        }
    }

    public Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean removeSpacecraft(String name) {
        Spacecraft spacecraft = this.getSpacecraft(name);
        return spacecraft != null && spacecrafts.remove(spacecraft);
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public String getHeaviestSpacecraft() {
        Spacecraft heaviestSpacecraft = spacecrafts.stream()
                .max(Comparator.comparing(Spacecraft::getWeight))
                .orElse(null);
        return heaviestSpacecraft != null ?
                String.format("%s - %dkg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight())
                : "No spacecrafts available";
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> suitableSpacecrafts = spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getMissionType().equals(missionType))
                .collect(Collectors.toList());
        if (suitableSpacecrafts.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return suitableSpacecrafts;
    }

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        build.append("Spacecrafts launched from ").append(name).append(":");
        if (spacecrafts.isEmpty()) {
            build.append(System.lineSeparator()).append("none");
        } else {
            build.append(System.lineSeparator());
            for (int i = 0; i < spacecrafts.size(); i++) {
                build.append(i + 1).append(". ").append(spacecrafts.get(i).getName()).append(System.lineSeparator());
            }
        }
        return build.toString().trim();
    }
}
