package F5_Sets_and_Maps_Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_Product_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shopData = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Revision")) {
                break;
            }

            String[] parts = input.split(", ");
            String shop = parts[0];
            String product = parts[1];
            double price = Double.parseDouble(parts[2]);

            shopData.putIfAbsent(shop, new TreeMap<>());
            shopData.get(shop).put(product, price);
        }

        for (Map.Entry<String, Map<String, Double>> shopEntry : shopData.entrySet()) {
            String shop = shopEntry.getKey();
            System.out.println(shop + "->");
            for (Map.Entry<String, Double> productEntry : shopEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productEntry.getKey(), productEntry.getValue());
            }
        }

        scanner.close();
    }
}
