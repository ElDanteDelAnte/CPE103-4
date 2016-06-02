
/**
 * Segregates the connected components of a graph.
 * 
 * Project 7: Connection Assignment
 * 
 * @author Sean Reddell
 * @version 5/31/16
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class ConnectCheck
{
    private Graph graph; //the graph to be inspected
    private int v;       //number of verticies in the graph

    /**
     * Constructor for objects of class ConnectCheck.
     * 
     * @param graph The graph to be inspected.
     */
    public ConnectCheck(Graph graph)
    {
        this.graph = graph;
        v = graph.getNVerticies();
    }

    /**
     * Divides the graph into its connected components.
     * 
     * @return String representations of each connected component.
     */
    public ArrayList<String> getComponents()
    {
        //trackes the visited verticies, each defaults to false
        boolean[] visited = new boolean[v + 1];

        ArrayList<String> components = new ArrayList<String>();

        Queue<Integer> searchOrder = new LinkedList<Integer>();

        //ready first vertex
        searchOrder.add(new Integer(1));
        visited[1] = true;

        //repeat until all verticies are visited
        boolean traversing = true;
        while (traversing)
        {
            //the verticies of the current connected component
            ArrayList<Integer> group = new ArrayList<Integer>();

            //loop until all verticies in current group have been visited
            while (!searchOrder.isEmpty())
            {
                //visit all verticies adjacent to current vertex and add them to current group

                Integer vertex = searchOrder.remove();           //get current vertex
                group.add(new Integer(vertex));                  //add current vertex to current group
                LinkedList<Integer> adj = graph.adjList(vertex); //get adjacency list

                for (Integer u : adj)
                {
                    //for each unvisited adjacent vertex...
                    if (!visited[u])
                    {
                        //group.add(new Integer(u));  //add to current group
                        searchOrder.add(new Integer(u));  //ready vertex to be searched
                        visited[u] = true;  //mark as visited
                    }
                }
            }

            //format the group and add string to deliverable
            components.add(formatComponent(group));

            //find next unvisited vertex
            int unv = 0;
            for (int i = 1; unv == 0 && i <= v; i++)
            {
                if (!visited[i])
                    unv = i;
            }

            //ready next remaining portion
            if (unv > 0)
            {    
                searchOrder.add(new Integer(unv));
                visited[unv] = true;
            }
            //if no portion remains, we have traversed entire graph
            else
                traversing = false;
        }

        //once we have traversed entire graph, return components
        return components;
    }

    /**
     * Formats the vertecies of a connected component to fit
     * the Project 7 requirements.
     * 
     * @param component The connected verticies.
     * @return Formatted String representation of component.
     */
    private String formatComponent(ArrayList<Integer> component)
    {
        //empty case
        if (component.isEmpty()) return "";

        //sort the verticies for easier reading
        Collections.sort(component);

        String formatted = "{ ";

        //insert vertex with space and comma as appropriate
        for (int i = 0; i < component.size(); i++)
        {
            formatted = formatted.concat(component.get(i).toString());

            if (i + 1 < component.size())
            {
                formatted = formatted.concat(", ");
            }
        }

        //append closing brace
        formatted = formatted.concat("}");
        return formatted;
    }
}
