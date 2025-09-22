package Sorting_Algos;

public class Main {
    public static void main(String[] args){
        DataSorter sorter = new DataSorter(new MergeSort());
        int arr[] = {1,2,3,2,5};
        sorter.sortData(arr);
    }
    
}

