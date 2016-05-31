/**
 * Produces a topological ordering of a Directed Acyclical Graph.
 * Target runtime: O(|E| + |V|)
 * 
 * Project 7: Topological Sort
 * 
 * @author Sean Reddell
 * @version 5/29/16
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;

public class TopSorter
{
    private class GraphStart
    {
        public int nverticies;
        private boolean directed;
        public LinkedList<Integer>[] edges;

        /**
        * Reads a graph file and constructs adjacency list.
        * 
        * @param filename Name of the file
        * @throws FileNotFoundException if error in reading file.
        */
        @SuppressWarnings("unchecked")
        private void readfile_graph(String filename) throws FileNotFoundException
        {
            //System.out.println("Started reading file.");
            FileInputStream in = new FileInputStream(new File(filename));
            //System.out.println("Read File");
            int x, y;
            Scanner sc = new Scanner(in);
            directed = (sc.nextInt() == 1); //1 directed, else undirected
            this.nverticies = sc.nextInt();

            //init adj lists
            this.edges = new LinkedList[nverticies + 1];

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
    }
    
    /**
     * Builds a graph from a file and obtains the 
     * topological ordering of its verticies.
     * Assumes graph is connected.
     * 
     * @param filename The name of the graph file.
     * @return Verticies in topological order.
     */
    public static ArrayList<Integer> topSortGenerator(String filename)
    {
        GraphStart graph = new TopSorter().new GraphStart();
        int gSize = 0;

        //build graph from file
        try
        {
            graph.readfile_graph(filename);
            gSize = graph.nverticies;
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Error reading file: " + fnfe);
        }
        catch (Exception e)
        {
            System.out.println("Some other problem " + e);
        }

        //init deliverable ArrayList
        ArrayList<Integer> order = new ArrayList<Integer>(gSize);

        int[] indegs = new int[gSize + 1];
        //initialized to 0?
        for (int i = 0; i <= gSize; i++)
            indegs[i] = 0;

        //count in-degrees
        for (int i = 1; i <= gSize; i++)
        {
            LinkedList<Integer> adjList = graph.edges[i];

            for (Integer terminal : adjList)
            {
                indegs[terminal]++;
            }
        }

        //store all 0s
        Queue<Integer> starters = new LinkedList<Integer>();

        for (int i = 1; i <= gSize; i++)
        {
            if (indegs[i] == 0)
                starters.add(new Integer(i));
        }
        
        //if not even partially sortable, return empty
        if (starters.isEmpty())
            return order;

        /* Loop until no in-degree 0: */
        while (!starters.isEmpty())
        {
            //take next "start" vertex
            Integer vert = starters.remove();

            //"remove" vertex
            indegs[vert]--;
            order.add(vert);

            //dec each adjacent vert in-degree
            LinkedList<Integer> vertAdj = graph.edges[vert];

            for (Integer terminal : vertAdj)
            {
                //store any resulting 0s
                if (--indegs[terminal] == 0)
                    starters.add(terminal);
            }
        }

        //if remaining unsorted vertices, fill with -1
        while (order.size() < gSize)
            order.add(new Integer(-1));

        return order;
    }

    /**
     * Compares the result of topSortGenerator against a crontrol.
     * 
     * @param target The known control list.
     * @param test The test list.
     * @param testNum The number of the test.
     */
    private static void testResults(ArrayList<Integer> target, ArrayList<Integer> test, int testNum)
    {
        boolean matching = (target.size() == test.size());

        //wrong size error
        if (!matching) 
            System.out.println("Test " + testNum + " Error: array is size " 
                + test.size() + ", should be " + target.size());

        //mismatch error
        for (int j = 0; matching && (j < test.size()); j++)
        {
            Integer t = test.get(j);
            Integer targ = target.get(j);

            if (!targ.equals(t))
                matching = false;
        }

        if (matching)
            System.out.println("Test " + testNum + " Passes.");
        else

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

    /**
     * Test driver for the TopSorter class.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        /* Test Graph
        try
        {
        GraphStart testGraph = new GraphStart("topsorttest1.txt");
        testGraph.print_graph();
        }
        catch (Exception e)
        {
        System.out.println(e);
        }
         */
        /* Test 1 */
        ArrayList<Integer> targ1 = new ArrayList<Integer>(5);
        for (int i = 1; i < 6; i++)
            targ1.add(new Integer(i));

        ArrayList<Integer> test1 = topSortGenerator("topsorttest1.txt");

        testResults(targ1, test1, 1);

        /* Test 2 */
        ArrayList<Integer> targ2 = new ArrayList<Integer>(8);
        for (int i = 1; i < 6; i++)
            targ2.add(new Integer(i));

        for (int j = 0; j < 3; j++)
            targ2.add(new Integer(-1));

        ArrayList<Integer> test2 = topSortGenerator("topsorttest2.txt");

        testResults(targ2, test2, 2);
    }
}
