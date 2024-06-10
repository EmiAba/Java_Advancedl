import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String ... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors );
    }

    private void setAuthors(String[] authors) {
        this.authors= Arrays.asList(authors);
    }


    private void setYear(int year) {
        this.year=year;
    }

    public int getYear() {
        return year;
    }

    private void setTitle(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Integer.compare(this.year, other.year);
        }
    }
}
