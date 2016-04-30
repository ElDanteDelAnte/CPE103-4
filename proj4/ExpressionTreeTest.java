import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.*;

import java.util.ArrayList;

public class ExpressionTreeTest {
   
   private static int countModifiers(Method[] methods, int modifier)
   {
      int count = 0;
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }

   @Test
   public void testArchitecture() {
      boolean pass = true;
      String msg = "      FAILED: ";
      ExpressionTree f;
      Class cl;
      Class[] temp;
      
      f = new ExpressionTree("");
      
      cl = f.getClass();

      int cnt = cl.getConstructors().length;     
      assertTrue(msg + cnt + " constructors, expected 1", cnt == 1);
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      assertTrue(msg + cnt + " public methods, expected 5", cnt == 5);

      cnt = countModifiers(cl.getDeclaredMethods(), (Modifier.STATIC + 1));     
      assertTrue(msg + cnt + " static methods, expected 2", cnt == 2);
   }

   @Test
   public void testMethodNames() {
      ExpressionTree expT = new ExpressionTree("");
      boolean out = ExpressionTree.postExpCheck("");
      out = ExpressionTree.postExpHasVal("");
      String res = expT.postFixExp();
      res = expT.preFixExp();
      Float ress = expT.expressionVal();
      String val = expT.inFixExp1();
      val = expT.inFixExp2();
   }


   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(ExpressionTreeTest.class); 
   }

   public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("ExpressionTreeTest");
   }
}
