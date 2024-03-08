package sorting;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            mergeArr(arr, low, mid, high);
        }
    }

    private static void mergeArr(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] tempArr = new int[high-low+1];
        int z = 0;

        while(i<=mid && j<=high) {
            if(arr[i] <= arr[j]) tempArr[z++] = arr[i++];
            else tempArr[z++] = arr[j++];
        }
        while (i<=mid) tempArr[z++] = arr[i++];
        while (j<=high) tempArr[z++] = arr[j++];

        for(i = low; i<= high; i++) arr[i] = tempArr[i-low];
    }
}
