package Bookwithk;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TopKCategoryFinder finder = new TopKCategoryFinder();

        finder.addBook(new Book("b1", "Book One", "Author1", Arrays.asList("Fiction", "Thriller")));
        finder.addBook(new Book("b2", "Book Two", "Author2", Arrays.asList("Fiction", "Science")));
        finder.addBook(new Book("b3", "Book Three", "Author3", Arrays.asList("Science", "Non-Fiction")));

        int k = 2;
        List<Map.Entry<String, Integer>> topK = finder.getTopKCategories(k);

        for (Map.Entry<String, Integer> entry : topK) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
