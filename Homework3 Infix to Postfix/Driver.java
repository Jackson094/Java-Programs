
/**
 * Write a description of class Driver here.
  * Jack Kapino
 * Cs 253-02
 * Main/Driver Class
 */
import java.util.Scanner;
public class Driver
{
   static private String expression;
    public static void main(String[] args) {
        System.out.println("Type an expression written in Infix notation: ");
        Scanner input = new Scanner(System.in);
        String expression = input.next();
        PostFixChar convert = new PostFixChar(expression);
        
        System.out.println("\nInfix Queue: ");
        convert.infixQueuem(expression);
        convert.infixQueue.display();
        System.out.println("\n");
        
        convert.infixToPostfix();
        System.out.println("\nPostFix queue: ");
        convert.postfixQueue.display();
        
        System.out.println("\n\n");
        convert.postfixQueue.evaluate();

   }
}
