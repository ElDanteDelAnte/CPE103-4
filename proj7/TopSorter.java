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
}
