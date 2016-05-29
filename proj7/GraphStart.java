/**
 * An adjacency list representation of a graph, with the verticies represented by integers.
 * 
 * Projects 7 and 8.
 * 
 * @author Sean Reddell
 * @version 5/28/16
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;

public class GraphStart
{
    private int nverticies;
    private boolean directed;
    private LinkedList<Integer>[] edges;

    /**
     * Constructs a graph from a given graph file.
     * 
     * @param filename Name of the file.
     * @throws FileNotFoundException if error in reading file.
     */
    public GraphStart(String filename) throws FileNotFoundException
    {
        readfile_graph(filename);
        /*
        for (int i = 1; i <= nverticies; i++)
        Collections.sort(edges[i]);
         */
    }

    /**
    * Reads a graph file and constructs adjacency list.
    * 
    * @param filename Name of the file
    * @throws FileNotFoundException if error in reading file.
    */
    @SuppressWarnings("unchecked")
    private void readfile_graph(String filename) throws FileNotFoundException
    {
        FileInputStream in = new FileInputStream(new File(filename));
        int x, y;
        Scanner sc = new Scanner(in);
        directed = (sc.nextInt() == 1); //1 directed, else undirected
        nverticies = sc.nextInt();

        //init adj lists
        edges = new LinkedList[nverticies + 1];

        for (int i = 1; i <= nverticies; i++)
            edges[i] = new LinkedList<Integer>();

        int m = sc.nextInt();
        for (int i = 1; i <=m; i++)
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
        edges[x].add(new Integer(y));

        if (!directed)
            edges[y].add(new Integer(x));
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
    public int getNVerts()
    {
        return nverticies;
    }

    /**
     * Obtains the adjacency list of a vertex on the graph.
     * 
     * @param vertex The specified vertex.
     * @return List of verticies adjacent to specified.
     */
    public LinkedList<Integer> getAdjList(int vertex)
    {
        return edges[vertex];
    }

}