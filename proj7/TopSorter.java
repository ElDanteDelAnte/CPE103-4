/**
 * Produces a topological ordering of a Directed Acyclical Graph.
 * Target runtime: O(|E| + |V|)
 * 
 * Project 7: Topological Sort
 * 
 * @author Sean Reddell
 * @version 5/26/16
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.io.IOException;

public class TopSorter
{
    /**
     * Builds a graph from a file and obtains the 
     * topological ordering of its verticies.
     * 
     * @param filename The name of the graph file.
     * @return Verticies in topological order.
     */
    public static ArrayList<Integer> topSortGenerator(String filename)
    {
        GraphStart graph;
        int gSize = 0;
        
        //build graph from file
        try
        {
            graph = new GraphStart(filename);
            gSize = graph.getNVerts();
        }
        catch (IOException ioe)
        {
            System.out.println("Error reading file: " + ioe);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        //init deliverable ArrayList
        ArrayList<Integer> order = new ArrayList(gSize);
        
        //count in-degrees
        int[] indegs = new int[gSize];
        for (int vert = 0; vert < gSize; vert++)
            indegs[vert] = 0;
        
        
        
        for (int i = 0; i < gSize; i++)
        {
            
        }
        
        //store all 0s
        Queue<Integer> zeros = new LinkedList<Integer>(gSize);
        
        /* Loop until no in-degree 0: */
        while (!starters.isEmpty())
        {
            //take next "start" vertex
            
            //dec each adjacent vert in-degree
            
            //store any resulting 0s
        }
        
        //if remaining unsorted vertices, fill with -1
    }
    
    /**
     * Compares the result of topSortGenerator against a crontrol.
     * 
     * @param target The known control list.
     * @param test The test list.
     * @param testNum The number of the test.
     */
    private void testResults(ArrayList<Integer> target, ArrayList<Integer> test, int testNum)
    {
        boolean matching = (target.size() == 5);
        
        //wrong size error
        if (!matching) System.out.println("Test " + testNum + " Error: array is size " 
            + test.size() + ", should be " + target.size);
        
        //mismatch error
        for (int j = 0; j < test.size(); j++)
        {
            Integer t = test.get(j);
            Integer targ = target.get(j);
            
            if (!targ.equals(t))
                matching = false;
        }
        
        if (matching)
            System.out.println("Test " + testNum + " Passes.");
        else
        {
            System.out.println("Test " + testNum + " ERROR!");
            
            System.out.print("Targ: ");
            for (Integer vTarg : target)
                System.out.print(vTarg + " ");
            System.out.println();
            
            System.out.print("Test: ");
            for (Integer vTest : test)
                System.out.print(vTest + " ");
            System.out.println();
        }
        
    }
    
    /**
     * Test driver for the TopSorter class.
     * 
     * @param args N/A.
     */
    pub
    {
        /* Test 1 */
        ArrayList<Integer> targ1 = new ArrayList<Integer>(5);
        for (int i = 1; i < 6; i++)
            targ1.add(new Integer(i));
        
        ArrayList<Integer> test1 = topSortGenerator("topsorttest1.txt");
        
        testResults(targ1, test1, 1);
    }
}
