//Jack Kapino 
//Cs 253 Homework 2 QuickSort Implementation
import java.util.Scanner;
import java.io.*;
class QuickSort1 
{ 
    private Scanner z;
    static int comps=0, swaps=0;
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
    
   
   //Start of QuickSort algorthim functions------------
   
   int partition(int arr[], int start, int end) 
   { 
        int pivot = arr[end]; 
        int i = (start-1); 
        for (int j=start; j<end; j++) 
        { 
            comps++;
            if (arr[j] < pivot) 
            { 
                i++; 
                swaps++;
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        swaps++;
        int temp = arr[i+1]; 
        arr[i+1] = arr[end]; 
        arr[end] = temp; 

        return i+1; 
    } 

    void quickSort(int arr[], int start, int end) 
    { 
        if (start < end) 
        { 
            int pivot = partition(arr, start, end); 
            quickSort(arr, start, pivot-1); 
            quickSort(arr, pivot+1, end);
        } 
    } 
    
} 
