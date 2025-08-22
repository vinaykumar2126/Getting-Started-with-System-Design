// Map to keep track of category counts
Map<String, Integer> categoryCount = new HashMap<>();

// 1. Count categories
for (Book book : books) {
    for (String category : book.getCategories()) {
        categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
    }
}

// 2. Use a min-heap to find top K categories
PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
    Comparator.comparingInt(Map.Entry::getValue)
);

for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
    minHeap.offer(entry);
    if (minHeap.size() > K) {
        minHeap.poll(); // Remove the category with the smallest count
    }
}

// 3. Collect and sort the result in descending order
List<Map.Entry<String, Integer>> result = new ArrayList<>(minHeap);
result.sort((a, b) -> b.getValue() - a.getValue());

return result;
