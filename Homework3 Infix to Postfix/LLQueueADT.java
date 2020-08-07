
/**
 * .
*Jack Kapino
 *Homework 3
 *Queue Data Structure uses LLQueue Interface.
 */

public class LLQueueADT implements LLQueue
{
    
    private int size;
    private Node front;
    private Node rear;
    static String eval="";
    
    public LLQueueADT()
    {size=0;front=null;rear=null;
    }
    
    public boolean isEmpty(){return(size==0);}
    public int size(){return size;}
    public void enqueue(char number)
    {
     Node newNode = new Node();
     newNode.setToken(number);
     newNode.setNext(null);
     if(this.isEmpty()){front = newNode;}
     else{
        rear.setNext(newNode);}
     rear=newNode;
     size++;
        
    }
    
     public char dequeue()
    {
        char i;
        i=front.getToken();
        front=front.getNext();
        size--;
        if(this.isEmpty())
        {rear=null;}
        return i;
    }
    
    public Node getFront(){return front;}
    public int front(){return front.getData();}
    public void display()
    {
        Node temp=front;
        while(temp!=null)
        { System.out.print(temp.getToken());
          temp=temp.getNext();
        }
    }
    
    //Evaluate Method is used to evaluate postfix expression
    public void evaluate()
    {
       Node temp=front;
       while(temp!=null)
      { 
        eval+=temp.getToken();
        temp=temp.getNext();
      }
      stackAdt evalstack = new stackAdt();
      char x=eval.charAt(0);
    
      if(Character.isDigit(x)) 
      {
      System.out.println("Evaluated Postfix: ");
      
      // Scans all characters of in PostFixQueue
      for(int i=0;i<eval.length();i++) 
      { 
       char c=eval.charAt(i);        
    
       // If character is an operand push onto the stack. 
       if(Character.isDigit(c)) 
        { 
           evalstack.push(c - '0'); 
        }    
       // Else, pop two 2 elements from the stack
       else
       { 
         int element1 = evalstack.Intpop(); 
         int element2 = evalstack.Intpop();              
         switch(c) 
         { 
            case '+': 
            evalstack.push(element2+element1); 
            break; 
                    
            case '-': 
            evalstack.push(element2- element1); 
            break; 
                    
            case '/': 
            evalstack.push(element2/element1); 
            break; 
                    
            case '*': 
            evalstack.push(element2*element1); 
            break; 
        } 
       } 
      } 
	System.out.println(evalstack.Intpop());
    }
   }
}
