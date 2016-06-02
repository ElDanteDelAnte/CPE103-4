
/**
 * Adjacency List representation of a graph of integer verticies.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;

public class Graph
{
    private int nverticies;
    private int nedges;
    private boolean directed;
    private LinkedList<Integer>[] edges;

    /**
    * Constructs a from a graph file and constructs adjacency list.
    * 
    * @param filename Name of the file
    * @throws FileNotFoundException if error in reading file.
    */
    @SuppressWarnings("unchecked")
    public Graph(String filename) throws FileNotFoundException
    {
        //System.out.println("Started reading file.");
        FileInputStream in = new FileInputStream(new File(filename));
        //System.out.println("Read File");
        int x, y;
        Scanner sc = new Scanner(in);
        directed = (sc.nextInt() == 1); //1 directed, else undirected
        nverticies = sc.nextInt();

        //init adj lists
        edges = new LinkedList[nverticies + 1];

        for (int i = 1; i <= nverticies; i++)
            edges[i] = new LinkedList<Integer>();

        //System.out.println("Post-list init");

        int m = sc.nextInt();
        for (int i = 1; i <= m; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();
            insert_edge(x, y);
        }
    }

    /**
     * Inserts an edge into the graph.
     * Applies to both directed and undirected graphs.
     * 
     * @param x Initial vertex (if directed).
     * @param y Terminal vertex (if directed).
     */
    public void insert_edge(int x, int y)
    {
        Integer edge = new Integer(y);
        if (!edges[x].contains(edge))
        {
            edges[x].add(edge);

            if (!directed)
                edges[y].add(new Integer(x));
            nedges++;
        }
    }

    /**
     * Removes an edge from the graph.
     * Applies to both directed and undirected graphs.
     * 
     * @param x Initial vertex (if directed).
     * @param y Terminal vertex (if directed).
     */
    public void remove_edge(int x, int y)
    {
        edges[x].remove(new Integer(y));

        if (!directed)
            edges[y].remove(new Integer(x));
        nedges--;
    }

    /**
     * Prints out the graph's adjacency lists.
     */
    public void print_graph()
    {
        for (int i = 1; i <= nverticies; i++)
        {
            System.out.print(i + ": ");

            LinkedList<Integer> adj = edges[i];
            for (Integer term : adj)
            {
                System.out.print(term + " ");
            }
            System.out.println();
        }
    }

    /**
     * Obtains the number of verticies in the graph.
     * 
     * @return Number of verticies.
     */
    public int getNVerticies() { return nverticies; }

    /**
     * Obtains the nubmer of edges in the graph.
     * 
     * @return Number of edges.
     */
    public int getNEdges() { return nedges; }

    /**
     * Objtains the list of verticies adjacent to a given vertex.
     * 
     * @param vertex The specified vertex.
     * @return List of adjacent verticies.
     */
    public LinkedList<Integer> adjList(int vertex) { return edges[vertex]; }
}
