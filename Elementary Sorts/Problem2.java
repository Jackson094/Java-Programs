
/**
 * Csc253-02
 *Jack Kapino
 * Problem 2: Recursive algorithims Binary Search, factorial, fibbonaci
 * 
 */
public class Problem2
{
  public static int binarySearch(int arr[], int start, int r, int x) 
  { 
      if (r >= start) { 
          int mid = start + (r - start) / 2; 

          if (arr[mid] == x) 
              return mid; 
  
          // If element is smaller than mid, then only in left subarray  
          if (arr[mid] > x) 
              return binarySearch(arr, start, mid - 1, x); 
  
            // Else the element can only be in right subarray 
          return binarySearch(arr, mid + 1, r, x); 
      } 

      return -1; //Element is not in list
  } 
   
    
  public static int factorial(int n)
  {
     if(n==0)
      return 1;
     else{return n*factorial(n-1);}    
  }
    
  public static int fibonacci(int n)
  {
     if(n<=1){return n;}
     else{return fibonacci(n-1)+fibonacci(n-2);}  
  }
      
}
