import java.util.*;  

public class SortingAssignTester {

      public static void main(String[] args) {
      
      //SortProblems sortapp = new SortProblems();
      
      // Test MergeSort  Test 1
      int[] test1 = {4,  5,  2, 3, 0};      
      int[] answer = new int[20];
      answer = SortProblems.IterMergeSort( test1 );
      

      // Test locator  Test2  -- note haystack could be much more complex than this
      int [][] haystack = new int[20][20];
      for (int i = 0; i<20; i++){
          for (int j = 0; j<20; j++){
            haystack[i][j] = 2*i + j + 1;
         }
      }
      int [] answer2 = new int[2];
      int target = 25;
      answer2 = SortProblems.locator(target,haystack);
      
      System.out.println("Locator test: (" 
        + answer2[0] + ", " + answer2[1] + ")");
      //should be (3, 18)
      
      int[] answer22 = new int[2];
      answer22 = SortProblems.locator(0, haystack);
      System.out.println("Locator test 2: ("
        + answer22[0] + ", " + answer22[1] + ")");
      //should be (-1, -1) without probes
      
      int[] answer23 = new int[2];
      answer23 = SortProblems.locator(59, haystack);
      System.out.println("Locator test 3: ("
        + answer23[0] + ", " + answer23[1] + ")");
      //should be (-1, -1) with many probes
      
      // Test invCounter  Test3 
      //int target3 = SortProblems.invCountLinear(test1);
      //System.out.println("Target: " + target3);
      
      int answer3 = SortProblems.invCounter( test1   );
      System.out.println("Result: " + answer3);
      
      int[] test32 = {20, 17, 8, 9, 10, 11, 15, 14, 13, 23, 25, 27, 21, 5, 3, 1, 7, 2};
      //int target32 = SortProblems.invCountLinear(test32);
      int answer32 = SortProblems.invCounter(test32);
      //System.out.println("Target: " + target32);
      System.out.println("Result: " + answer32);
      
      int[] test33 = {3, 4, 3, 5};
      //int target33 = SortProblems.invCountLinear(test33);
      int answer33 = SortProblems.invCounter(test33);
      //System.out.println("Target: " + target33);
      System.out.println("Result: " + answer33);


   }
}
