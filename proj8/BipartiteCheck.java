
/**
 * Checks whether a graph is Bipartite (BiColorable).
 * 
 * Project 7: Bipartite Check Assignment
 * 
 * @author Sean Reddell
 * @version 5/31/16
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteCheck
{
    private Graph graph; //graph to be checked.
    private int v;       //number of verticies in the graph

    /**
     * Constructor for objects of class BipartiteCheck.
     * 
     * @param graph The graph to be checked.
     */
    public BipartiteCheck(Graph graph)
    {
        this.graph = graph;
        v = graph.getNVerticies();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @return True if BiColorable, false otherwise.
     */
    public boolean getBicolorable()
    {
        //colors are -1 and 1, 0 is unvisited
        //init to 0 by default
        int[] colors = new int[v + 1];

        //tracks the order of verticies to visit (breadth-first search)
        Queue<Integer> searchOrder = new LinkedList<Integer>();

        //0, 1, or 2 verticies implies bicolorable
        if (v < 3) return true;

        //ready first vertex to search
        colors[1] = 1;
        searchOrder.add(new Integer(1));

        //search all portions of the graph
        boolean traversing = true;
        while (traversing)
        {
            while (!searchOrder.isEmpty())
            {
                //get adjacent verticies
                Integer vertex = searchOrder.remove();
                LinkedList<Integer> adj = graph.adjList(vertex);

                for (Integer u : adj)
                {
                    //if color of adjacent vertex matches matches current color,
                    //graph is not bicolorable
                    if (colors[vertex] == colors[u]) return false;

                    if (colors[u] == 0)
                    {
                        //color unvisited verticies reverse of current color
                        colors[u] = 0 - colors[vertex];

                        //and ready them to be visited
                        searchOrder.add(new Integer(u));
                    }

                    //else, colors are already opposite, do nothing

                }
            }

            
            //find next disconnected portion of the graph
            int unv = 0;
            for (int i = 1; unv == 0 && i <= v; i++)
            {
                if (colors[i] == 0)
                    unv = i;
            }

            //ready next remaining portion
            if (unv > 0) 
            {    
                searchOrder.add(new Integer(unv));
                colors[unv] = 1;
            }
            //if no portion remains, we have traversed entire graph
            else
                traversing = false;
        }

        //once we have traversed entire graph without conflicting colors,
        //we have determined graph is bicolorable
        return true;
    }
}
