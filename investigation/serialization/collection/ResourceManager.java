/**
 * Writes a Classroom of Students to a file
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
    private static final String STUDENTFILENAME = "studentList.data";
    
    /** Name of Classroom data destination file. */
    private static final String CLASSFILENAME = "classroom.data";
    
    /**
     * Writes a Classroom to file.
     * 
     * @param school List of students.
     */
    public static void saveClassroom(Classroom school)
    {
        try
        {
            //write to disk with FileOutputStream
            FileOutputStream f_out = new FileOutputStream(CLASSTFILENAME);
            
            //write Student object with ObjectOutputStream
            obj_out = new ObjectOutputStream(f_out);
            
            //write list of Students to disk, all at once
            obj_out.writeObject(school);
            
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
     * Reads a file of Classroom data.
     * 
     * @return Classroom read from file.
     */
    public static Classroom loadClassroom()
    {
        Classroom room = new Classroom();
        
        try
        {
            //read from disk using FileInputStream
            FileInputStream f_in = new FileInputStream(CLASSFILENAME);
            
            //Read Student object using ObjectInputStream
            ObjectInputStream obj_in = new ObjectInputStream(f_in);
            
            //read Students all at once
            Object readObj = obj_in.readObject();
            
            //cast to string of students
            if (readObj instanceof Classroom)
                room = (Classroom) readObj;
            
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
        return room;
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
        
        Classroom school = new Classroom(studentList, 10, "Keen");
        
        saveClassroom(school);
        
        Classroom keensClass = loadClassroom();
        
        ArrayList<Student> roster = keensClass.getStudentList();
        int grade = keensClass.getGrade();
        String teachName = keensClass.getTeacher();
        
        System.out.println("Teacher: " + teachName);
        System.out.println("Grade: " + grade);
        System.out.println("Students: ");
        
        for (Student kid : roster)
        {
            System.out.println(kid.getName());
        }
        
    }
}
