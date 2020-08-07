
/**
 * Jack Kapino Graph Project Kruskals
 * Edge Class is used to represent a weighted graph edge
 * 
 */
public class Edge
{
    int destination;
    int weight;
    int source;
    
    public Edge(int source, int destination, int weight)
    {
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
    
    public String toString()
    {return weight+"";}
}
