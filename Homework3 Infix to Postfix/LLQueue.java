
/**
 * Queue interface LLQueue from lecture notes
 *
 * Jack Kapino
 * Csc 253 Homework #3
 */
public interface LLQueue
{
    public void enqueue(char token);
    public char dequeue();
    public int size();
    public boolean isEmpty();
    public int front();
}
