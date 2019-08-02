package meta.utility;

public class MaxHeap {
	private Player[] Heap; 
    private int size; 
    private int maxsize; 
  
    // Constructor to initialize an 
    // empty max heap with given maximum 
    // capacity. 
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new Player[this.maxsize + 1]; 
        Heap[0] = new Player(Integer.MAX_VALUE, Integer.MAX_VALUE); 
        for(int i=1; i<=maxsize; i++){
        	Heap[i] = new Player(0,0);
        }
    } 
  
    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
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
  
    private void swap(int fpos, int spos) 
    { 
        Player tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
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
    public Player extractMax() 
    { 
        Player popped = Heap[1]; 
        Heap[1] = new Player(0,0);
        maxHeapify(1); 
        return popped; 
    }
    //
    public Player[] getHeap(){
    	return Heap;
    }
}
