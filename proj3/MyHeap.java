
/**
 * Implements a MaxHeap using an array.
 * Now has a heapSortIncreasing method.
 * 
 * @author Sean Reddell
 * @version 4/18/16
 */
public class MyHeap
{
    private static final int DEFAULT_CAPACITY = 50;
    private int currentSize;
    private int[] array;

    /**
     * Constructs a MaxHeap of initial capacity 10.
     */
    public MyHeap()
    {
        currentSize = 0;
        array = new int[DEFAULT_CAPACITY + 1];
    }

    /**
     * Constructs MaxHeap of specified initial capacity.
     * 
     * @param initCap Initial capacity.
     */
    public MyHeap(int initCap)
    {
        currentSize = 0;
        array = new int[initCap + 1];
    }

    /**
     * Creates a heap from a set of integers using "bottom-up" approach.
     * 
     * @param  items Integers to build into a heap.
     * @return True if sucessful, false if capacity of MyHeap is too small. 
     */
    public boolean buildHeap(int[] items)
    {
        if (items.length > array.length - 1)
        {
            return false;
        }

        currentSize = 0;

        //insert at bottom, then drift up
        for (int i = 0; i < items.length; i++)
        {
            array[i + 1] = items[i];
            currentSize++;
            driftup(i + 1);
        }
        return true;
    }

    /**
     * Returns contents of the heap.
     * This is NOT the internal array.
     * 
     * @return Array representation of the heap.
     */
    public int[] heapContents()
    {
        int[] heapOut = new int[currentSize];

        //transfer contents into array, sans blank at index 0
        for (int i = 0; i < currentSize; i++)
        {
            heapOut[i] = array[i + 1];
        }
        return heapOut;
    }

    /**
     * Inserts an item into the heap.
     * 
     * @param item The item to be inserted.
     * @return True if successful, false if no room.
     */
    public boolean insert(int item)
    {
        if (isFull())
        {
            return false;
        }

        //put into end, then drift up
        currentSize++;
        array[currentSize] = item;
        driftup(currentSize);

        return true;
    }

    /**
     * Finds the largest item in the heap without changing it.
     * 
     * @return Largest element.
     */
    public int findMax()
    {
        //in case root once existed
        if (isEmpty())
        {
            return array[0];
        }
        return array[1];
    }

    /**
     * Removes the largest item and returns it.
     * 
     * @return Removed element.
     */
    public int deleteMax()
    {
        //in case root once existe
        if (isEmpty())
        {
            return array[0];
        }
        int max = array[1];

        array[1] = array[currentSize];
        currentSize--;
        driftDown(1);

        return max;
    }

    /**
     * Returns whether the heap is empty.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * Returns whether the heap is at maximum capacity.
     * 
     * @return True if full, false otherwise.
     */
    public boolean isFull()
    {
        return (array.length - 1) == currentSize;
    }

    /**
     * Returns the current capacity of the heap.
     * 
     * @return Current capacity.
     */
    public int getHeapCap()
    {
        return array.length - 1;
    }

    /**
     * Returns the number of items in the heap.
     * 
     * @return Number of items in the heap.
     */
    public int getHeapSize()
    {
        return currentSize;
    }

    /**
     * Drifts an item down until it restores the heap property.
     * 
     * @param firstInd Index of the item to be drifted.
     */
    public void driftDown(int firstInd)
    {
        int ind = firstInd;

        //keep switching until no more children
        while (ind * 2 < currentSize + 1)
        //... or until heap property satisfied
        //&& (array[ind] < array[2 * ind]
        //|| array[ind] < array[2 * ind + 1]))
        {
            //select target

            //take larger of the two (if two children)
            int tarInd;
            if ((ind * 2 < currentSize)
            && (array[2 * ind] < array[2 * ind + 1]))
            {
                tarInd = 2 * ind + 1;
            }
            else //left if equal (or one child)
            {
                tarInd = 2 * ind;
            }

            //switch if violates heap property
            if (array[ind] < array[tarInd])
            {
                int temp = array[ind];
                array[ind] = array[tarInd];
                array[tarInd] = temp;
            }

            //increment
            ind = tarInd;
        }
    }

    /**
     * Drifts an item up until it restores the heap property.
     * 
     * @param firstInd Index of the item to be drifted.
     */
    public void driftup(int firstInd)
    {
        int ind = firstInd;

        //drift up until heap property restored
        while (ind / 2 > 0)
        {

            //switch if violates heap property
            if (array[ind / 2] < array[ind])
            {
                int temp = array[ind / 2];
                array[ind / 2] = array[ind];
                array[ind] = temp;
                
            }
            ind = ind / 2;
        }
    }
    
    
    /** PROJECT 3 METHOD */
    
    /**
     * Sorts the contents of an array of integers in non-decreasing order.
     * 
     * @param unsorted The int array to be sorted.
     * @return The sorted int array.
     */
    public int[] heapSortIncreasing(int[] unsorted)
    {
        //preserve current state
        int[] prevContents = new int[array.length];
        for (int i = 1; i <= currentSize; i++)
        {
            prevContents[i] = array[i];
        }
        int prevSize = currentSize;
        
        //take in new array
        buildHeap(unsorted);
        
        //reverse the order
        int[] sorted = new int[unsorted.length];
        for (int j = unsorted.length - 1; j >= 0; j--)
        {
            sorted[j] = deleteMax();
        }
        //restore contents
        array = prevContents;
        currentSize = prevSize;
        
        return sorted;
    }
}
