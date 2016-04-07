/**
 * A generic Queue data structure implemented via circular array.
 * Implements QueueADT<T>, Presumably professor's interface.
 * 
 * Lab 2.
 * 
 * @author Sean Reddell
 * @version 4/7/16
 */

public class CircularArrayQueue<T> //implements QueueADT<T>
{
    /* Fields */
    private final int DEFAULT_CAPACITY = 10;
    
    private int front, rear, count;
    
    private T[] queue;
    
    /* If EmptyCollectionException is defined here*/
    /**
     * Exception thrown for illegal operations on empty queue.
     */
    /*
    public static class EmptyCollectionException extends RuntimeException
    {
        public EmptyCollectionException() { super("The queue is empty"); }
        
        public EmptyCollectionException(String message) { super(message); }
    }
    */
    
    /* Constructors */
    /**
     * Default constructor.
     * Initializes an empty queue at default initial capacity.
     */
    public CircularArrayQueue()
    {
    }
    
    /**
     * Initializes an empty queue at a specified initial capacity.
     * 
     * @param initialCapacity Specified initial capacity.
     */
    public CircularArrayQueue(int initialCapacity)
    {
    }
    
    /* Methods */
    
    /**
     * Adds specified element to rear of queue, expanding capacity
     * of the queue if necessary.
     * 
     * @param element The element to be added.
     */
    public void enqueue(T element)
    {
    }
    
    /**
     * Removes and returns element at front of queue.
     * 
     * @return Reference to removed element.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T dequeue() throws EmptyCollectionException
    {
        return queue[0];
    }
    
    /**
     * Obtains the first element in the queue without removing it.
     * 
     * @return Reference to first element in queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T first() throws EmptyCollectionException
    {
        return queue[0];
    }
    
    /**
     * Returns true if the queue is empty, false otherwise.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return false;
    }
    
    /**
     * Returns the number of elements currently in the queue.
     * 
     * @return Number of elements in queue.
     */
    public int size()
    {
        return -1;
    }
    
    /**
     * Transfers contents of queue to new array twice the size
     * of the previous.
     * 
     * (Should this one really be public?)
     */
    public void expandCapacity()
    {
    }
}
