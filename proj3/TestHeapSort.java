
/**
 * Test driver for the heapSortIncreasing method in MyHeap.
 * 
 * @author Sean Reddell
 * @version 4/18/16
 */
public class TestHeapSort
{
    /**
     * Uses MyHeap to sort an array of integers.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        MyHeap testSort = new MyHeap();
        int[] dummyArray = {5, 9, 10, 7, 6, -2, 4};
        
        testSort.buildHeap(dummyArray);
        
        //build and test initial contents
        if ((testSort.getHeapSize() != 7) || testSort.findMax() != 10)
        {
            System.out.println("Problem building dummyArray");
        }
        
        int[] targArray = {-10, -5, 0, 0, 3, 7, 8, 12, 13, 15, 17, 20, 20, 25};
        int[] unsorted = {0, 20, 17, 15, 7, 8, 3, -10, 13, -5, 0, 12, 25, 20};
        
        //sort and obtain the result
        int[] sorted = testSort.heapSortIncreasing(unsorted);
        
        //tests matches target
        boolean matching = true;
        for (int i = 0; i < targArray.length; i++)
        {
            matching = matching && (targArray[i] == sorted[i]);
        }
        
        //check result
        if (matching)
        {
            System.out.println("Sorted successfully.");
        }
        else
        {
            System.out.println("SORTING ERROR!");
        }
        
        //check that initial contents are unaltered
        if ((testSort.getHeapSize() != 7) || testSort.findMax() != 10)
        {
            System.out.println("Problem restoring dummyArray");
        }
    }
}
