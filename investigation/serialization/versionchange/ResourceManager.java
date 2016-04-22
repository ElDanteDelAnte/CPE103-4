/**
 * Writes a Reformer to file. When it's 
 * read back in, it might not act the same.
 * 
 * @author Sean Reddell
 * @version 0.2
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.lang.Exception;
import java.lang.RuntimeException;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class ResourceManager
{
    /** Name of Student data destination file. */
    private static final String FILENAME = "original.data";
    
    /**
     * Writes a Reformer to file.
     * 
     * @param reform Reformer to save.
     */
    public static void saveRef(Reformer reform)
    {
        ObjectOutputStream obj_out;
        try
        {
            //write to disk with FileOutputStream
            FileOutputStream f_out = new FileOutputStream(FILENAME);
            
            //write Student object with ObjectOutputStream
            obj_out = new ObjectOutputStream(f_out);
            
            //write list of Students to disk, all at once
            obj_out.writeObject(reform);
            
            //close output stream
            obj_out.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Cannot save to file. File not found.");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Something else went wrong while saving.");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Reads a file of Reformer data and returns it.
     * 
     * @return Reformer read from file.
     */
    public static Reformer loadRef()
    {
        Reformer changed = new Reformer();
        
        try
        {
            //read from disk using FileInputStream
            FileInputStream f_in = new FileInputStream(FILENAME);
            
            //Read Student object using ObjectInputStream
            ObjectInputStream obj_in = new ObjectInputStream(f_in);
            
            //read Students all at once
            Object readObj = obj_in.readObject();
            
            //cast to string of students
            if (readObj instanceof Reformer)
                changed = (Reformer) readObj;
            
            //close input stream
            obj_in.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Cannot read file, file not found.");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        catch (RuntimeException rte)
        {
            System.out.println("Problem during typecast.");
            System.out.println(rte.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Something else went wrong while loading.");
            System.out.println(e.getMessage());
        }
        return changed;
    }
    
    /**
     * Creates a Reformer and either saves it or 
     * loads it depending on the version.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        Reformer drunkard = new Reformer(7);
        
        saveRef(drunkard);
        
        //drunkard = loadRef();
        
        drunkard.rant();
        
        System.out.println("Drunkard has had " + drunkard.getDrinks() + 
            " drinks today.");
        
        
    }
}
