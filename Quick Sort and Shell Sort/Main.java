
/**
 * Main/Driver Class
 * Jack Kapino
 * Cs253-02
 * Homework #2
 *
 * 
 */
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
    Hw2_Shell list = new Hw2_Shell();
    list.openFile();
    System.out.println("Part 2: \n");
    System.out.println("How many Elements in List: ");
    Scanner scan = new Scanner(System.in);
    int elements=scan.nextInt();
    int [] tst;
    if(elements==10){ tst= list.readInts10();}
    else{tst=list.readInts2000();}
    list.closeFile();
       
    //Shell Sort
    //System.out.println("Shell Sort: ");
    //System.out.print("Original List: ");
    //list.printArray(tst);
  
    
    System.out.println("Quick Sort Algorithim:\n");
     QuickSort1 ob = new QuickSort1(); 
     System.out.println("Original List: ");
     ob.printArray(tst);
     System.out.println("\nSorted List: ");
     ob.quickSort(tst, 0, tst.length-1);
     ob.printArray(tst);
     System.out.println(("\nComparisons: "+ob.comps));
     System.out.println(("Swaps: "+ob.swaps+"\n\n"));
       

      
    
  
     
     
     
    }
  
}
