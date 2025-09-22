package Sorting_Algos;

public class DataSorter {
    private SortingStrategy strategy;
    public DataSorter(SortingStrategy strategy){
        this.strategy = strategy;
    }
    public void sortData(int[] data){
        strategy.sort(data);
        // return Arrays.toString(sorted);
    }
}
