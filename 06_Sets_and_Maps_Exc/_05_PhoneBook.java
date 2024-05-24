package F6_Sets_and_Maps_Exc;

import java.util.*;

public class _05_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

     String input= scanner.nextLine();


     while(!input.equals("search")){
         String[] data=input.split("-");
         String name=data[0];
         String phoneNumber=data[1];

    phonebook.put(name, phoneNumber);

      input= scanner.nextLine();

     }

     String name=scanner.nextLine();

     while(!name.equals("stop")){

         if(phonebook.containsKey(name)){
             System.out.printf("%s -> %s%n", name, phonebook.get(name));

         }else{
             System.out.printf("Contact %s does not exist.%n", name);
         }

         name= scanner.nextLine();
     }



    }
}
