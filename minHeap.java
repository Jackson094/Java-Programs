
/**
 * Jack Kapino Kruskals Algorithim Graph Project
 * Priority Queue Implemented As Min-Heap
 * min-heap is used to order the edges
 * provides an efficent removal based on priority.
 *
 * 
 */
public class minHeap
{
    public Edge[] Heap; 
    private int size; 
    private int max; 
    private static final int FRONT = 1; 

    public minHeap(int max) 
    { 
        this.max = max; 
        this.size = 0; 
        Heap = new Edge[this.max + 1]; 
        Heap[0] = null; 
    } 

    //returns true if node is a leaf 
    public boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        else{return false; }
    } 

    // Function to swap two nodes of the heap 
    private void swap(int first, int second) 
    { 
        Edge tmp; 
        tmp = Heap[first]; 
        Heap[first] = Heap[second]; 
        Heap[second] = tmp; 
    } 

    // Function to heapify the node at pos 
    public void minHeapify(int pos) 
    { 

        // If the node is a non-leaf node and larger then all children 
        if (!isLeaf(pos)) { 
            if ( Heap[pos].weight > Heap[2*(pos)].weight || Heap[pos].weight > Heap[2*(pos)+1].weight) 
               { 
                // Swap and heapify 
                if (Heap[2*(pos)].weight < Heap[2*(pos)+1].weight) 
                { 
                    swap(pos,2*(pos)); 
                    minHeapify(2*(pos)); 
                } 
                else 
                { 
                    swap(pos, 2*(pos)+1); 
                    minHeapify(2*(pos)+1); 
                } 
            } 
        } 
    } 

    // Function to insert a node into the heap 
    public void insert(Edge element) 
    { 
        if (size >= max) 
        { 
            return; 
        } 
        Heap[++size] = element; 
        int current = size; 
        while (current !=1 && Heap[current].weight < Heap[current/2].weight) 
        { 
            swap(current, current/2); 
            current = current/2; 
        } 
    } 

    //builds heap using minHeapify
    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 

    // remove and return the minimum element
    public Edge remove() 
    { 
        Edge popped = Heap[FRONT]; 
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT); 
        return popped;
    } 
    
}
