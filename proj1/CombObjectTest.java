

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class CombObjectTest.
 *
 * @author  Sean Reddell
 * @version 4/3/16
 */
public class CombObjectTest
{

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        System.out.println();
        System.out.println();
    }
    
    /**
     * Tests the getLexPerm() method.
     */
    @Test
    public void testPerm()
    {
        System.out.println("Permutations: ");
        
        ArrayList<String> testList = CombObject.getLexPerm("abc");
        
        for (String perm : testList)
        {
            System.out.println(perm);
        }
        
        //assertTrue(testList.size() == 6, "Perm list wrong size");
        assertEquals("Perm list wrong size", 6, testList.size());
        
        assertEquals("abc", testList.get(0));
        assertEquals("acb", testList.get(1));
        assertEquals("bac", testList.get(2));
        assertEquals("bca", testList.get(3));
        assertEquals("cab", testList.get(4));
        assertEquals("cba", testList.get(5));
    }
    
    /**
     * Tests the getSubsets() method.
     */
    @Test
    public void testSets()
    {
        System.out.println("Sets: ");
        
        ArrayList<String> testList = CombObject.getSubsets("abc");
        
        for (String subs : testList)
        {
            System.out.println(subs);
        }
        
        assertEquals("Set list wrong size.", 8, testList.size());
        
        assertEquals("Set 0 not null.", testList.get(0), "");
        assertEquals("c", testList.get(1));
        assertEquals("b", testList.get(2));
        assertEquals("bc", testList.get(3));
        assertEquals("a", testList.get(4));
        assertEquals("ac", testList.get(5));
        assertEquals("ab", testList.get(6));
        assertEquals("Last set not full.", "abc", testList.get(7));
    }
}
