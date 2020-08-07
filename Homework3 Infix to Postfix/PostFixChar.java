
/**
 * Jack Kapino
 * HomeWork 3
 * Cs 253-02
 * PostFixChar class converts an infix expression to postfix expression.
 * A stack data structure is used to sort characters into correct postfix position
 * This class uses both stackPriority() and infixPriority() 
 * 
 */
public class PostFixChar
{
   
    public static stackAdt stack = new stackAdt(); 
   static private String expression;
   public static LLQueueADT postfixQueue = new LLQueueADT();
   public static LLQueueADT infixQueue = new LLQueueADT();

   public int stackPriority(char token)
   {
        if(token=='/' || token=='*'){return 2;}
        if(token=='+' || token=='-'){return 1;}
        if(token=='('){return 3;}
        if(token=='#'){return 0;}
        return 0;
    } 
   
   public int infixPriority(char token)
   {
        if(token=='/' || token=='*'){return 2;}
        if(token=='+' || token=='-'){return 1;}
        if(token=='('){return 3;}
        if(token==')'){return 0;}
        if(token=='#'){return 0;}
        return 0;
   } 
    
   public PostFixChar(String infixExpression) {
        expression = infixExpression;
   } 
     
   //Takes user entered string and stores data in a queue.  
   public void infixQueuem(String expression)
   {
        for(int i=0;i<expression.length();i++)
        {
            infixQueue.enqueue(expression.charAt(i));
        }
   } 
    
   //Algorithim for Converting infix queue into a postfix queue
   public void infixToPostfix() {
        int y = infixQueue.size();
        for(int index=0;index<y;++index){
            char value =infixQueue.dequeue();
            if (value == '(') {
                stack.push('(');
            } else if (value == ')') {
                Character oper = stack.peek();
                while (!(oper.equals('(')) && !(stack.isEmpty())) 
                {   stack.pop();
                    postfixQueue.enqueue(oper.charValue());
                    if (!stack.isEmpty())
                        oper = stack.peek(); }
                stack.pop();
            } else if (value == '+' || value == '-') {
                if (stack.isEmpty()) {
                    stack.push(value);
                } else {
                    Character oper = stack.peek();
                    while(infixPriority(value)<=+stackPriority(oper)&& !(stack.isEmpty())&&oper!='(')
                    {
                        oper = stack.pop();
                        postfixQueue.enqueue(oper.charValue());
                    }
                    stack.push(value);
                }
            } else if (value == '*' || value == '/') {
                if (stack.isEmpty()) {
                    stack.push(value);
                    stack.display();
                } else {
                    Character oper = stack.peek();
                    while(infixPriority(value)<=+stackPriority(oper)&& !(stack.isEmpty()) &&oper!='(' ){
                        oper = stack.pop();
                        postfixQueue.enqueue(oper.charValue());
                    }
                    stack.push(value);
                 }
            }else if (value == '#') {
                Character oper = stack.peek();
                while (!stack.isEmpty()) {
                 stack.pop();  
                 postfixQueue.enqueue(oper.charValue());
                }
            }
             else {
                System.out.println(value);
                postfixQueue.enqueue(value);
            }
        }
   } 
    
}
