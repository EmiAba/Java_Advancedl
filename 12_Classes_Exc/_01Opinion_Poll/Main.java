package F12_Classes_Exc._01Opinion_Poll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String , Integer> opinionPol=new TreeMap<>();


        for (int i = 1; i <= n ; i++) {

            String[] data=scanner.nextLine().split("\\s+");
            String name=data[0];
            int age=Integer.parseInt(data[1]);

            Person person=new Person(name, age);
            opinionPol.put(person.getName(), person.getAge());


     }

        opinionPol.entrySet().stream().
                filter(e->e.getValue()>30)
                .forEach(e->System.out.println(e.getKey() + " - "+ e.getValue()));
             ;
  }
}
