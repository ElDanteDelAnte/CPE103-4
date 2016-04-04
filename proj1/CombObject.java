
/**
 * Class for obtaining permutations and subsets of strings.
 * Methods are static and recursive.
 * 
 * @author Sean Reddell
 * @version 4/3/16
 */

import java.util.ArrayList;

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

}

