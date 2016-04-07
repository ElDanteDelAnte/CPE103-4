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
    
    /**
     * Exception thrown for illegal operations on 
     * an empty collection.
     */
    public static class EmptyCollectionException extends RuntimeException
    {
        /* Default RuntimeException contructor */
        public EmptyCollectionException() { super(); }
        
        /* Construct with error message */
        public EmptyCollectionException(String message) { super(message); }
    }
    
    
    /* Constructors */
    /**
     * Initializes an empty queue at default initial capacity.
     * (Default capacity: 10)
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue()
    {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        
        front = 0;
        rear = -1;
        count = 0;
    }
    
    /**
     * Initializes an empty queue at a specified initial capacity.
     * 
     * @param initialCapacity Specified initial capacity.
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity)
    {
        queue = (T[]) new Object[initialCapacity];
        
        front = 0;
        rear = -1;
        count = 0;
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
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        count++;
        if (count == queue.length) expandCapacity();
    }
    
    /**
     * Removes and returns element at front of queue.
     * 
     * @return Reference to removed element.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty()) throw new EmptyCollectionException(
            "Queue empty, cannot dequeue.");
        
        T temp = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return temp;
    }
    
    /**
     * Obtains the first element in the queue without removing it.
     * 
     * @return Reference to first element in queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty()) throw new EmptyCollectionException(
            "Queue empty, no first item.");
        return queue[front];
    }
    
    /**
     * Returns true if the queue is empty, false otherwise.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return count == 0;
    }
    
    /**
     * Returns the number of elements currently in the queue.
     * 
     * @return Number of elements in queue.
     */
    public int size()
    {
        return count;
    }
    
    /**
     * Transfers contents of queue to new array twice the size
     * of the previous.
     * 
     * (Should this one really be public?)
     */
    @SuppressWarnings("unchecked")
    public void expandCapacity()
    {
        T[] newQ = (T[]) new Object[queue.length * 2];
        
        //transfer each element over to newQ
        for (int i = 0; i < count; i++)
        
        //adjust front and rear
        rear = queue.length;
        front = 0;
        
        queue = newQ;
    }
}
