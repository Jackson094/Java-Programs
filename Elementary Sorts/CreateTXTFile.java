
/**
 * Creates a txt file
 *
 * Independent Module that Creates text files for homework
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class CreateTXTFile
{
   public static void main(String[] args)
    {
           System.out.println("Enter Name of File:");
           Scanner scan = new Scanner(System.in);
           String fileName = scan.nextLine();
           try
           {
                File fac = new File(fileName);
                if (!fac.exists())
                {
                    fac.createNewFile();
                }
                System.out.println("\n----------------------------------");
                System.out.println("The file has been created.");
                System.out.println("------------------------------------");
                int r = 1;
                FileWriter wr = new FileWriter(fac);
                for (int i = 1; i<=10; i++)
                {
                    r = r * i;
                    wr.write(r+System.getProperty( "line.separator" ));
                }               
                wr.close();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
   }
}
