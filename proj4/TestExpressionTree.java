

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test driver for the ExpressionTree class.
 *
 * Project 4.
 *
 * @author  Sean Reddell
 * @version 4/30/16
 */
public class TestExpressionTree
{
    /**
     * Tests the static postfix expression methods.
     */
    @Test
    public void testPostCheck()
    {
        String truePostFix = "3152++*4-";
        String varPostFix = "3a5b++*c-";
        String single = "0";
        String wrongPostFix1 = "2a";
        String wrongPostFix2 = "2+2";
        String caps = "2A+";
        
        assertTrue("Did not recognize proper postfix", ExpressionTree.postExpCheck(truePostFix));
        assertTrue("Did not recognize proper postfix", ExpressionTree.postExpCheck(varPostFix));
        assertTrue("Did not recognize value", ExpressionTree.postExpHasVal(truePostFix));
        assertFalse("Falsely recognized letters as values", ExpressionTree.postExpHasVal(varPostFix));
        assertTrue("Did not recognize single value as postfix", ExpressionTree.postExpCheck(single));
        assertFalse("Did not recognize missing operator", ExpressionTree.postExpCheck(wrongPostFix1));
        assertFalse("Did not recognize operater was missing operand", ExpressionTree.postExpCheck(wrongPostFix2));
        assertFalse("Did not recognize capital leter as invalid", ExpressionTree.postExpCheck(caps));
    }
    
    /**
     * Checks the outputs for the prefix and postfix notation methods.
     */
    @Test
    public void testNotation()
    {
        String targPost = "3 a 5 c + + * 4 -";
        String targPre = "- * 3 + a + 5 c 4";
        ExpressionTree notation = new ExpressionTree("3a5c++*4-");
        
        assertEquals("Incorrect postfix output", targPost, notation.postFixExp());
        assertEquals("Incorrect prefix output", targPre, notation.preFixExp());
    }
    
    /**
     * Tests the evaluation method.
     */
    @Test
    public void testVal()
    {
        Float targ1 = new Float(6.0f);
        Float targ2 = new Float(-1.5f);
        ExpressionTree testVal1 = new ExpressionTree("3152++*4/");
        ExpressionTree testVal2 = new ExpressionTree("1212/+-");
        
        assertEquals(targ1, testVal1.expressionVal());
        assertEquals(targ2, testVal2.expressionVal());
    }
    
    /**
     * Tests that inFixExp() methods insert parentheses where appropriate.
     */
    @Test
    public void testInFix()
    {
        String target1 = "( 3 * ( a + ( 5 + c ) ) ) - 4";
        String target2 = "3 * ( a + 5 + c ) - 4";
        String target3 = "3 - ( a + 1 / 2 )";
        ExpressionTree inFix1 = new ExpressionTree("3a5c++*4-");
        ExpressionTree inFix2 = new ExpressionTree("3a12/+-");
        
        assertEquals("Error in inFix1", target1, inFix1.inFixExp1());
        assertEquals("Error in inFix2", target2, inFix1.inFixExp2());
    }
    
    /**
     * Main test driver for the TestExpressionTree test class.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        TestExpressionTree test = new TestExpressionTree();
        
        test.testPostCheck();
        System.out.println("postFixCheck() and postFixHasVal() passed.");
        
        test.testNotation();
        System.out.println("preFixExp() and postFixExp() passed.");
        
        test.testVal();
        System.out.println("expressionVal() passed.");
        
        test.testInFix();
        System.out.println("inFixExp1() and inFixExp2() passed.");
        
        System.out.println("All tests passed.");
    }
}
