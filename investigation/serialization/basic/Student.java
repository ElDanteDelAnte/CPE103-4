/**
 * A serializable Student with nothing more
 * than a name.
 * 
 * @author Sean Reddell
 * @version 4/19/16
 */
public class Student implements java.io.Serializable
{
    /** The Student's name. */
    String name;
    
    /**
     * Constructs a Student with a given name.
     * 
     * @param name The Student's name.
     */
    public Student(String n)
    {
        name = n;
    }
    
    /**
     * Obtain's the Student's name.
     * 
     * @return Student's name.
     */
    public String getName()
    {
        return name;
    }
}
