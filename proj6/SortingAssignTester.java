import java.util.*;  

public class SortingAssignTester {

      public static void main(String[] args) {
      
      //SortProblems sortapp = new SortProblems();
      
      // Test MergeSort  Test 1
      int[] test1 = {4,  3,  2, 10, 7};      
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
      
      // Test invCounter  Test3 
      
      int answer3 = SortProblems.invCounter( test1   );


   }
}
