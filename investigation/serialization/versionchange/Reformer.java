/**
 * A man who's taken to the bottle. But maybe
 * he'll change his ways one day.
 * 
 * @author Sean Reddell
 * @version 0.1
 */
public class Reformer implements java.io.Serializable
{
    /** A clear sign of his hard times. */
    private final int drinksTaken = 7;
    
    /**
     * The populace finds his drunken slurs obnoxious.
     */
    public void rant()
    {
        System.out.println("Ah dun unnerstan infimitee.");
    }
    
    /**
     * How's the man been doing these days?
     * 
     * @return The number of drinks he's had today.
     */
    public int getDrinks()
    {
        return drinksTaken;
    }
}
