/**
 * Test driver for the MyHeap class.
 * 
 * @author Sean Reddell
 * @version 4/14/16
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class TestMyHeap
{
    private static final int MAXSIZE = 1000;
    private static final int MAXARRAYS = 100;
    private static final String FILENAME = "MyHeapTest.txt";
    
    /**
     * Takes in a string of integers and
     * reads them into an array.
     * Helper method for main().
     * 
     * @param testFile The string of ints.
     * @return Array of the ints.
     */
    private static int[] getNums(String line)
    {
        
        
        int numCount = 0;
        int[] nums;
        int[] tempNums = new int[MAXSIZE];
        
        
        Scanner numReader = new Scanner(line);
        
        while (numReader.hasNextInt())
        {
            tempNums[numCount++] = numReader.nextInt();
        }
        
        nums = new int[numCount];
        
        //fill the actual array with the numbers
        for (int j = 0; j < numCount; j++)
        {
            nums[j] = tempNums[j];
        }
      
        return nums;
    }
    
    /**
     * Prints out results of tests.
     * 
     * @param results Results from each test.
     */
    private static void checkPass(boolean[] results)
    {
        String[] testNames = new String[13];
        testNames[0] = "Default Constructor ";
        testNames[1] = "Param Constructor ";
        testNames[2] = "buildHeap ";
        testNames[3] = "heapContents ";
        testNames[4] = "insert ";
        testNames[5] = "findMax ";
        testNames[6] = "deleteMax ";
        testNames[7] = "isEmpty ";
        testNames[8] = "isFull ";
        testNames[9] = "getHeapCap ";
        testNames[10] = "getHeapSize ";
        testNames[11] = "driftDown ";
        testNames[12] = "driftup ";
        
        boolean passAll = true;
        
        for (int test = 0; test < 13; test++)
        {
            System.out.print(testNames[test]);
            
            //append result
            if (results[test])
            {
                System.out.println("passes tests.");
            }
            else
            {
                System.out.println("DOES NOT PASS ALL TESTS!");
                passAll = false;
            }
        }
        
        if (passAll)
        {
            System.out.println("All tests passed!");
        }
        else
        {
            System.out.println("NOT ALL TESTS PASS!");
        }
    }
    
    /**
     * Tests the methods of MyHeap with the
     * integers of a given file.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        String filename = FILENAME;
        
        /* //If directory change is required
        String directory = System.getProperty("user.dir"); //current working directory
        filename = directory + "\\" + filename;
        */
        
        //array of int arrays made from each line of the test file
        int[][] arrayFromLine = new int[MAXARRAYS][MAXSIZE];
        int lineNum = 1;
        
        //open and read from file
        try
        {
            File numFile = new File(filename);
            Scanner fileReader = new Scanner(numFile);
            
            //read each number and transfer to temp array
            for (int line = 1; fileReader.hasNextLine(); line++)
            {
                arrayFromLine[line] = getNums(fileReader.nextLine());
            }
        }
        catch (IOException ioe)
        {
            System.out.println("Error reading or opening the file.");
        }
        
        /* Test each method */
        //keep track of which tests pass
        boolean[] passing = new boolean[13];
        for (int b = 0; b < passing.length; b++)
        {
            passing[b] = true;
        }
        
        /* Test default constructor */
        //make heap
        //test capacity
        
        /* Test param constructor */
        //make other heap
        //test capacity
        
        /* Test getHeapCap() */
        //use either of the two from before?
        
        /* Test build heap */
        
        int[] tarBuildArray1 = 
            
        
        //build with nums
        //print contents
        
        /* Test getHeapSize */
        
        /* Test isFull */
        //make heap with capacity(nums.length)
        //test full
        //remove, test full
        //add, test full
        
        /* Test isEmpty */
        //make new, test empty
        //add, test empty
        //remove, test empty
        
        /* Test findMax */
        //build heap with nums
        //give size
        //give max
        //give size again
        //give max again
        
        /* Test deleteMax */
        //print deleteMax from last test
        //give new size
        //give new max?
        
        /* Test insert */
        //build empty array, insert new
        //build array from new, insert middling value
        //build full array, insert, get if false
        
        /* Test driftDown */
        //test that Drift down does not make changes if no errors
        int[] testDownArray = arrayFromLine[lineNum++];
        int[] tarDownArray = arrayFromLine[lineNum++];
        MyHeap downHeap1 = new MyHeap(31);
        //downHeap
        
        /* Test driftup */
        
        /* Check which passed */
        checkPass();
    }
}
