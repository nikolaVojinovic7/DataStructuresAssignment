package com.company;


//Nikola Vojinovic
//101181089

class UnorderedArray
{
    //fields for class
    private int[] mArray;
    private int maxSize;
    private int numItems;

    //constructor for class
    public UnorderedArray(int maxSize)
    {
        numItems = 0;
        this.maxSize = maxSize;
        mArray = new int[maxSize];
    }

    //function that will clone the array and initialize all the values
    public UnorderedArray cloneArray(){
        UnorderedArray clone = new UnorderedArray(maxSize);
        clone.mArray = mArray.clone();
        clone.numItems = numItems;
        return clone;
    }

    //Adds to element at the end of the mArray
    public void addLast(int key)
    {
        if(numItems < maxSize)
        {
            mArray[numItems] = key;
            numItems++;
        }

    }

    //this is the code that is the selection sort
    public void selectionSort()
    {
        for(int x = 0; x < numItems; x++)
        {
            int smallestLoc = x;
            for(int y = x+1; y<numItems; y++)
            {
                if(mArray[y]< mArray[smallestLoc])
                {
                    smallestLoc = y;
                }
            }
            int temp = mArray[x];
            mArray[x] = mArray[smallestLoc];
            mArray[smallestLoc] = temp;
        }
    }

    //this function will return the element at a given index
    public int getElementAtIndex(int index){
        return  mArray[index];
    }


    //this is the insertion sort function that will sort it ascending
    public void insertionSortAsc(){
        for(int x=1 ; x<numItems ; x++){   //get the starting point
            int temp = mArray[x];  //take the item out
            int pos = x -1;
            while(pos >= 0 && mArray[pos]>temp){
                mArray[pos+1] = mArray[pos];  //shift item up
                pos--;                         //move position left
            }
            mArray[pos+1] = temp;  //insert item in the empty spot
        }
    }

    //merge sort initial call function
    public void mergeSort(){
        mergeSort(mArray, new int[mArray.length], 0 , mArray.length - 1);
    }

    //merge sort
    private void mergeSort(int [] array , int[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle+1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    //part of the merge sort
    private void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (rightEnd + leftStart)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            }else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    //this is the quick sort function that is initially called
    public void quicksort() {
        quicksort(mArray, 0, mArray.length -1);
    }

    //quick sort function
    public void quicksort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = array[(left+right)/2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }

    //part of the quick sort
    public int partition(int[] array, int left, int right, int pivot){
        while(left<=right){
            while(array[left] < pivot){
                left++;
            }
            while(array[right] > pivot){
                right--;
            }
            if(left <= right){

                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    //this function takes the specific sized array, times the start, the end and does insertion sort on it
    //The isCoreData boolean tells the function whether to count in nanoseconds or milliseconds
    public long timeTakenInsertionSort(UnorderedArray dataSize, String numItems, boolean isCoreData){
        System.out.println("***** Times Taken for set of " + numItems +" ******");
        long start, end;
        if (isCoreData){
            start = System.currentTimeMillis();
            dataSize.insertionSortAsc();
            end = System.currentTimeMillis();
        }
        else{
            start = System.nanoTime();
            dataSize.insertionSortAsc();
            end = System.nanoTime();
        }
        return end - start;
    }

    //this function takes the specific sized array, times the start, the end and does selection sort on it
    public long timeTakenSelectionSort(UnorderedArray dataSize, boolean isCoreData){
        long start, end;
        if (isCoreData){
            start = System.currentTimeMillis();
            dataSize.selectionSort();
            end = System.currentTimeMillis();
        }
        else {
            start = System.nanoTime();
            dataSize.selectionSort();
            end = System.nanoTime();
        }
        return end - start;
    }

    //this function takes the specific sized array, times the start, the end and does merge sort on it
    public long timeTakenMergeSort(UnorderedArray dataSize, boolean isCoreData){
        long start, end;
        if (isCoreData){
            start = System.currentTimeMillis();
            dataSize.mergeSort();
            end = System.currentTimeMillis();
        }
        else {
            start = System.nanoTime();
            dataSize.mergeSort();
            end = System.nanoTime();
        }
        return end - start;
    }

    //this function takes the specific sized array, times the start, the end and does quick sort on it
    public long timeTakenQuickSort(UnorderedArray dataSize, boolean isCoreData){
        long start, end;
        if (isCoreData){
            start = System.currentTimeMillis();
            dataSize.quicksort();
            end = System.currentTimeMillis();
        }
        else {
            start = System.nanoTime();
            dataSize.quicksort();
            end = System.nanoTime();
        }
        return end - start;
    }

}
