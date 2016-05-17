public class SortProblems {

   public static int[] IterMergeSort (int []  arr) {
      int[] answer = new int[arr.length];
      return answer;
   }   //end IterMergeSort
   
   
   // finds target in a two dimensional array with monotone increasing rows and columns,
   // return {-1,-1} if not found
   public static int[]  locator  ( int target, int [][] arr) {  
      int[] answer = new int[2];
      int n = arr.length;  //length of each array
      
      //default case
      answer[0] = -1;
      answer[1] = -1;
      
      //[i][j]
      
      //search each "row"
      for (int i = 0; (i < n) && (arr[i][0] < target); i++)
      {
        //search each "collumn"
        //linear version
        System.out.print(i + ": ");
        int j = 0;
        while ((j < n - 1) && (arr[i][j]) < target)
            {
                System.out.print(j + ", ");
                j++;
            }
        System.out.println();
        
        //stop at >= target or last element
        
        //if found (i.e. stopped at == target)
        if (arr[i][j] == target)
        {
            answer[0] = i;
            answer[1] = j;
            
            //terminate outer loop? or bad form?
            break; 
        }
        
        /*
        //binary version
        int lo = 0;
        int hi = n - 1;
        
        do
        {
            //average
            int j = (lo + hi) / 2;
            
            //go left
            if (arr[i][j] > target)
                hi = j - 1;
            //go right
            else if (arr[i][j] < target)
                lo = j + 1;
            //found
            else
            {
                lo = j;
                hi = j;
            }
            
        } while (lo < hi) 
        
        
        if (arr[i][j] == target)
            {
                answer[0] = i;
                answer[1] = j;
                
                //terminate here? or bad form?
                return answer;
            }
        */
      }
      
      return answer;
   }  //end locator
   
   
   // Finds the number of inversions in 
   public static int invCounter  (int [] arr ) {  
      int answer = 1;
      return answer;      
   }  //end invCounter
   
}  // end class
