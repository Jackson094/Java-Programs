
/**
 * Write a description of class Hw2_Shell here.
 *
 * Jack Kapino
 * Cs 253 HomeWork 2
 */
import java.util.Scanner;
import java.io.*;
public class Hw2_Shell
{
  static int comp=0, swaps=0;
    private Scanner z;
   
   public void openFile()
   {
       int count=0;
       try{
           System.out.println("Enter Name of File:");
           Scanner scan = new Scanner(System.in);
           String fileName = scan.nextLine();
           z=new Scanner(new File(fileName));           
        } catch(Exception e){System.out.println("Error Caught.");}
       
   }
   
   //Avoids need to resize or copy/clone arrays, reads data and creates arrays of size 10
   public int[] readInts10()
   {
       int i=0;
       int [] array = new int[10];
       while(z.hasNext())
       {
           array[i] = z.nextInt();
           i++;
       }
       return array;
   } 
    
   public int[] readInts2000()
   {
       int i=0;
       int [] array = new int[2000];
       while(z.hasNext())
       {
           array[i] = z.nextInt();
           i++;
       }
       return array;
   }
    
   public void closeFile(){z.close();}
   
   public static void printArray(int arr[]) 
   { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
   } 
  
  //Shell Sort Implementation-----------
  //Interval/Gap =(N/2) N= length of array
    public static void sort2(int[] array) {
    int inner=0, outer;
    int temp=0;
    
    int h = (array.length)/2;
   
    while (h > 0) {
      for (outer = h; outer < array.length; outer++) {
        inner = outer;
        comp++;
        while (inner > h - 1 && array[inner - h] >= temp) {
          array[inner] = array[inner - h];
          swaps++;
          inner -= h;
          if(inner!=0){comp++;}
        }
        array[inner] = temp;
      }
      h = (h )/ 2; 
    }
    printArray(array);
    System.out.println("Swaps:" +swaps);
    System.out.println("Comparisons:" +comp);
  }
    
  //Shell Sort-Interval/Gap = (h-1)/3 
  public static void sort3(int[] array) {
    int inner=0, outer;
    int temp=0;
    int h = 1;
    while (h > 0) {
      for (outer = h; outer < array.length; outer++) {
        temp = array[outer];
        inner = outer;
        comp++;
        while (inner > h - 1 && array[inner - h] >= temp) {
          array[inner] = array[inner - h];
          swaps++;
          inner -= h;
          if(inner!=0){comp++;}
        }
        array[inner] = temp;
      }
      h = (h - 1) / 3;
    }
    printArray(array);
    System.out.println("Swaps:" +swaps);
    System.out.println("Comparisons:" +comp);
  }
}
