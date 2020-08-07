/**
 * Kruskal's Muddy City Algorithim
 * Contains graph class which is represents the graph with an Adjacency List
 * uses priority queue to order edges
 * Disjoint set data structure handles clustering and cycles
 *
 * Jack Kapino
 * Cs 253 Graph Project
 */

import java.util.LinkedList;
public class KruskalsAlgorithim
{
    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjList;
        minHeap minHeapPQ = new minHeap(30);
        
         Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int dest, int weight) {
            Edge New_edge = new Edge(source,dest,weight);
            adjList[source].addFirst(New_edge);
            minHeapPQ.insert(New_edge);
        }
        
        public void minimumSpanningTree(){  
            Edge[] MinST= new Edge[vertices-1]; //Stores Final MST
            int [] set = new int[vertices];  //creates array to store parents
            makeSet(set);
            int totalweight=0;
      
            //process n - 1 edges from priority heap
            int index = 0;
            while(index<vertices-1){
                Edge edge = minHeapPQ.remove();
                int x_set = find(set, edge.source);
                int y_set = find(set, edge.destination);
                if(x_set==y_set)    
                {} //Do nothing if edge creates a cycle
                
                else {                     //Add Edge to MST
                    MinST[index]=edge;
                    totalweight+=edge.weight;
                    index++;
                    union(set,x_set,y_set);
                }
            }

            System.out.println("Minimum Spanning Tree: ");
            for(int i=0;i<vertices-1;i++)   //Display/output mst array
            {   
                System.out.println("Edge "+(i+1)+" Source: "+MinST[i].source+
                " destination: "+MinST[i].destination+" weight: "+MinST[i].weight);
                
            }
            System.out.println("Weight of Minimum Spanning Tree: "+totalweight);
        }

        //Create a set contains an element with a pointer to itself.
        public void makeSet(int [] set){
            for (int i = 0; i <vertices ; i++) 
            {
                set[i] = i;
            }
        }
        
        //Helps identify parent of the set
        public int find(int [] root, int node)
        {
            if(root[node]!=node)
            {  
              return find(root, root[node]);
            }
            return node;
        }
        
        //Combine disjoint sets making x the parent of y.
        public void union(int [] parent, int x, int y)
        {
            int xparent = find(parent, x);
            int yparent = find(parent, y);
            parent[yparent] = xparent;
        }
        
    }
     public static void main(String[] args) 
     {
          int vertices = 10;
          System.out.println("Total Number of Nodes: "+vertices);
          Graph graph = new Graph(vertices);
          int totalweight=0;
            
          //Edges are added to The graph in a specific order that is
          //identical to the muddy city graph diagram shown in graph paper.
          
          //Adding edges to Graph
           
           //Node A 
            graph.addEdge(0, 1, 5);
            graph.addEdge(0, 3, 4);
            graph.addEdge(0, 2, 3);
            //Node B
            graph.addEdge(1, 0, 5);
            graph.addEdge(1, 2, 3);
            graph.addEdge(1, 7, 2);
            graph.addEdge(1, 9, 3);
            graph.addEdge(1, 8, 4);
            //Node C
            graph.addEdge(2, 0, 3);
            graph.addEdge(2, 1, 3);
            graph.addEdge(2, 3, 5);
            graph.addEdge(2, 5, 4);
            graph.addEdge(2, 7, 3);
            //Node D
            graph.addEdge(3, 0, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(3, 5, 4);
            graph.addEdge(3, 0, 4);
            graph.addEdge(3, 2, 5);
            //Node E
            graph.addEdge(4, 3, 2);
            graph.addEdge(4, 5, 3);
            graph.addEdge(4, 6, 3);
            //Node F
            graph.addEdge(5, 4, 3);
            graph.addEdge(5, 3, 4);
            graph.addEdge(5, 2, 4);
            graph.addEdge(5, 7, 4);
            graph.addEdge(5, 6, 2);
            //Node G
            graph.addEdge(6, 4, 3);
            graph.addEdge(6, 5, 2);
            graph.addEdge(6, 7, 3);
            graph.addEdge(6, 8, 4);
            //Node H
            graph.addEdge(7, 5, 4);
            graph.addEdge(7, 2, 3);
            graph.addEdge(7, 1, 2);
            graph.addEdge(7, 8, 3);
            graph.addEdge(7, 6, 3);
            //Node I
            graph.addEdge(8, 6, 4);
            graph.addEdge(8, 7, 3);
            graph.addEdge(8, 1, 4);
            graph.addEdge(8, 9, 2);
            //Node J
            graph.addEdge(9, 1, 3);
            graph.addEdge(9, 8, 2);

            graph.minimumSpanningTree();
            
    }  
    
}
