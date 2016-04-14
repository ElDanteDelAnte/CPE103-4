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
    private static final int MAXNUMS = 1000;
    
    /**
     * Takes in the name of a file of integers and
     * puts them into an array for testing.
     * Helper method for main().
     * 
     * @return Numbers from a given file.
     */
    private static int[] getNums()
    {
        Scanner input = new Scanner(System.in);
        String filename = null;
        
        System.out.println("Enter name of test file:");
        
        //obtain name of file
        if (input.hasNextLine())
        {
            //take whole line to avoid later input difficulties
            Scanner lineReader = new Scanner(input.nextLine());
            
            //take only first token
            filename = lineReader.next();
        }
        
        /* //If directory change is required
        String directory = System.getProperty("user.dir"); //current working directory
        filename = directory + "\\" + filename;
        */
        
        int numCount = 0;
        int[] nums;
        int[] tempNums = new int[MAXNUMS];
        
        //open and read from file
        try
        {
            File numFile = new File(filename);
            Scanner fileReader = new Scanner(numFile);
            
            while (fileReader.hasNextInt())
            {
                tempNums[numCount++] = fileReader.nextInt();
            }
            
            //read each number and 
        }
        catch (IOException ioe)
        {
            System.out.println("Error reading or opening the file.");
        }
        //ensure nums is initialized
        finally
        {
            nums = new int[numCount];
            
            //fill the actual array with the numbers
            for (int j = 0; j < numCount; j++)
            {
                nums[j] = tempNums[j];
            }
        }
      
      return nums;
    }
    
    /**
     * Tests the methods of MyHeap with the
     * integers of a given file.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        int[] nums = getNums();
        
        /* Test default constructor */
        //make heap
        //test capacity
        
        /* Test param constructor */
        //make other heap
        //test capacity
        
        /* Test getHeapCap() */
        //use either of the two from before?
        
        /* Test build heap */
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
        
        /* Test driftup */
    }
}
