import sorting.MergeSort;
import sorting.QuickSort;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[] {7,3,1,5,7,8,1,9,4};
        int[] arr2 = new int[] {7,3,1,5,7,8,1,9,4};

        MergeSort.mergeSort(arr1, 0, arr1.length-1);
        Arrays.stream(arr1).forEach(e -> System.out.print(e+" "));
        System.out.println();
        QuickSort.quickSort(arr2, 0, arr2.length-1);
        Arrays.stream(arr2).forEach(e -> System.out.print(e+" "));
    }
}