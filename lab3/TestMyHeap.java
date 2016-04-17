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
    private static final int MAXLINES = 100;
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
        
        String[] lines = new Sring[MAXLINES];
        
        //open and read from file
        try
        {
            File numFile = new File(filename);
            Scanner fileReader = new Scanner(numFile);
            
            //read each number and transfer to temp array
            for (int lineNum = 1; lineNum < MAXLINES && fileReader.hasNextLine(); line++)
            {
                lines[lineNum] = fileReader.nextLine();
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
        
        /* 0. Test default constructor */
        MyHeap testDef = new MyHeap();
	passing[0] = passing[0] && (testDef.getHeapCap() == 50);
        //passing[0] = passing[0] && (testDef.isEmpty()); //move to test empty
        passing[0] = passing[0] && (testDef.getHeapSize() == 0);
        
        if ((testDef.getHeapCap() != 50)
           || (testDef.getHeapSize() != 0))
        {
            passing[0] = false;
        }
        //empty case for insert
        testDef.insert(5);

        if ((testDef.findMax() != 5)
           || (testDef.getHeapSize() != 1)
           || (testDef.getHeapCapacity() != 50))
        {
            passing = false;
        }
        
        //tests isFull
        if (testDef.isFull())
        {
            passing = false;
        }
        
        //tests isEmpty
        if (testDef.isEmpty())
        {
            passing = false;
        }

        //tests that findMax does not remove
        if ((testDef.findMax() != 5)
           || (testDef.getHeapSize() != 1)
           || (testDef.getHeapCapacity() != 50)
        {
            passing = false;
        }
        
        /* 1. Test param constructor */
        MyHeap testSet = new MyHeap(30);
        
        if ((testSet.getHeapCap != 30)
           || testSet.getHeapSize != 0))
        {
            passing[1] = false;
        }

        /* 2. Test getHeapCap() */
        //check during build-over test
        
        /* 3. Test build heap */
        //build heap
        int[] tarBuildArray1 = 
        //build over that heap
        //build too big
        
        
        /* 4. Test getHeapSize */
        //empty case
        //full case
        //make sure size != cap
        //after insert, delete
        
        /* 5. Test isFull */
        //make heap with capacity(nums.length)
        //test full
        //remove, test full
        //add, test full
        
        /* 6. Test isEmpty */
        //make new, test empty
        //add, test empty
        //remove, test empty
        
        /* 7. Test findMax */
        //build heap with nums
        //give size
        //give max
        //give size again
        //give max again
        
        /* 8. Test deleteMax */
        //deleteMax from last test, check size, check new max
        //different case, check left duplicate moves up (applies to driftup)
        
        /* 9. Test insert */
        //insert to empty heap
        //insert middling value
        //insert when too full
        //insert when duplicate
        
        /* 10. Test driftDown */
        //test that Drift down does not make changes if no errors
        //build-over case, only sees as far as currentSize
        int[] testDownArray = getNums(lines[lineNum++]);
        int[] tarDownArray = getNums([lineNum++]);
        MyHeap downHeap1 = new MyHeap(31);
        //downHeap
        //tests that driftDown takes the left duplicate
        
        /* 11. Test driftup */
        //does not change if not needed
        //does not see beyond currentSize (build-over case)
        
        /* Check which passed */
        checkPass();
    }
}
