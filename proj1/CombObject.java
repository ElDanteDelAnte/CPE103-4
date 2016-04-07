
/**
 * Class for obtaining permutations and subsets of strings.
 * Methods are static and recursive.
 * 
 * @author Sean Reddell
 * @version 4/4/16
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CombObject
{
    /**
     * Obtains permutations of a string in lexicographic order.
     * Recursive implementation.
     * 
     * @param str String to be permuted (assumed lower case and alphabetical).
     * @return Lexicographic list of permutations.
     */
    public static ArrayList<String> getLexPerm(String str)
    {
        ArrayList<String> permut = new ArrayList<String>();
        
        //empty case
        if (str.isEmpty()) 
        {
            //System.out.println("Empty Case.");
            permut.add("");
            return permut;
        }

        //for each letter
        for (int i = 0; i < str.length(); i++)
        {
            char[] letter = new char[1];  
            letter[0] = str.charAt(i);                //select letter
            String letterWrap = new String(letter);   //convert to string
            
            //System.out.println("Possition: " + i);

            //remove the letter
            String substr = str.replace(letterWrap, "");
            //System.out.println("recurring: " + substr);

            //obtain permutes of resulting substring
            ArrayList<String> subperms = getLexPerm(substr);
            
            //System.out.println("Exiting recurrsion");

            //for each permutation of the substring
            for (String sub: subperms)
            {
                //add curr letter to front of each subpermutation
                String newperm = letterWrap.concat(sub);
                
                //System.out.println(newperm);
                
                //add to list
                permut.add(newperm);
            }

        }

        return permut;
    }

    /**
     * Obtains set of all subsets of a string.
     * Recursive implementation.
     * 
     * @param str String to be broken into subsets.
     * @return List of 2^N subsets of a string of N characters.
     */
    public static ArrayList<String> getSubsets(String str)
    {
        ArrayList<String> set = new ArrayList<String>();

        //empty case
        if (str.isEmpty())
        {
            set.add("");  //null set
            return set;
        }

        char[] letter = new char[1];  
        letter[0] = str.charAt(str.length() - 1); //select letter
        String letterWrap = new String(letter);   //convert to string

        //remove last character (x)
        String substr = str.replace(letterWrap, "");

        //obtain all subsets of substring
        ArrayList<String> subs = getSubsets(substr);

        //for each returned subset
        for (String subset : subs)
        {
            //add curr subset to set
            set.add(subset);
            
            
            //add curr subsetUx to set
            set.add(subset.concat(letterWrap));
        }

        return set;
    }
    
    /*
     * Obtains set of all subsets of a string.
     * Recursive implementation.
     * 
     * @param str String to be broken into subsets.
     * @return Formatted list of 2^N subsets.
     */
    /*
    public static ArrayList<String> getSubsets(String str)
    {
        //obtain raw list of subsets
        ArrayList<String> rawSets = getSubList(str);
        ArrayList<String> formSets = new ArrayList<String>();
        
        //format subset strings
        for (String subset : rawSets)
        {
            formSets.add(setFormat(subset));
        }
        
        //return formatted list
        return formSets;
    }*/
    
    /**
     * Formats string to proper subset format.
     * 
     * @param str The list to be formatted.
     * @return Formatted subset string.
     */
    private static String setFormat(String str)
    {
        //begin with opening brace
        String formSet = "{";
        
        //format surrounding each letter
        char[] formChars = new char[2];
        formChars[0] = ' ';
        //formChars[2] = ',';
        
        //add each letter to setForm
        for (int i = 0; i < str.length(); i++)
        {
            formChars[1] = str.charAt(i);
            String formSeg = new String(formChars);
            formSet = formSet.concat(formSeg);
        }
        
        //append closing brace
        char[] closeChars = new char[2];
        closeChars[0] = ' ';
        closeChars[1] = '}';
        String close = new String(closeChars);
        
        formSet = formSet.concat(close);
        
        return formSet;
    }
    
    /**
     * Main driver for the CombObject class demo.
     * 
     * @param args N/A
     */
    public static void main(String[] args)
    {
        ArrayList<String> permutes = new ArrayList<String>();
        ArrayList<String> subSets = new ArrayList<String>();
        
        //obtain input
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter string:");
        
        if (input.hasNext())
        {
            Scanner combReader = new Scanner(input.nextLine());
            String comb = combReader.next();
            
            permutes = getLexPerm(comb);
            subSets = getSubsets(comb);
        }
        
        /* Permutations*/
        System.out.println("Permutations:");
        
        for (String perm : permutes)
        {
            System.out.println(perm);
        }
        
        //Blank space to separate
        System.out.println();
        System.out.println();
        
        /* Subsets */
        System.out.println("Subsets:");
        
        
        //if getSubsets() returns raw
        for (int i = 1; i <= subSets.size(); i++)
        {
            String raw = subSets.get(i - 1);
            String braced = setFormat(raw);
            String formed = new String(i + ": " + braced);
            System.out.println(formed);
        }
        
        /*
        //if getSubsets() returns formatted
        for (String formed : subSets)
        {
            System.out.prinln(formed);
        }
        */
    }
}
