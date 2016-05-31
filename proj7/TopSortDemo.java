/**
 * Demo test driver for the TopSorter class.
 * 
 * Project  8.
 * 
 * @author Sean Reddell
 * @version 5/31/16
 */

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class TopSortDemo
{
    private static void testOutput(ArrayList<Integer> test, int num)
    {
        System.out.println("Test " + num + ":");
        for (Integer vert : test)
            System.out.print(vert + " ");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        testOutput(TopSorter.topSortGenerator("TopTest1.txt"), 1);
        testOutput(TopSorter.topSortGenerator("TopTest2.txt"), 2);
        testOutput(TopSorter.topSortGenerator("TopTest3.txt"), 3);
        testOutput(TopSorter.topSortGenerator("TopTest4.txt"), 4);
        testOutput(TopSorter.topSortGenerator("TopTest5.txt"), 5);
        testOutput(TopSorter.topSortGenerator("TopTest6.txt"), 6);
    }
}
