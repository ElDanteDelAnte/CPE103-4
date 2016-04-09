/**
 * A generic Queue data structure implemented via circular array.
 * 
 * Lab 2.
 * 
 * @author Sean Reddell
 * @version 4/9/16
 */

import java.lang.IllegalStateException;

public class MyQueue<T> //implements QueueADT<T>
{
    /* Fields */
    private final int DEFAULT_CAPACITY = 10;
    
    private int front, rear, size;
    
    private T[] queue;
    
    /*
     * Exception thrown for illegal operations on 
     * an empty collection.
     */
    /*
    public static class EmptyCollectionException extends RuntimeException
    {
        // Default RuntimeException contructor
        public EmptyCollectionException() { super(); }
        
        // Construct with error message
        public EmptyCollectionException(String message) { super(message); }
    }
    */
    
    
    /* Constructors */
    
    /**
     * Initializes an empty queue at default initial capacity.
     * (Default capacity: 10)
     */
    @SuppressWarnings("unchecked")
    public MyQueue()
    {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        
        front = 0;
        rear = -1;
        size = 0;
    }
    
    /**
     * Initializes an empty queue at a specified initial capacity.
     * 
     * @param initialCapacity Specified initial capacity.
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int initialCapacity)
    {
        queue = (T[]) new Object[initialCapacity];
        
        front = 0;
        rear = -1;
        size = 0;
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
        size++;
        if (size == queue.length) 
            expandCapacity();
    }
    
    /**
     * Removes and returns element at front of queue.
     * 
     * @return Reference to removed element.
     * @throws IllegalStateException if queue is empty.
     */
    public T dequeue() throws IllegalStateException
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException(
            "Queue empty, cannot dequeue.");
        }
        
        T temp = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return temp;
    }
    
    /**
     * Obtains the first element in the queue without removing it.
     * 
     * @return Reference to first element in queue.
     * @throws IllegalStateException if queue is empty.
     */
    public T first() throws IllegalStateException
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException(
            "Queue empty, no first item.");
        }
        return queue[front];
    }
    
    /**
     * Returns true if the queue is empty, false otherwise.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Returns the number of elements currently in the queue.
     * 
     * @return Number of elements in queue.
     */
    public int qsize()
    {
        return size;
    }
    
    /**
     * Transfers contents of queue to new array twice the size
     * of the previous.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity()
    {
        T[] newQ = (T[]) new Object[queue.length * 2];
        
        //transfer each element over to newQ
        for (int i = 0; i < size; i++)
        {
            newQ[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        
        //adjust front and rear
        rear = queue.length - 1;
        front = 0;
        
        queue = newQ;
    }
}
