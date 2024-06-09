package F13_Generics_Lab.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jars = new Jar<>();
        jars.add(13);
        System.out.println(jars.remove());


    }
}
