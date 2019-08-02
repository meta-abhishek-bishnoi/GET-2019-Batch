/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 */
package meta.utility;

public class PQueue {
	int front;
	int rear;
	final int SIZE;
	int queue[] ;
	/**
	 *
	 * @param size
	 */
	public PQueue(int size){
		SIZE = size+1;
		queue = new int[SIZE];
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean insert(int data){
		if(rear >= SIZE-1){
			throw new AssertionError("Queue Overflow");
		}
		if ((front == -1) && (rear == -1))
	    {
	        front++;
	        rear++;
	        queue[rear] = data;
	        return true;
	    }    
	    else{
	    	insertWithPriority(data);
	    	rear++;
	    }
		return true;
	}
	/**
	 * 
	 * @param data
	 * @return
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
	 * 
	 * @return
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
	 * 
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
	 * 
	 */
	public int size(){
		return rear - front;
	}
	/**
	 * 
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
