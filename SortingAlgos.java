package com.src;

import static com.src.InsertionSort.insertionSort;
import static com.src.MergeSort.mergeSort;
import static com.src.QuickSort.quickSort;

public class SortingAlgos {
    public static void algorithm(ApiFileManager manager, int[] array, int algo) {
        long totalTime = 0;
        long startTime;
        long estimatedTime = 0;
        int n = 100; //no. of tests
        for (int i = 0; i < n; i++) {
            switch (algo) {
                case 1:
                    startTime = System.nanoTime();
                    insertionSort(array, array.length);
                    estimatedTime = System.nanoTime() - startTime;
                    //manager.writeToFile("outputs-insertionSort", array);
                    break;
                case 2:
                    startTime = System.nanoTime();
                    mergeSort(array);
                    estimatedTime = System.nanoTime() - startTime;
                    //manager.writeToFile("outputs-mergeSort", array);
                    break;
                case 3:
                    startTime = System.nanoTime();
                    quickSort(array, 0, array.length - 1, 1);
                    estimatedTime = System.nanoTime() - startTime;
                    //manager.writeToFile("outputs-quickSort", array);
                    break;
                case 4:
                    startTime = System.nanoTime();
                    quickSort(array, 0, array.length - 1, 2);
                    estimatedTime = System.nanoTime() - startTime;
                    //manager.writeToFile("outputs-quickSort", array);
                    break;
                case 5:
                    startTime = System.nanoTime();
                    quickSort(array, 0, array.length - 1, 3);
                    estimatedTime = System.nanoTime() - startTime;
                    //manager.writeToFile("outputs-quickSort", array);
                    break;
                case 6:
                    startTime = System.nanoTime();

                    estimatedTime = System.nanoTime() - startTime;
            }

            totalTime += estimatedTime;
            //manager.writeToFile("outputs-insertionSort", array);
            //System.out.println(estimatedTime);
        }
        long averageTime = totalTime/n;
        System.out.println("Average runTime = " + averageTime);
    }

    public void checkOutputs(int nTimes, int inputSize, String fileName) {
        for (int i= 0; i<nTimes; i++){
            int[] arr = new int[inputSize];
        }
    }
}

