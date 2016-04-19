/**
 * Test driver for the MyHeap class.
 * 
 * @author Sean Reddell
 * @version 4/17/16
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
        System.out.println(); //single-line buffer in printout
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
        
        String[] lines = new String[MAXLINES];
        
        //open and read from file
        try
        {
            File numFile = new File(filename);
            Scanner fileReader = new Scanner(numFile);
            
            //read each number and transfer to temp array
            for (int lineNum = 1; lineNum <= MAXLINES && fileReader.hasNextLine(); lineNum++)
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
        
        //tests construction
        if ((testDef.getHeapCap() != 50)
           || (testDef.getHeapSize() != 0))
        {
            passing[0] = false;
        }
        
        //empty case for insert
        testDef.insert(5);

        if ((testDef.findMax() != 5)
           || (testDef.getHeapSize() != 1)
           || (testDef.getHeapCap() != 50))
        {
            passing[4] = false;
        }
        
        //tests isFull
        if (testDef.isFull())
        {
            passing[8] = false;
        }
        
        //tests isEmpty
        if (testDef.isEmpty())
        {
            passing[7] = false;
        }

        //tests that findMax does not remove
        if ((testDef.findMax() != 5)
           || (testDef.getHeapSize() != 1)
           || (testDef.getHeapCap() != 50))
        {
            passing[5] = false;
        }
        
        //tests deleteMax does remove max and heap is empty again at size 0
        int five = testDef.deleteMax();
        if (!testDef.isEmpty() || five != 5)
        {
            passing[6] = false;
        }
        
        //tests that max was removed
        if (testDef.findMax() == 5)
        {
            passing[5] = false;
        }
        
        
        /* New Heap, cap 30 */
        MyHeap testSet = new MyHeap(30);
        
        //tests if constructed correctly
        if ((testSet.getHeapCap() != 30)
           || (testSet.getHeapSize() != 0))
        {
            passing[1] = false;
        }
        
        
        int[] tarArray1 = getNums(lines[1]);
        int[] testArray1 = getNums(lines[2]);
        passing[2] = passing[2] && testSet.buildHeap(testArray1);
        int[] resArray1 = testSet.heapContents();
        for (int i = 0; i < tarArray1.length; i++)
        {
            if (resArray1[i] != tarArray1[i])
            {
                passing[2] = false;
            }
        }
        
        //tests if driftDown takes left when children are equal
        //tests if driftDown only makes changes if heap property violated
        int[] tarArray2 = getNums(lines[4]);
        testSet.deleteMax();
        int[] resArray2 = testSet.heapContents();
        for (int i = 0; i < tarArray2.length; i++)
        {
            if (resArray2[i] != tarArray2[i])
            {
                passing[11] = false;
            }
        }
        
        int[] tarArray3 = getNums(lines[6]);
        int[] testArray3 = getNums(lines[7]);
        passing[2] = passing[2] && testSet.buildHeap(testArray3);
        int[] resArray3 = testSet.heapContents();
        //tests scope of heapContents
        for (int i = 0; i < tarArray3.length; i++)
        {
            if (resArray3[i] != resArray3[i])
            {
                passing[3] = false;
            }
        }
        
        int[] tarArray4 = getNums(lines[9]);
        testSet.deleteMax();
        int[] resArray4 = testSet.heapContents();
        //tests scope of driftDown
        for (int i = 0; i < tarArray4.length; i++)
        {
            if (tarArray4[i] != resArray4[i])
            {
                passing[11] = false;
            }
        }
        
        int[] tarArray5 = tarArray4;
        int[] testArray5 = getNums(lines[11]);
        testSet.buildHeap(testArray5);
        int[] resArray5 = testSet.heapContents();
        //tests that buildHeap returns false if array too big
        if (testSet.buildHeap(testArray5))
        {
            passing[2] = false;
        }
        
        //tests that buildHeap makes no changes if array too big
        for (int i = 0; i < tarArray5.length; i++)
        {
            if (tarArray5[i] != resArray5[i])
            {
                passing[2] = false;
            }
        }
        
        int[] tarArray6 = getNums(lines[13]);
        int[] testArray6 = getNums(lines[14]);
        passing[2] = passing[2] && testSet.buildHeap(testArray6);
        
        //tests that driftup only makes changes if violation of heap property
        passing[4] = passing[4] && testSet.insert(17);
        
        //tests that driftup terminates at root
        passing[4] = passing[4] && testSet.insert(35);
        
        
        int[] resArray6 = testSet.heapContents();
        
        for (int i = 0; i < tarArray6.length; i++)
        {
            if (tarArray6[i] != resArray6[i])
            {
                System.out.print(i + " ");
                passing[12] = false;
            }
        }
        
        //tests isFull
        passing[8] = passing[8] && testSet.isFull();
        
        //getHeapSize full case
        passing[10] = passing[10] && (testSet.getHeapSize() == 30);
        
        

        checkPass(passing);
    }
}
