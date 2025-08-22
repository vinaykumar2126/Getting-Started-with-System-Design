package Bookwithk;
import java.util.*;

public class TopKCategoryFinder {
    private Map<String, Integer> categoryCount;

    public TopKCategoryFinder() {
        categoryCount = new HashMap<>();
    }

    public void addBook(Book book) {
        for (String category : book.getCategories()) {
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }
    }

    public List<Map.Entry<String, Integer>> getTopKCategories(int k) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            minHeap.add(entry);  //offer
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Map.Entry<String, Integer>> result = new ArrayList<>(minHeap);
        // Sort in descending order by count
        result.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return result;
    }
}
