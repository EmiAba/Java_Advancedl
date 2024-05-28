package F9_Functional_Programming_Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _05_Filter_By_Age {

    public static class Person {
        String name;
        int age;

      
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//chete imena i godini i kriterii i fomrmat po koito da se pechatat horata
//she se raboti cs classs
//chetene na hora bez cikul
        int n = Integer.parseInt(scanner.nextLine());    //broi hora
//ot skenera da se vurne person i za tova davam FUnkciq koqto priema skennera i vrusha obekt
        Function<Scanner, Person> readPerson = sc -> {
            String[] data = sc.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };
        //posle puskame edin int stream v obhvat 0 do n i vseki red ot inputa da se MAPNE   ( mapToObject, koito obekt otiva

        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson.apply(scanner))
                .collect(Collectors.toList());

//da prochetem kriterq, age i format za pechatane
        // trqbva da imame filter za horata i Printer
        //
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        //i go pishem v metod
        Predicate<Person> ageFilter=getFilter(condition, age);
        Consumer<Person> printer = getPrinter(format);


        people.stream()
                .filter(ageFilter) //redicat
                .forEach(printer); //consumer
    }

    private static Consumer<Person> getPrinter(String format) {
        switch(format){
            case "name":
                return p->System.out.println(p.name);
            case "age":
                return p->System.out.println(p.age);
            case "name age":
                return p->System.out.println(p.name +" - "+p.age);
            default:
                throw new IllegalArgumentException("Unknown print format" + format);
        }
    }

    private static Predicate<Person> getFilter(String condition, int age) {
        switch(condition){
            case "older":
                return p->p.age>=age;
            case "younger":
                return p->p.age<=age;
            default:
                throw new IllegalArgumentException ("Unknown Condition" +condition);
        }


    }
}
