package F9_Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class _04_Add_VAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVAT = p -> p * 1.20;//dobavqn na 1.20
        //funkciq koqto e limitrane vhoden i izhoden da sa edin i sushit tip i metodut koito vikame e otnovo apply

        Consumer<double[]> printPricesVat = p -> {
            System.out.println("Prices with VAT:");
            //za vsqka edna cena
            System.out.println(Arrays.stream(p)
                    .map(addVAT)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPricesVat.accept(prices);



    }
}
