package F5_Sets_and_Maps_Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> carSet = new LinkedHashSet<>();
        String input= scanner.nextLine();

        while(!input.equals("END")){
            String[] inpudData=input.split(", ");
            String direction=inpudData[0];
            String carNum=inpudData[1];

            if (direction.equals("IN")){
                carSet.add(carNum);
            }else if(direction.equals("OUT")){
                carSet.remove(carNum);
            }
            input=scanner.nextLine();

        }
        if(carSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            carSet.stream().forEach(e-> System.out.println(e));
        }

    }
}
