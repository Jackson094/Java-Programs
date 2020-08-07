
/**
 * Write a description of class stackAdt here.
 *
 * Stack Adt implementation
 */
public class stackAdt
{
    public Node top;
    private int size;
    stackAdt()
    {
        top=null;
        size=0;
    }
    public Node getTop(){return top;}
    public boolean empty(){return (top==null);}
    public int size(){return size;}
    public void push(char c)
    {
        Node newNode = new Node();
        newNode.setToken(c);
        newNode.setNext(top);
        top=newNode;
        size++;
    }
    public char pop()
    {
     char x;
     x=top.getToken();
     top=top.getNext();
     size--;
     return x;
    }
    
    public char peek()
    {
        if(this.isEmpty()){System.out.println("Empty.");return ' ';}
        else{
         char x = pop(); 
         push(x);
         return x;
        }
    }
    public boolean isEmpty(){return(top==null);}
    
    public void display()
    {
        Node temp=this.getTop();
        if(this.isEmpty()){System.out.println("Stack is empty!");return;}
        while(temp.getNext()!=null)
        { 
         System.out.print(temp.getToken()+" ");
         temp=temp.getNext();
        }
        System.out.println(temp.getToken());
    }
    
    //used for evalulation postfix expression (Integer Parameter)
    public void push(int c)
    {
        Node newNode = new Node();
        newNode.setData(c);
        newNode.setNext(top);
        top=newNode;
        size++;
    }
    //Used to evaluate postfix expression
    public int Intpop()
    { 
     int x;
     x=top.getData();
     top=top.getNext();
     size--;
     return x;
    }
}
