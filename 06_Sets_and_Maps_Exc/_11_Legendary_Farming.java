package F6_Sets_and_Maps_Exc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_Legendary_Farming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean legendaryObtained = false;
        String legendaryItem = "";

        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1];

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        legendaryObtained = true;
                        if (material.equals("shards")) {
                            legendaryItem = "Shadowmourne";
                        } else if (material.equals("fragments")) {
                            legendaryItem = "Valanyr";
                        } else if (material.equals("motes")) {
                            legendaryItem = "Dragonwrath";
                        }
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }
                } else {
                    junkMaterials.put(material, junkMaterials.getOrDefault(material, 0) + quantity);
                }
            }
            if (legendaryObtained) {
                break;
            }
        }

        System.out.println(legendaryItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().compareTo(e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
