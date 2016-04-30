
/**
 * A Binary Expression tree.
 * 
 * @author Sean Reddell 
 * @version 4/30/16
 */
public class ExpressionTree
{
   
    

    /**
     * Creates a Binary Expression tree from a valid postfix expression.
     * 
     * @param postExpr Valid postfix expression.
     */
    public ExpressionTree(String postExpr)
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Checks if a String is a valid postfix expression.
     * 
     * @param expr The expression to be assessed.
     * @return True if the string is a valid postfix expression, false otherwise.
     */
    public static boolean postExpCheck(String expr)
    {
        // put your code here
        
    }
    
    /**
     * Checks if a postfix expression that has a difinitive value (all operands are digits).
     * 
     * @param expr The postfix expression to be assessed.
     * @return True if the string is a valid postfix expression with digits for all operands.
     */
    public static boolean postExpHasVal(String expr)
    {
        //
    }
    
    /**
     * Returns a postfix represenation of the expression in the tree.
     * 
     * @return Tree expression in postfix.
     */
    public String postFixExp()
    {
        //
    }
    
    /**
     * Retuns a prefix representation of the expression in the tree.
     * 
     * @return Tree expression in prefix.
     */
    public String preFixExp()
    {
        //
    }
    
    /**
     * Evaluates the expression represented by the tree.
     * Assumes all operands are digits and no division by 0.
     * 
     * @return The resulting value.
     */
    public Float expressionVal()
    {
        //
    }
    
    /**
     * Returns the expression in infix notation with parentheses around every subexpression.
     * 
     * @return Infix expression with excessive parentheses.
     */
    public String inFixExp1()
    {
        //
    }
    
    /**
     * Returns the expression in infix notation with minimal parentheses.
     * 
     * @return Infix expression with minimal parentheses.
     */
    public String inFixExp2()
    {
        //
    }
}
