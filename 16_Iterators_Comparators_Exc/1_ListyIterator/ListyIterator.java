import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListyIterator {
    private List<String> elements;
    private int index;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(this.index));
    }


}
