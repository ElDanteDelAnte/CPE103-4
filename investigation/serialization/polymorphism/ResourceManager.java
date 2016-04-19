/**
 * Writes a series of Students to a file
 * and reads them back in.
 * 
 * @author Sean Reddell
 * @version 4/19/16
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
    private static final String FILENAME = "studentList.data";
    
    /**
     * Writes a list of Students to file.
     * 
     * @param students List of students.
     */
    public static void saveStudents(ArrayList<Student> studentList)
    {
        ObjectOutputStream obj_out;
        try
        {
            //write to disk with FileOutputStream
            FileOutputStream f_out = new FileOutputStream(FILENAME);
            
            //write Student object with ObjectOutputStream
            obj_out = new ObjectOutputStream(f_out);
            
            //write list of Students to disk, all at once
            obj_out.writeObject(studentList);
            
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
     * Reads a file of Student data and retuns
     * them as a list.
     * 
     * @return Students read from file.
     */
    public static ArrayList<Student> loadStudents()
    {
        ArrayList<Student> roster = new ArrayList<Student>();
        
        try
        {
            //read from disk using FileInputStream
            FileInputStream f_in = new FileInputStream(FILENAME);
            
            //Read Student object using ObjectInputStream
            ObjectInputStream obj_in = new ObjectInputStream(f_in);
            
            //read Students all at once
            Object readObj = obj_in.readObject();
            
            //cast to string of students
            if (readObj instanceof ArrayList)
                roster = (ArrayList<Student>) readObj;
            
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
        return roster;
    }
    
    /**
     * Creates an ArrayList of Sudents (serializable),
     * writes them to file "studentList.data," reads the
     * file, then prints out the students' names.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("John"));
        studentList.add(new Student("Rose"));
        studentList.add(new Student("Dave"));
        studentList.add(new Student("Jade"));
        studentList.add(new Student("Jake"));
        studentList.add(new Student("Roxy"));
        studentList.add(new Student("Dirk"));
        
        saveStudents(studentList);
        
        ArrayList<Student> roster = loadStudents();
        
        for (Student kid : roster)
        {
            System.out.println(kid.getName());
        }
        
    }
}
