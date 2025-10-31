package LibraryBookAvailabilitySystem;
import java.util.*;

public class Library {
    private List<book> books = new ArrayList<>();

    public void addBook(book b) { books.add(b); }
    public void removeBook(book b) { books.remove(b); }
    public List<book> getBooks() { return books; }
}