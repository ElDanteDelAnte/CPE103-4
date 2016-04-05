/**
 * A Linked List stack of integers.
 * Driver tests each method.
 * Exceptions not explicitly thrown.
 * Full() method not implemented.
 * 
 * @author Sean Reddell
 * @version 4/5/16
 */
 
public class MyStack
{
    /**
     * The linked nodes of the list,
     * containing the elements.
     */
    private class Node
    {
        private int element;
        private Node next;
        
        /**
         * Constructor for the node.
         * 
         * @param e Node's element.
         * @param n Next node on stack.
         */
        public Node(int e, Node n)
        {
            element = e;
            next = n;
        }
    }
    
    //top element of the stack
    //initialized to null (empty stack)
    private Node top = null;
    
    /**
     * Puts an integer onto the stack.
     * 
     * @param e Integer to be pushed.
     */
    public void push(int e)
    {
        Node item = new Node(e, top);
        top = item;
    }
    
    /**
     * Pulls an integer off of the stack.
     * 
     * @returns The integer removed.
     * 
     */
    public int pop()
    {
        //if (empty()) throw new NullPointerException("Stack is empty.");
        
        //empty case: let java throw
        
        Node temp = top;
        top = top.next;
        return temp.element;
    }
    
    /**
     * Peeks at the top of the stack.
     * Does not remove element.
     * 
     * @returns Topmost integer.
     * 
     */
    public int top()
    {
        //if (empty()) throw new NullPointerException("Stack is empty.");
        
        //empty case: let java throw
        
        return top.element;
    }
    
    /**
     * Tests whether the stack is empty.
     * 
     * @returns The stack is empty.
     */
    public boolean empty()
    {
        return top == null;
    }
    
    /**
     * Tests whether the stack has items.
     * 
     * @returns The stack has items.
     *
    public boolean full()
    {
        return 
    }*/
    
    /* IMPLICIT DEFAULT CONSTRUCTOR */
    
    /**
     * Tests each method.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        MyStack stack = new MyStack();
        
        //1 2 3 4 5
        for (int i = 1; i < 6; i++)
        {
            stack.push(i);
            System.out.println("Pushed " + i);
        }
        
        //top should be 5
        System.out.println("Top: " + stack.top());
        
        //5 4 3 2 1
        while (!stack.empty())
        {
            System.out.println("Popped " + stack.pop());
        }
        
        if (stack.empty()) System.out.println("Stack is empty.");
        else
            System.out.println("Error! Stack is not empty!");
    }
    
    
    
}
