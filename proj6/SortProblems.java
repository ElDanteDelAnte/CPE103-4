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
        /*
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
        */
        
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
                answer[0] = i;
                answer[1] = j;
                
                //terminate here? or bad form?
                return answer;
            }
            
        } while (lo < hi);
        
        
      }
      
      return answer;
   }  //end locator
   
   
   // Finds the number of inversions in 
   public static int invCounter  (int [] arr ) {  
        //base case
        if (arr.length < 2) return 0;
        
        int answer = 0;
        
        /* Divide */
        //get sizes for left and right halves
        int rLength = arr.length / 2;
        int lLength = arr.length - rLength; //left is longer if odd-numbered
        
        //build arrays
        int[] lHalf = new int[lLength];
        int[] rHalf = new int[rLength];
        
        int i = 0;
        
        for (int il = 0; il < lLength; il++)
            lHalf[il] = arr[i++];
        
        for (int ir = 0; ir < rLength; ir++)
            rHalf[ir] = arr[i++];
        
        /* Combine */
        answer = invCounter(lHalf) + invCounter(rHalf);
        
        i = 0;
        int l = 0;
        int r = 0;
        
        /* Conquer */
        //run until one runs out
        while ((l < lLength) && (r < rLength))
        {
            //inversion
            if (lHalf[l] > rHalf[r])
            {
                //merge
                arr[i++] = rHalf[r++];
                //count invert
                answer += lLength - l;
            }
            //non-inversion
            else //(lHalf[l] < rHalf[r])
            {
                //merge
                arr[i++] = lHalf[l++];
            }
            /*
            //what to do when equal?
            else
            {
                System.out.println("Equal, what do?");
                break;
            }*/
        }
        
        //add rest of left
        while (l < lLength)
        {
            arr[i++] = lHalf[l++];
        }
        
        //add rest of right
        while (r < rLength)
        {
            arr[i++] = rHalf[r++];
        }
        
        return answer;      
   }  //end invCounter
   
   /*
   public static int invCountLinear(int[] arr)
   {
    int count = 0;
    
    for (int i = 0; i < arr.length; i++)
    {
        for (int j = i + 1; j < arr.length; j++)
        {
            if (arr[i] > arr[j])
                count++;
        }
    }
    
    return count;
   }*/
   
}  // end class
