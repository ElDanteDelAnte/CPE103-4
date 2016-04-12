/**
 * Moves train cars from the right track to the left
 * track with the fewest possible moves.
 * 
 * Project 2.
 * 
 * @author Sean Reddell
 * @version 4/10/16
 */

import java.util.ArrayList;

public class Railroad
{
    /**
     * Returns the sequence of moves that
     * will place cars on the left track
     * closest to the desired order.
     * 
     * @param aOutOrd The desired order.
     * @return String of the sequence and
     *         of each track.
     */
    public static ArrayList<String> rrSwitch(int[] aOutOrd)
    {
        //declare and init stacks and vars
        ArrayList<String> output = new ArrayList<String>(4);
        String moves = new String();
        
        MyStack stackL = new MyStack();
        MyStack stackM = new MyStack();
        MyStack stackR = new MyStack();
        
        for (int i = 6; i > 0; i--)
        {
            stackR.push(i);
        }
        
        //actual algorithm
        boolean remActions = true;
        int tarIndex = 0;
        
        while (remActions && tarIndex < 6)
        {
            int target = aOutOrd[tarIndex];
            
            //if target is still in right
            if (!stackR.empty() && stackR.top() <= target)
            {
                //take from right
                stackM.push(stackR.pop());
                
                //track move
                moves = moves.concat("R ");
                
                //immediately repeat loop
            }
            //if target found
            else if (target == stackM.top())
            {
                //put onto left
                stackL.push(stackM.pop());
                
                //track move
                moves = moves.concat("L ");
                
                //search for next target
                tarIndex++;
            }
            //target is unreachable
            else
            {
                remActions = false;
            }
        }
        
        //format strings for output
        moves = moves.trim();
        output.add(0, moves);
        
        MyStack temp = new MyStack();
        while (!stackL.empty())
        {
            temp.push(stackL.pop());
        }
        
        String left = new String();
        while (!temp.empty())
        {
            left = left.concat(temp.pop() + " ");
        }
        left = left.trim();
        output.add(1, left);
        
        String mid = new String();
        while (!stackM.empty())
        {
            mid = mid.concat(stackM.pop() + " ");
        }
        mid = mid.trim();
        output.add(2, mid);
        
        String right = new String();
        while (!stackR.empty())
        {
            right = right.concat(stackR.pop() + " ");
        }
        right = right.trim();
        output.add(3, right);
        
        return output;
    }
    
    /**
     * Test driver for the rrSwitch method.
     * 
     * @param args N/A
     */
    public static void main(String[] args)
    {
        int[] test1 = new int[6];
        test1[0] = 3;
        test1[1] = 2;
        test1[2] = 4;
        test1[3] = 1;
        test1[4] = 6;
        test1[5] = 5;
        
        int[] test2 = new int[6];
        test2[0] = 3;
        test2[1] = 1;
        test2[2] = 2;
        test2[3] = 4;
        test2[4] = 6;
        test2[5] = 5;
        
        /*
        int[] test3 = new int[6];
        test3[0] = 1;
        test3[1] = 2;
        test3[2] = 3;
        test3[3] = 4;
        test3[4] = 5;
        test3[5] = 6;
        
        int[] test4 = new int[6];
        test4[0] = 6;
        test4[1] = 5;
        test4[2] = 4;
        test4[3] = 3;
        test4[4] = 2;
        test4[5] = 1;
        */
        
        ArrayList<String> results1 = rrSwitch(test1);
        ArrayList<String> results2 = rrSwitch(test2);
        //ArrayList<String> results3 = rrSwitch(test3);
        //ArrayList<String> results4 = rrSwitch(test4);
        
        System.out.println("Test 1 results:");
        
        for (String res1 : results1)
        {
            System.out.println(res1);
        }
        
        System.out.println();
        System.out.println("Test 2 results:");
        
        for (String res2 : results2)
        {
            System.out.println(res2);
        }
        /*
        System.out.println();
        System.out.println("Test 3 results:");
        
        for (String res3 : results3)
        {
            System.out.println(res3);
        }
        
        System.out.println();
        System.out.println("Test 4 results:");
        
        for (String res4 : results4)
        {
            System.out.println(res4);
        }
        */
    }
}
