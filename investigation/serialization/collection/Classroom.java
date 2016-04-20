/**
 * A collection of students of a grade and their instructor.
 * Student must also be serializable.
 * 
 * @author Sean Reddell
 * @version 4/19/16
 */

import java.util.ArrayList;

public class Classroom implements java.io.Serializable
{
    /** Listing of Students */
    private ArrayList<Student> studentList;
    
    /** Grade level of the students */
    private int grade;
    
    /** Name of the instructor */
    private String teacher;
    
    /**
     * Default constructor, in case of dummy initialization.
     */
    public Classroom()
    {
        studentList = new ArrayList<Student>();
        grade = 0;
        teacher = "Dalbey";
    }
    
    /**
     * Constructor for a given student list, grade, and instructor.
     *
     * @param roster Student list.
     * @param level Grade level of the class.
     * @param instr Name of the class instructor
     */
    public Classroom(ArrayList<Student> roster, int level, String instr)
    {
        studentList = roster;
        grade = level;
        teacher = instr;
    }
    
    /**
     * Obtains the listing of Students in the Classroom.
     * 
     * @return List of Students.
     */
    public ArrayList<Student> getStudentList()
    {
        return studentList;
    }
    
    /**
     * Obtains the grade level of the class.
     * 
     * @return Class grade level.
     */
    public int getGrade()
    {
        return grade;
    }
    
    /**
     * Obtains the name of the class instructor.
     * 
     * @return Class instructor.
     */
    public String getTeacher()
    {
        return teacher;
    }
}
