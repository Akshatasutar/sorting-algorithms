package com.src;

import java.util.Arrays;

import static com.src.SortingAlgos.algorithm;

public class Main {

    public static void main(String[] args) {
        ApiFileManager manager = new ApiFileManager();
/*
        int[] array = {84,64};

        //mergeSort(array);

        quickSort(array, 0, array.length - 1, 2);
        System.out.println(Arrays.toString(array));


 */

        /*
        int[] medianTestArr = {3,1,3};
        int median = medianOf3(medianTestArr,0,2);
        System.out.println(median);

         */

        //10,100, 1000, 10000, 100000, 1000000
        int[] inputSizes = {10000, 100000};
        //int[] inputSizes = {10,100, 1000, 10000, 100000};

        for (int n: inputSizes) {
            int[] arr = new int[n];
            manager.readIntFile("Seminar 1 - File with random numbers.txt", arr);
            System.out.println("n = " + n);
            System.out.println("Insertion sort: ");
            //algorithm(manager, arr, 1);
            System.out.println("Merge sort: ");
            algorithm(manager, arr, 2);
            System.out.println("Quick sort- medianOf3: ");
            algorithm(manager, arr, 3);
            System.out.println("Quick sort- random: ");
            algorithm(manager, arr, 4);
            System.out.println("Quick sort- a[0]: ");
            algorithm(manager, arr, 5);
            System.out.println("------------------------------------------------------------");
        }
    }
}
