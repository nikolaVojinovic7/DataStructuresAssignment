package com.company;

//Nikola Vojinovic
//101181089

import java.util.Random;
import java.text.NumberFormat;

public class Main {
    //Creating a static function to help me copy over the elements from the core array to the other sized arrays
    public static void copyData(UnorderedArray dataSize , UnorderedArray coreData, int numItems){
        for(int x = 0; x<numItems; x++){
            dataSize.addLast(coreData.getElementAtIndex(x));
        }
    }
    public static void main(String[] args) {

        //Creating a format for the numbers to be printed in groups of 3
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        //Creating objects of the Unordered Array class of sizes, 50, 100, 1000, 10,000 , 100,000 and 1,000,000
        UnorderedArray coreData = new UnorderedArray(1000000);
        UnorderedArray dataSize50 = new UnorderedArray(50);
        UnorderedArray dataSize1000 = new UnorderedArray(1000);
        UnorderedArray dataSize10000 = new UnorderedArray(10000);
        UnorderedArray dataSize100000 = new UnorderedArray(100000);

        //Initializing random variable
        Random rand = new Random();

        //Filling the core 1,000,000 data set with random integers
        for(int x = 0; x<1000000; x++){
            int val = rand.nextInt(3000001);
            coreData.addLast(val);
        }

        //Copying over all the integers in the core data to the other arrays using the static method
        copyData(dataSize50, coreData, 50);

        copyData(dataSize1000, coreData, 1000);

        copyData(dataSize10000, coreData, 10000);

        copyData(dataSize100000, coreData, 100000);

        //Create clones of each of the data sizes for each of the different sorts, so that they are
        //all performing their sorts on the same set of randomized data
        UnorderedArray dataSize50Clone1 = dataSize50.cloneArray();
        UnorderedArray dataSize50Clone2 = dataSize50.cloneArray();
        UnorderedArray dataSize50Clone3 = dataSize50.cloneArray();

        UnorderedArray dataSize1000Clone1 = dataSize1000.cloneArray();
        UnorderedArray dataSize1000Clone2 = dataSize1000.cloneArray();
        UnorderedArray dataSize1000Clone3 = dataSize1000.cloneArray();

        UnorderedArray dataSize10000Clone1 = dataSize10000.cloneArray();
        UnorderedArray dataSize10000Clone2 = dataSize10000.cloneArray();
        UnorderedArray dataSize10000Clone3 = dataSize10000.cloneArray();

        UnorderedArray dataSize100000Clone1 = dataSize100000.cloneArray();
        UnorderedArray dataSize100000Clone2 = dataSize100000.cloneArray();
        UnorderedArray dataSize100000Clone3 = dataSize100000.cloneArray();

        UnorderedArray coreDataClone = coreData.cloneArray();
        UnorderedArray coreDataClone2 = coreData.cloneArray();
        UnorderedArray coreDataClone3 = coreData.cloneArray();

        //Here we are taking the time for sorting the array of size 50, using the timeTaken(SortType)Sort function
        //which are located in the Unordered Array Class
        //the isCoreData boolean is false to make sure it is timed in nanoseconds
        //myformat.format(timeTaken) allows the numbers to be grouped in threes, separated by commas
        long timeTaken = dataSize50.timeTakenInsertionSort(dataSize50, "50", false);
        System.out.println("Insertion Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize50Clone1.timeTakenSelectionSort(dataSize50Clone1, false);
        System.out.println("Selection Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize50Clone2.timeTakenMergeSort(dataSize50Clone2, false);
        System.out.println("Merge Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize50Clone3.timeTakenQuickSort(dataSize50Clone3, false);
        System.out.println("Quick Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        System.out.println();

        //Time taken for data size 1000
        timeTaken = dataSize1000.timeTakenInsertionSort(dataSize1000, "1000", false);
        System.out.println("Insertion Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize1000Clone1.timeTakenSelectionSort(dataSize1000Clone1, false);
        System.out.println("Selection Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize1000Clone2.timeTakenMergeSort(dataSize1000Clone2, false);
        System.out.println("Merge Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize1000Clone3.timeTakenQuickSort(dataSize1000Clone3, false);
        System.out.println("Quick Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        System.out.println();

        //Time taken for data size 10,000
        timeTaken = dataSize10000.timeTakenInsertionSort(dataSize10000, "10000", false);
        System.out.println("Insertion Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize10000Clone1.timeTakenSelectionSort(dataSize10000Clone1, false);
        System.out.println("Selection Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize10000Clone2.timeTakenMergeSort(dataSize10000Clone2, false);
        System.out.println("Merge Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize10000Clone3.timeTakenQuickSort(dataSize10000Clone3, false);
        System.out.println("Quick Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        System.out.println();

        //Time taken for data size 100,000
        timeTaken = dataSize100000.timeTakenInsertionSort(dataSize100000, "100000", false);
        System.out.println("Insertion Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize100000Clone1.timeTakenSelectionSort(dataSize100000Clone1, false);
        System.out.println("Selection Sort: " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize1000Clone2.timeTakenMergeSort(dataSize100000Clone2, false);
        System.out.println("Merge Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        timeTaken = dataSize1000Clone3.timeTakenQuickSort(dataSize100000Clone3, false);
        System.out.println("Quick Sort:     " + myFormat.format(timeTaken) + " nanoseconds");

        System.out.println();

        //Time taken for data size 1,000,000
        //isCoreData is true so that the time is taken in milliseconds as opposed to nano
        timeTaken = coreData.timeTakenInsertionSort(coreData, "1000000", true);
        System.out.println("Insertion Sort: " + myFormat.format(timeTaken) + " milliseconds");

        timeTaken = coreDataClone.timeTakenSelectionSort(coreDataClone, true);
        System.out.println("Selection Sort: " + myFormat.format(timeTaken) + " milliseconds");

        timeTaken = coreDataClone2.timeTakenMergeSort(coreDataClone2, true);
        System.out.println("Merge Sort:     " + myFormat.format(timeTaken) + " milliseconds");

        timeTaken = coreDataClone3.timeTakenQuickSort(coreDataClone3, true);
        System.out.println("Quick Sort:     " + myFormat.format(timeTaken) + " milliseconds");
    }
}
