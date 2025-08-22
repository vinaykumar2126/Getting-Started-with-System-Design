package Bookwithk;
import java.util.*;
public class Book {
    private String bookId;
    private String title;
    private String author;
    private List<String> categories;

    public Book(String bookId, String title, String author, List<String> categories) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }

    // Getters and setters can be added as needed
}
