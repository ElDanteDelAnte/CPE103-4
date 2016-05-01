
/**
 * A Binary Expression tree.
 * 
 * Project 4.
 * 
 * @author Sean Reddell 
 * @version 4/30/16
 */

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class ExpressionTree
{
    /** Set of valid operators. */
    private static final Set<String> OPERATORS = 
        new HashSet<String>(Arrays.asList("+", "-", "/", "*"));

    /**
     * Determines if a symbol is a valid operator.
     * 
     * (Given by instructor.)
     * 
     * @param s Symbol to be assessed.
     * @return True if symbol is an operator, false otherwise.
     */
    private static boolean isOperator(String s)
    {
        return OPERATORS.contains(s);
    }

    /**
     * This function will detect if the current string given is a valid operand.
     * (Works for single characters,
     * multiple characters, integers, and floats).
     * 
     * (Given by instructor.)
     * 
     * @param s Symbol to be assessed.
     * @return True if symbol is an operand, false otherwise.
     */
    private static boolean isOperand(String s)
    {
        return s.matches("[a-z0-9\\.]+");
    }

    /**
     * A node on the expression tree.
     */
    private class Node
    {
        /** Element contained in the node. */
        public String element;

        /** Left child. */
        public Node left;

        /** Right child. */
        public Node right;

        /**
         * Constructs a node with two children.
         * All leaves are operands, all other Nodes are operators.
         * 
         * @param e Element contained in the node.
         * @param l Node's left child.
         * @param r Node's right child.
         */
        public Node(String e, Node l, Node r)
        {
            element = e;
            left = l;
            right = r;
        }
    }

    /** The root of the expression tree. */
    private Node root;

    /**
     * Creates a Binary Expression tree from a valid postfix expression.
     * 
     * @param postExpr Valid postfix expression.
     */
    public ExpressionTree(String postExpr)
    {
        //to be used as the stack
        ArrayDeque<Node> stack = new ArrayDeque();

        //each character in the expression, as a string
        String[] splitExpression = postExpr.split("");

        //put each character into a node in the tree
        for (int i = 0; i < postExpr.length(); i++)
        {

            String symbol = splitExpression[i];

            if (symbol.equals("+")
            || symbol.equals("-")
            || symbol.equals("*")
            || symbol.equals("/"))
            {
                Node right = stack.pop();
                Node left = stack.pop();
                stack.push(new Node(symbol, left, right));
            }
            else
            {
                stack.push(new Node(symbol, null, null));
            }
        }

        root = stack.pop();
    }

    /**
     * Checks if a String is a valid postfix expression.
     * 
     * @param expr The expression to be assessed.
     * @return True if the string is a valid postfix expression, false otherwise.
     */
    public static boolean postExpCheck(String expr)
    {
        //split string into characters, as strings
        String[] splitExpression = expr.split("");

        int oprndOnStack = 0;

        //check for valid contents
        for (int i = 0; i < splitExpression.length; i++)
        {
            String curr = splitExpression[i];

            //operands are lowercase letters a-z and digits 0-9
            if (isOperand(curr))
            {
                //new operands get placed on the stack
                oprndOnStack++;
            }
            //operators are +, -, *, /
            else if (isOperator(curr))
            {
                //there must be at least two operands on the stack
                if (oprndOnStack < 2)
                {
                    return false;
                }

                //two operands combine into one
                oprndOnStack--;
            }
            else //invalid character
            {
                return false;
            }
        }

        //stack must finish with exactly one operand on the stack
        return oprndOnStack == 1;
    }

    /**
     * Checks if a postfix expression that has a difinitive value (all operands are digits).
     * 
     * @param expr The postfix expression to be assessed.
     * @return True if the string is a valid postfix expression with digits for all operands.
     */
    public static boolean postExpHasVal(String expr)
    {
        //split expression into characters, as strings
        String[] splitExpression = expr.split("");

        //preliminary verification
        for (int i = 0; i < splitExpression.length; i++)
        {
            String curr = splitExpression[i];

            //each character must be either an operator or a digit operand
            if (!(isOperator(curr)
                || curr.matches("[0-9\\.]+")))
            {
                return false;
            }
        }

        //once operands are verified as digits, verify as normal
        return postExpCheck(expr);
    }

    /**
     * Returns a postfix represenation of the expression in the tree.
     * 
     * @return Tree expression in postfix.
     */
    public String postFixExp()
    {
        String postFix = postFixExp(root);

        return postFix.trim();  //remove leading/trailing spaces
    }

    /**
     * Recursive helper formula for the postFixExp() method.
     * 
     * @param curr Root of the current subtree.
     * @return String of subtree in postfix notation.
     */
    private String postFixExp(Node curr)
    {
        //separate symbols by spaces
        String currChar = curr.element.concat(" ");

        //base case: operand (leaf) 
        if (isOperand(curr.element))
        {
            return currChar;
        }

        //recurr: left subtree, right subtree, then subroot
        String subExp = postFixExp(curr.left);
        subExp = subExp.concat(postFixExp(curr.right));
        subExp = subExp.concat(currChar);

        return subExp;
    }

    /**
     * Retuns a prefix representation of the expression in the tree.
     * 
     * @return Tree expression in prefix.
     */
    public String preFixExp()
    {
        String preFix = preFixExp(root);

        return preFix.trim();   //remove leading/trailing spaces
    }

    /**
     * Recursive helper formula for the preFixExp() method.
     * 
     * @param curr Root of the current subtre.
     * @return String of subtree in prefix notation.
     */
    private String preFixExp(Node curr)
    {
        //separate symbols by spaces
        String subExp = curr.element.concat(" ");

        //base case: operand (leaf) 
        if (isOperand(curr.element))
        {
            return subExp;
        }

        //recurr: subroot, then left subtree, then right subtree
        subExp = subExp.concat(postFixExp(curr.left));
        subExp = subExp.concat(postFixExp(curr.right));

        return subExp;
    }

    /**
     * Evaluates the expression represented by the tree.
     * Assumes all operands are digits and no division by 0.
     * 
     * @return The resulting value.
     */
    public Float expressionVal()
    {
        return expressionVal(root);
    }
    
    /**
     * Recursive helper formula for the expressionVal() method.
     * 
     * @param curr The current subexpression being evaluated.
     * @return The value of the subexpression.
     */
    private Float expressionVal(Node curr)
    {
        //operators:
        if (curr.element.equals("+"))
        {
            return expressionVal(curr.left) + expressionVal(curr.right);
        }
        if (curr.element.equals("-"))
        {
            return expressionVal(curr.left) - expressionVal(curr.right);
        }
        if (curr.element.equals("*"))
        {
            return expressionVal(curr.left) * expressionVal(curr.right);
        }
        if (curr.element.equals("/"))
        {
            return expressionVal(curr.left) / expressionVal(curr.right);
        }
        
        //base case: operand
        Float value = Float.parseFloat(curr.element);
        return value;
    }

    /**
     * Returns the expression in infix notation with parentheses around every subexpression.
     * 
     * 
     * @return Infix expression with excessive parentheses.
     */
    public String inFixExp1()
    {
        //single-operand expression
        if (isOperand(root.element))
        {
            return root.element;
        }

        //no parens around whole expression:
        String inFix = inFixVerb(root.left) + " ";    //left subexpression
        inFix = inFix + root.element;                 //root operator
        inFix = " " + inFix + inFixVerb(root.right);  //right subexpression

        return inFix.trim(); //should have no leading/trailing spaces, but just in case
    }

    /**
     * Recursive helper formula for the inFixExp1() method.
     * 
     * @param curr The current subtree.
     * @return Infix representation of the subexpression, enclosed in parentheses.
     */
    private String inFixVerb(Node curr)
    {
        //base case: operand (leaf)
        if (isOperand(curr.element))
        {
            return curr.element;
        }

        //operator:

        String subExp = "( " + inFixVerb(curr.left);     //append paren, recurr right
        subExp = subExp + " " + curr.element + " ";      //insert operator
        subExp = subExp + inFixVerb(curr.right) + " )";  //recurr right, append paren

        return subExp;
    }

    /**
     * Returns the expression in infix notation with minimal parentheses.
     * 
     * @return Infix expression with minimal parentheses.
     */
    public String inFixExp2()
    {
        String inFix = inFixCons(root);
        
        return inFix.trim(); //should have no leading/trailing spaces, but just in case
    }

    /**
     * Recursive helper formula for the inFixExp2() method.
     * 
     * @param curr The current subtree.
     * @return Infix representation of the subexpression, enclosed in parentheses where needed.
     */
    private String inFixCons(Node curr)
    {
        //base case: operand (leaf)
        if (isOperand(curr.element))
        {
            return curr.element;
        }

        //left and right subexpressions, for all operators
        String leftSub = inFixCons(curr.left);
        String rightSub = inFixCons(curr.right);

        //maintain order of operations
        if (curr.element.equals("*")
        || curr.element.equals("/"))
        {
            //left operator is of lower precidence than current
            if (curr.left.element.equals("+")
            || curr.left.element.equals("-"))
            {
                //append parens to left subexpression
                leftSub = "( " + leftSub + " )";
            }
            //right operator is of lower precidence than current
            if (curr.right.element.equals("+")
            || curr.right.element.equals("-"))
            {
                //append parens to right subexpression
                rightSub = "( " + rightSub + " )";
            }
        }

        //combine around operator, separated by spaces
        String subExp = leftSub + " " + curr.element + " " + rightSub;
        
        return subExp;
    }
}
