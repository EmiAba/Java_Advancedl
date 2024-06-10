import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
//
//        for (Book book : books) {
//            System.out.println("Title: " + book.getTitle());
//            System.out.println("Year: " + book.getYear());
//            System.out.println("Authors: " + book.getAuthors());
//            System.out.println();
//
//        }

    }
}