
/**
 * 
 * CS253-02
 * Jack Kapino
 * Problem 1: Insertion Sort, Selection Sort, Bubble Sort
 * 
 */
import java.util.Scanner;
import java.io.*;

public class Problem1
{
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
   
    
   //Avoids need toresize or copy/clone arrays, creates arrays of size 10
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
   
    //Takes an Array Parameter then displays/prints the array as output
   public static void printArray(int arr[]) 
   { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
   } 
   
   public static int[] insertionSort(int[] list)
   {
        int i,j,key,temp,comp=0,swap=0;
        for(i=1;i<list.length;i++)
        {
            key=list[i];
            j=i-1;
            comp++;
            while(j>=0 && key<list[j])
            {
             swap++;
             temp=list[j];
             list[j]=list[j+1];
             list[j+1]=temp;
             j--;
             if(j>=0){comp++;}
            }
            
        }
        
        System.out.println("Comparisons:"+comp);
        System.out.println("Swaps: "+swap);
     return list;   
   }
    
   public static int[] bubbleSort(int[] list)
   {
     int i,j,temp=0,swap=0,comp=0;
     for(i=1;i!=list.length;i++)
     {
         for(j=0;j!=list.length-i;j++)
         {
             comp++;
             if(list[j]>list[j+1])
             {
                 swap++;
                 temp=list[j];
                 list[j]=list[j+1];
                 list[j+1]=temp;
                }
            }
        }
     System.out.println("Comparisons:"+comp);
     System.out.println("Swaps: "+swap); 
        
     return list;   
   }
   
   public static int[] selectionSort(int[] list)
   {
     int i, j, minVal,minIndex,temp=0,comp=0,swap=0;
     for(i=0;i<list.length-1;i++)
     {
        minIndex=i;
        for(j=i+1;j<list.length;j++)
        {
             comp++;
             if(list[j]<list[minIndex])
             {
                 minIndex=j;
             }
        }
        if(minIndex !=i)
           swap++;
        temp=list[minIndex];
        list[minIndex]=list[i];
        list[i]=temp;
           
     }       
     System.out.println("Comparisons:"+comp);
     System.out.println("Swaps: "+swap);
     return  list;
   }
}
