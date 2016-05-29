/* This class stores a string of characters in an ArrayList.*/
import java.io.*;
import java.util.*;

public class CharacterList {
    private static final int R = 31;

    private List<Character> list; // for actual storage of characters

    /* Constructors */

    public CharacterList() {
        list = new ArrayList<Character>();
    }

    /* This constructor makes a CharacterList out of a traditional Java string */
    public CharacterList(String str) {
        list = new ArrayList<Character>();
        boolean LastCharWhiteSpace = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                if (!LastCharWhiteSpace) list.add(' ');
                LastCharWhiteSpace = true;
            }
            else {
                list.add(str.charAt(i));
                LastCharWhiteSpace = false;
            }
        }
    }

    /* This constructor makes a CharacterList out of the contents of a text file */
    public CharacterList(File file) throws IOException {
        list = new ArrayList<Character>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(file)));
        int character;
        boolean LastCharWhiteSpace = false;
        while((character = reader.read()) != -1) {
            if (Character.isWhitespace(character)) {
                if (!LastCharWhiteSpace) list.add(' ');
                LastCharWhiteSpace = true;
            }
            else {
                list.add(new Character((char) character));
                LastCharWhiteSpace = false;
            }
        }
        if (list.get(list.size() - 1).charValue() == 32) list.remove(list.size() - 1);
        reader.close();
    }

    /* Member methods */
    /* This method returns the character at the given position in the Cha   racterList.
    It should look up the appropriate character in the list used for storage */  
    public Character getChar(int position) {
        return list.get(position);
    }

    /* This method returns the length of the string (i.e. the size of the list) */
    public int size() {
        return list.size();
    }

    @Override
    public int hashCode() {
        return (int) hashCodeLong();
    }
    
    /* Full size hash code */
    private long hashCodeLong()
    {
        long h = 0;
        for (int i = 0; i < size(); i++)
        {
            h = h * R + toInt(getChar(i));
        }
        return h;
    }

    public boolean checkIfSubstring(CharacterList searchstr, int method) throws IllegalArgumentException {
        if (method < 0 || method > 1) throw new IllegalArgumentException();

        int n = list.size(); // Length of the haystack string
        int m = searchstr.size(); // Length of the search string

        //brute force
        if (method == 0) {

            // We will use a variable called "start" to keep track of the
            // beginning position of the current portion of haystack
            // we are comparing.

            for (int start = 0; start < n - m + 1; start++) {
                if (compSub(start, searchstr)) return true;
            }
            return false; // If we get to this point, we've searched all substrings
            // of the haystack and haven't found a match, so return false.
        }
        //hashing
        else {

            // Compute the hash of the search string once.
            long targHash = searchstr.hashCode();
            
            //targHash = (targHash < 0) ? (-targHash) : targHash;

            // Compute the starting hash of the haystack (i.e. of its first m characters)
            long firstHash = 0;

            for (int j = 0; j < m; j++)
            {
                firstHash = firstHash * R + toInt(getChar(j));
            }
            
            // If the hashes match, compare the two strings character by character.

            if (firstHash == targHash)
            {
                // If they match char by char, return true otherwise continue further.
                if (compSub(0, searchstr))
                    return true;
            }
            
            //System.out.println("Target: " + targHash);
            //System.out.println("First: " + firstHash);
            
            // Using a loop similar to the first branch of the if statement...
            long rToPow = (long) Math.pow(R, m - 1);  //R^(m-1)
            long prevHash = firstHash;
            long mod = nextPrime((long) (2 * n + 1));
            long targMod = modulo(targHash, mod);
            
            //System.out.println("TargMod: " + targMod);
            //long mod = (long) Math.pow(R, n);
            
            //rolling hash
            for (int start = 1; start < n - m + 1; start++)
            {
                //System.out.print("Rolling");
                // ... advance the portion of the haystack currently being examined
                // by one character and recompute/update its hash.
                long rollHash = R * (prevHash - toInt(getChar(start - 1))
                * rToPow) + toInt(getChar(start + m - 1));
                
                //rollHash = (rollHash < 0) ? (-rollHash) : rollHash;
                
                //System.out.println(rollHash);
                
                //System.out.println(mod);
                // Then compare the hashes. 
                //if (modulo(rollHash, mod) == targMod)
                if (rollHash == targHash)
                {
                    System.out.println("Collision");
                    //If they match, compare the strings character by character.
                    if (compSub(start, searchstr))
                        // If they match char by char, return true otherwise continue further.
                        return true;
                }
                //otherwise, keep going.
                prevHash = rollHash;
            }

            // If after the loop finishes and no match has been found
            // return false because that substring doesn't exist
            // in the haystack.
            return false;
        }
    }

    /* This method prints the contents of the CharacterList. Use it for debugging. */
    public void print() {
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i));
        System.out.println();
    }

    /** Obtains the ASCII literal value of a Character */
    private static long toInt(Character c)
    {
        return (long) c.charValue();
    }

    /** Compares a substring to the searchstring */
    private boolean compSub(int start, CharacterList searchstr)
    {
        // If "searchstr" and the portion of haystack beginning
        // at "start" and continuing for m characters are identical
        // then return true.
        for (int i = 0; i < searchstr.size(); i++)
        {
            if (this.getChar(start + i).compareTo(searchstr.getChar(i)) != 0)
                return false;
        }
        //if passed through entire segment without a mismatch,
        //then the substring matches
        return true;
    }
    
    /** Mod function */
    private static long modulo(long val, long n)
    {
        long mod = val;
        
        //convert to positive
        while (mod < 0)
        {
            mod += n;
            //System.out.print("addlag ");
        }
        
        //remainder
        while (mod >= n)
        {
            mod -= n ;
            //System.out.print("sublag ");
        }        
        return mod;
    }
    
    /** Finds the next pime number */
    private static long nextPrime(long n)
    {
        if (n % 2 == 0) n++;
        while (isPrime(n)) n += 2;
        
        return n;
    }
    
    /** Determines if a number is prime */
    private static boolean isPrime(long n)
    {
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i < n; i += 2)
            {
                if (n % i == 0) return false;
            }
        return true;
    }
}
