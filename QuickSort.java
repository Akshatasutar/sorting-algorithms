package com.src;

import java.security.SecureRandom;

public class QuickSort {
    private static void swapPos(int[] arr, int toSwap, int swapTo){
        int temp = arr[toSwap];
        arr[toSwap] = arr[swapTo];
        arr[swapTo] = temp;
    }

    private static int medianOf3(int[] a, int left, int right) {
        int center = (left + right)/2;
        //int median;
        if (a[left] > a[center]){  //sort first 2 elements
            swapPos(a,center,left);
        }
        //insert right
        if (a[right] < a[center]) {
            swapPos(a, right, center);
        }
        if (a[center] < a[left]) {
            swapPos(a, center, left);
        }
        //median = a[center];

        //place pivot at end
        //swapPos(a, center,right);

        return center;
    }

    private static int getPivot(int[] arr, int l, int r, int pivotChoice) {
        int p = 0;
        switch (pivotChoice) {
            case 1:
                p = medianOf3(arr, l, r);
                break;
            case 2:
                SecureRandom rand = new SecureRandom();
                p = l + rand.nextInt(r - l);
                break;
            case 3:
                p = l;
                break;
        }
        int pivot = arr[p];
        swapPos(arr, p,r);  //Swap pivot with no. at end
        return pivot;
    }

    public static int partition(int [] arr, int left, int right, int pivot){
        int i = left;
        int j = right - 1;
        while (true) {
            while (arr[i] < pivot && i < arr.length) {i++;}
            while (arr[j] > pivot && j>0) {j--;} //index out of bounds when j == 1
            if (i < j) {
                swapPos(arr, i,j);
                if (arr[i] == arr[j]) i++;
            }
            else break;
        }
        swapPos(arr, i, right);
        return i;
    }

    public static void quickSort(int[] arr, int left, int right, int pivotChoice) {
        // Create an auxiliary stack
        int[] stack = new int[right - left + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = left;
        stack[++top] = right;
        int pivot;
        int p;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            right = stack[top--];
            left = stack[top--];

            if (right - left <= 1){ //only 2 elements in array ------- INDEX OUT OF BOUNDS!!
                if (arr[left] > arr[right])
                    swapPos(arr, left, right);
            }

            else {
                pivot = getPivot(arr, left, right, pivotChoice);
                p = partition(arr, left, right, pivot);

                // If there are elements on left side of pivot,
                // then push left side to stack
                if (p - 1 > left) {
                    stack[++top] = left;  //left
                    stack[++top] = p - 1;  //right
                }

                // If there are elements on right side of pivot,
                // then push right side to stack
                if (p + 1 < right) {
                    stack[++top] = p + 1;  //left
                    stack[++top] = right;  //right
                }
            }
        }
        //quickSort(arr, left, i-1, 1);
        //quickSort(arr, i + 1, right, 1);
    }
}
