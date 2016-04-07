/**
 * Evaluates a postfix expression using MyStack.
 * Test driver for MyStack class.
 * 
 * @author Sean Reddell
 * @version 4/7/16
 */

import java.util.Scanner;

public class PostFixCalc
{
    /**
     * Evaluates a postfix expression of integers.
     * Truncation of integers during calculation may
     * cause found result to varry from actual value.
     * The expresion is assumed to be valid.
     * 
     * @param expression The postfix expression.
     * @return The calculated value.
     */
    private static int postfixValue(String expression)
      {
        //operands
        MyStack opers = new MyStack();
        
        Scanner postfix = new Scanner(expression);
        
        while (postfix.hasNext())
          {
            //read the expression
            String token = postfix.next();
            
            
            //operator
            int operand;

            switch (token)
              {
                case "+":
                    operand = opers.pop();
                    opers.push(opers.pop() + operand);
                    break;
                case "-":
                    operand = opers.pop();
                    opers.push(opers.pop() - operand);
                    break;
                case "*":
                    operand = opers.pop();
                    opers.push(opers.pop() * operand);
                    break;
                case "/":
                    operand = opers.pop();
                    opers.push(opers.pop() / operand);
                    break;
                case "^":
                    operand = opers.pop();
                    //adapt for int-only MyStack
                    int truncd = (int) Math.pow(opers.pop(), operand);
                    opers.push(truncd);
                    break;
                
                //operand
                default:
                    Scanner tokenReader = new Scanner(token);
                    /*
                    if (tokenReader.hasNextInt()) //integer
                      {
                        operand = new Double((double) tokenReader.nextInt());
                      }
                    else //float
                      {
                        operand = new Double((double) tokenReader.nextFloat());
                      }
                    */
                    opers.push(tokenReader.nextInt());
                    break;
              }
            
          }
          
        //end of expression

        return opers.pop();
      }
    /**
     * Takes postfix string from user and prints result.
     * 
     * @param args N/A.
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        //obtain expression from user
        if (input.hasNextLine())
        {
            String postfix = input.nextLine();
            int result = postfixValue(postfix);
            System.out.println("The result is " + result);
        }
        else
        {
            System.out.println("No input, quitting.");
        }
        
        
    }
}
