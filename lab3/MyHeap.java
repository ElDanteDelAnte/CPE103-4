
/**
 * Implements a MaxHeap using an array.
 * 
 * @author Sean Reddell
 * @version 4/12/16
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
        if (items.length + 1 > array.length)
        {
            return false;
        }
        
        //insert at bottom, then drift up
        for (int i = 0; i < items.length; i++)
        {
            array[i + 1] = items[i];
            driftUp(i + 1);
            currentSize++;
        }
        return true;
    }
    
    /**
     * Returns contents of the heap.
     * 
     * @return Array representation of the heap.
     */
    public int[] heapContents()
    {
        return array;
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
        driftUp(currentSize);
        
        return true;
    }
    
    /**
     * Finds the largest item in the heap without changing it.
     * 
     * @return Largest element.
     */
    public int findMax()
    {
        return array[1];
    }
    
    /**
     * Removes the largest item and returns it.
     * 
     * @return Removed element.
     */
    public int deleteMax()
    {
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
        
        //keep switching until heap property satisfied
        while (array[ind] < array[2 * ind]
               || array[ind] < array[2 * ind + 1])
        {
            //take larger of the two
            int tarInd;
            if (array[2 * ind] < array[2 * ind + 1])
            {
                tarInd = 2 * ind + 1;
            }
            else
            {
                tarInd = 2 * ind;
            }
            
            //switch
            int temp = array[ind];
            array[ind] = array[tarInd];
            array[tarInd] = temp;
            
            //increment
            ind = tarInd;
        }
    }
    
    /**
     * Drifts an item up until it restores the heap property.
     * 
     * @param firstInd Index of the item to be drifted.
     */
    public void driftUp(int firstInd)
    {
        int ind = firstInd;
        
        //drift up until heap property restored
        while (array[ind / 2] < array[ind])
        {
            int temp = array[ind / 2];
            array[ind / 2] = array[ind];
            array[ind] = temp;
            ind = ind / 2;
        }
    }
    
    /**
     * Alias of driftUp() method, in case of naming issues.
     * 
     * @param firstInd Index of the item to be drifted.
     */
    public void driftup(int firstInd)
    {
        driftUp(firstInd);
    }
    
    /**
     * Test driver for MyHeap.
     * Takes the name of the file of integers and 
     * tests each method on them.
     * 
     * @param args Command-line arguments. args[1]
     * should be the name of a file of integers.
     */
    public static void main(String[] args)
    {
    }
}
