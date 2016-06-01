
/**
 * Segregates the connected components of a graph.
 * 
 * Project 7.
 * 
 * @author Sean Reddell
 * @version 5/31/16
 */
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
        
        String formatted = "{ ";
        //insert vertex with space and comma as appropriate
        
        //append closing brace
        formatted = formatted.concat("}");
        return formatted;
    }
}
