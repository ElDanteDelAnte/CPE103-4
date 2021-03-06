import java.io.*;

public class CharListTester {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java CharListTester <haystack_file> <searchstr_file> <method>");
            System.exit(0);
        }
        
        CharacterList haystack, searchstr;
        int method;
        try {
            haystack = new CharacterList(new File(args[0]));
            searchstr = new CharacterList(new File(args[1]));
            method = Integer.parseInt(args[2]);
            
            long startTime = System.currentTimeMillis();
            boolean found = haystack.checkIfSubstring(searchstr, method);
            long stopTime = System.currentTimeMillis();
            
            System.out.println("N: " + haystack.size() 
                + " M: " + searchstr.size());
            System.out.println("Duration: " + (stopTime - startTime));
            
            if (found)
                System.out.println("true");
            else System.out.println("false");
        }
        catch (IllegalArgumentException e) {
            System.out.println("An illegal argument was passed in.");           
        }
        catch (IOException e) {
            System.out.println("An IOException occurred.");
        }
    }
}
