/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This class is Data Structure which provides various functionalities of Max Heap
 * in Player with priority of balls
 */
package meta.utility;

public class MaxHeap {
	private Player[] Heap; // To store objects of player
    private int size; 
    private int maxsize; 
  
    // Constructor to initialize an 
    // empty max heap with given maximum wrt to Balls In Player
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new Player[this.maxsize + 1]; 
        Heap[0] = new Player(Integer.MAX_VALUE, Integer.MAX_VALUE); 
        // Heap[0] is root node of Heap.
        // we are adding another node as child of Heap[0] into MaxHeap.
        for(int i=1; i<=maxsize; i++){
        	Heap[i] = new Player(0,0);
        }
    } 
  
    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // return left child 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    // return right child
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
    // swap nodes position
    private void swap(int fpos, int spos) 
    { 
        Player tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    // A recursive function to max heapify the given tree
    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos].getBalls() < Heap[leftChild(pos)].getBalls() ||  
            Heap[pos].getBalls() < Heap[rightChild(pos)].getBalls()) { 
  
            if (Heap[leftChild(pos)].getBalls() > Heap[rightChild(pos)].getBalls()) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
    // Inserts a new element to max heap 
    public void insert(Player element) 
    { 
        Heap[++size] = element; 
  
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current].getBalls() > Heap[parent(current)].getBalls()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    // Remove an element from max heap 
    // here Max refer to max Player with Balls Excluding Heap[0]/root node.
    // so in this business sense Heap[1] is the larger node
    public Player extractMax() 
    { 
        Player popped = Heap[1]; 
        Heap[1] = new Player(0,0); 
        return popped; 
    }
    // return reaming heap in array form
    public Player[] getHeap(){
    	return Heap;
    }
}
