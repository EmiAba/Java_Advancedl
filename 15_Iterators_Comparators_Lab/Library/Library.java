import java.util.Iterator;
import java.util.NoSuchElementException;

public class Library implements Iterable<Book> {
    private Book[] books;

    // Constructor
    public Library(Book... books) {
        this.books = books;
    }

    // Method to return an iterator
    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    // Nested LibIterator class
    private class LibIterator implements Iterator<Book> {
        private int counter = 0;

        // Check if there is a next element
        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        // Return the next element
        @Override
        public Book next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return books[counter++];
        }
    }
}
