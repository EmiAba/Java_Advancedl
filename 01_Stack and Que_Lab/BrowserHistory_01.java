package F1_Stacks_and_Queues_Lab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input= scanner.nextLine();
        ArrayDeque<String> historyStack=new ArrayDeque<>();
        String url=null;
        while(!input.equals("Home")){


            if(input.equals("back")){
                if(historyStack.isEmpty()){
                    System.out.println("no previous URLs");
                }else{
                  url=  historyStack.pop();
                    System.out.println(url);
                }

            }else{
                if (url!=null) {
                    historyStack.push(url);
                }
                    url = input;
                    System.out.println(url);

            }
            input= scanner.nextLine();
        }

    }
}
