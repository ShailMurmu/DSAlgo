package sorting;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pIdx = partition(arr, low, high);
            quickSort(arr, low, pIdx-1);
            quickSort(arr, pIdx+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i<j) {
            while(i <= high && arr[i] <= pivot) i++;
            while(j >= low && arr[j] > pivot) j--;

            if(i<j) swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
