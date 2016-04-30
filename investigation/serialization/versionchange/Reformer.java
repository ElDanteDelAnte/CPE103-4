/**
 * A man who's taken to the bottle. But maybe
 * he'll change his ways one day.
 * 
 * @author Sean Reddell
 * @version 0.4.3
 */
public class Reformer implements java.io.Serializable
{
    /** A clear sign of his hard times. */
    private int drinksTaken;
    
    private int psalmsSpoken = 5;
    
    public int spoken() { return psalmsSpoken; }
    
    /**
     * Default constructor.
     */
    public Reformer()
    {
    }
    
    /**
     * Parameterized constructor
     * 
     * @param drinks Drinks taken today.
     */
    public Reformer(int drinks)
    {
        drinksTaken = drinks;
    }
    
    /**
     * The populace finds his new rants just as obnoxious.
     */
    public void rant()
    {
        //System.out.println("Ah dun unnerstand infimity");
        System.out.println("I was a hopeless fool until I found Jesus.");
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
