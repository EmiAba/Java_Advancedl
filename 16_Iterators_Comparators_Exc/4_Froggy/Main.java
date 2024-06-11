import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

List<Integer>  numbers=   Arrays.stream(scanner.nextLine().split(", "))
           .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake lake=new Lake(numbers);
        List<String> output=new ArrayList<>();

        for (Integer number : lake) {

           output.add(number.toString());

        }
        System.out.println(String.join(", ", output));

    }
}
