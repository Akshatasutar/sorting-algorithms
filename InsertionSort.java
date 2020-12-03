package com.src;
import static com.src.RecursionLimiter.emerge;

public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        //emerge();
        if (n <= 1)  //base case - we have a sorted array
            return;
        else {
            insertionSort(arr, n-1);
            int temp = arr[n-1];
            int pos = n-2;
            while (pos >= 0 && arr[pos] > temp) {
                arr[pos + 1] = arr[pos];
                pos--;
            }
            arr[pos + 1] = temp;
        } //insert element into a sorted array
    }
}
