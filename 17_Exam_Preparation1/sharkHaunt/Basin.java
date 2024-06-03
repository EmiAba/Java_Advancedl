package sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    // Constructor
    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    // Method to add a shark
    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    // Method to remove a shark by kind
    public boolean removeShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                sharks.remove(shark);
                return true;
            }
        }
        return false;
    }

    // Method to get the largest shark by length
    public Shark getLargestShark() {
        if (sharks.isEmpty()) {
            return null;
        }
        Shark largest = sharks.get(0);
        for (Shark shark : sharks) {
            if (shark.getLength() > largest.getLength()) {
                largest = shark;
            }
        }
        return largest;
    }

    // Method to get a shark by kind
    public Shark getShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    // Method to get the count of sharks in the basin
    public int getCount() {
        return sharks.size();
    }

    // Method to get the average length of sharks in the basin
    public int getAverageLength() {
        if (sharks.isEmpty()) {
            return 0;
        }
        int totalLength = 0;
        for (Shark shark : sharks) {
            totalLength += shark.getLength();
        }
        return totalLength / sharks.size();
    }

    // Method to generate a report of the sharks in the basin
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Sharks in ").append(name).append(":\n");
        for (Shark shark : sharks) {
            report.append(shark).append("\n");
        }
        return report.toString().trim(); // trim to remove the last newline character
    }

}
