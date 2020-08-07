
/**
 * Jack Kapino
 * CSC 253-02
 * main/driver test sorting and recursive algorithms
 *
 */
import java.util.Scanner;
import java.io.*;

public class Main
{
      public static void main(String[] args)
   {
       Problem1 p = new Problem1();
       p.openFile();
       System.out.println("Part 1: \n");
       System.out.println("How many Elements in List: ");
       Scanner scan = new Scanner(System.in);
       int elements=scan.nextInt();
       int [] tst;
       if(elements==10){ tst= p.readInts10();}
       else{tst=p.readInts2000();}
       p.closeFile();
       int n=0,search;

       System.out.print("Original List: ");
       p.printArray(tst);
       System.out.println();
       System.out.println("Applying Bubble sort Algorithm. ");
       p.bubbleSort(tst);
       System.out.print("Bubble sort:");
       p.printArray(tst);
      
       
       
       ///Problem 2
       /**
       Problem2 p2 = new Problem2();
          System.out.println("Problem 2: \n");
         //Testing Binary Search
         System.out.println("Binary Search Algorithm: ");
         System.out.print("Sorted List: ");
         p.printArray(tst);
        search=p2.binarySearch(tst,0,tst.length-1,9);
        if (search == -1){System.out.println("Element not present");}
        else {System.out.println("Element found at index " + search);}
        System.out.println();
        System.out.println("Factorial Algorithm: ");
        System.out.println("Enter a factorial number: ");
        n=scan.nextInt();
        System.out.println("Factorial of "+n+" is: "+p2.factorial(n)+"\n");
        System.out.println("\nFibonacci Algorithm: ");
        System.out.println("Enter a Fibonacci number: ");
        n=scan.nextInt();
        System.out.println(n+"th Fibonacci Number is: "+p2.fibonacci(n)+"\n");
       
       */
       
       
        
    }
}
