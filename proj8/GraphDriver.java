
/**
 * Test driver for the ConnectCheck and BipartiteCheck classes.
 * 
 * Project 7.
 * 
 * @author Sean Reddell
 * @version 5/31/16
 */

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class GraphDriver
{
    /**
     * Builds a graph from an input file and prints the results of the checks.
     * 
     * @param args Command-line arguments. [0] contains the filename.
     */
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Please specify a filename");
        }
        else
        {
            String filename = args[0];
            
            /* Possibly prepare directory name */
            /* //If directory change is required
            String directory = System.getProperty("user.dir"); // current working directory
            filename = directory + "\\" + filename;
            */
            
            /* Build Graph */
            Graph graph = null;
            
            try
            {
                graph = new Graph(filename);
            }
            catch (FileNotFoundException fnfe)
            {
                System.out.println("Error: file not found. " + fnfe);
            }
            catch (Exception e)
            {
                System.out.println("Something else went wrong. " + e);
            }
            
            int v = graph.getNVerticies();
            int e = graph.getNEdges();
            
            /* Test Connectivity */
            ConnectCheck conn = new ConnectCheck(graph);
            ArrayList<String> components = conn.getComponents();
            
            /* Test Bipartite */
            BipartiteCheck bpt = new BipartiteCheck(graph);
            boolean bc = bpt.getBicolorable();
            
            /* Print Results */
            System.out.print("Graph has (" + v + " verticies, " + e + " edges) and is ");
            if (!bc) System.out.print("NOT ");
            System.out.println("BiColorable.");
            
            System.out.print("It has " + components.size() + " connected component");
            System.out.println((components.size() > 1) ? "s:" : ":");
            
            for (int i = 0; i < components.size(); i++)
            {
                System.out.print(components.get(i));
                System.out.println((i + 1 == components.size()) ? "" : ";");
            }
        }
    }
}
