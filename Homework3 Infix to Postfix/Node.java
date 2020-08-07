
/**
 * Cs 253 
 * Homework 3 Node class
 * 
 */
public class Node
{
    private int data;
    public char token;
    private Node next;
    public Node()
    {       
        data=0;
        next=null;   
    }
    
    public Node(int data,char token)
    {
        this.data=data;
        this.token=token;
    }
    
    public Node(int data, Node nxt)
    {this.data=data; }    
    
    public void setData(int d, Node n)
    {
        data=d;
        next=n;
    }
    
    public void setData(int newData)
    {data=newData;}
    
    public void setNext(Node newNxt)
    {next=newNxt; }
    
    public int getData(){return data;}
    public Node getNext(){return next;}
    public void displayNode(){System.out.println(data);}
    public void setToken(char c){token=c;}
    public char getToken(){return token;}
    
}