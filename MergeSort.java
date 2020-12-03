package com.src;

public class MergeSort {
    private static void merge(int[] a,  int leftStart, int rightStart, int rightEnd){
        int leftEnd = rightStart - 1;
        int totalLength = rightEnd - leftStart + 1;
        int tempPos = 0; //begin at lowest index
        int[] temp = new int[totalLength];

        while(leftStart <= leftEnd  && rightStart <= rightEnd) {
            if (a[leftStart] <= a[rightStart]) {
                temp[tempPos] = a[leftStart];
                leftStart++;
            } else {
                temp[tempPos] = a[rightStart];
                rightStart++;
            }
            tempPos++;
        }

        while (leftStart <= leftEnd){  //if elements leftover
            temp[tempPos] = a[leftStart];
            tempPos++;
            leftStart++;
        }

        while (rightStart <= rightEnd){
            temp[tempPos] = a[rightStart];
            tempPos++;
            rightStart++;
        }

        //copy temporary array into original
        for (int i = 0; i < totalLength; i++) {
            a[rightEnd] = temp[totalLength - 1 - i];
            rightEnd--;
        }
    }

    public static void mergeSort(int[] arr) {
        //merge size 1, then size 2, then size 4, etc.
        for (int size = 1; size < arr.length; size=size*2){
            for (int start = 0; start < arr.length - size; start += size*2 ){
                //int[] temp = new int[size];
                merge(arr, start,  start + size, Math.min(start + size*2 -1, arr.length - 1));
            }
        }
    }
}
