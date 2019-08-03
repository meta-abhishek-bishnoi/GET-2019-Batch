/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This Class is Priority Class which contains various operations
 */
package meta.utility;

public class PQueue {
	int front;
	int rear;
	final int SIZE;
	int queue[] ;
	/**
	 * constructor ton create queue
	 * @param size
	 */
	public PQueue(int size){
		SIZE = size+1;
		queue = new int[SIZE];
	}
	/**
	 * insertion into queue
	 * @param data
	 * @return boolean value
	 * @exception Assertion Error when Queue is Overflow
	 */
	public boolean insert(int data){
		if(rear >= SIZE-1){
			throw new AssertionError("Queue Overflow");
		}
		// if entry is first entry
		if ((front == -1) && (rear == -1))
	    {
	        front++;
	        rear++;
	        queue[rear] = data;
	        return true;
	    }    
	    else{ // otherwise
	    	insertWithPriority(data);
	    	rear++;
	    }
		return true;
	}
	
	/**
	 * This Function is used to rearrange data into priority queue as per priority
	 * @param data
	 * @return boolean value
	 */
	private boolean insertWithPriority(int data) {
		int i,j;
		 
	    for (i = 0; i <= rear; i++)
	    {
	        if (data >= queue[i])
	        {
	            for (j = rear + 1; j > i; j--)
	            {
	                queue[j] = queue[j - 1];
	            }
	            queue[i] = data;
	            return true;
	        }
	    }
	    queue[i] = data;
		return true;
	}
	/**
	 * this function delete front element and return it
	 * @return int value (popped value)
	 * @exception Assertion Error when Queue Is Empty
	 */
	public int poll(){
		if( (front == -1) && (rear == -1) ){
			throw new AssertionError("Queue Is Empty");
		}
		if(front == rear){
			throw new AssertionError("Queue Is Empty");
		}
		int value = queue[front];
		queue[front++]= -99;
		return value;
	}
	/**
	 * This Function only returns front element without deleting it.
	 * @exception Assertion Error when queue is empty
	 * @return popped value
	 */
	public int peek(){
		if( (front == -1) && (rear == -1) ){
			throw new AssertionError("Queue Is Empty");
		}
		if(front == rear){
			throw new AssertionError("Queue Is Empty");
		}
		return queue[front];
	}
	/**
	 * @return size of queue
	 */
	public int size(){
		return rear - front;
	}
	/**
	 * This Function delete given element
	 * @return true or false value
	 * @exception Assertion Error when queue is empty
	 */
	public boolean remove(int data){
		int i;
		 
	    if ((front==-1) && (rear==-1))
	    {
	        throw new AssertionError("Queue Is Empty");
	    }
	 
	    for (i = 0; i <= rear; i++)
	    {
	        if (data == queue[i])
	        {
	            for (; i < rear; i++)
	            {
	                queue[i] = queue[i + 1];
	            }
	 
	        queue[i] = -99;
	        rear--;
	 
	        if (rear == -1){
	        	front = -1;
	        }
	        return true;
	        }
	    }
	    return false;
	}
}
