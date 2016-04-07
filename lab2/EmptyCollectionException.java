/**
 * Exception thrown when illegal operations are performed
 * on an empty collection.
 * Unchecked.
 * 
 * Lab 2.
 * 
 * @author Sean Reddell
 * @version 4/7/16
 */

public class EmptyCollectionException extends RuntimeException
{
    public EmptyCollectionException() { super(); }
    
    public EmptyCollectionException(String message) { super(message); }
}
