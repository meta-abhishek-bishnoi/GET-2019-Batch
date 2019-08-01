/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * Assumption all queue values are non zero values
 */
package meta.utility;

public class CircularQueue implements Queue {
	int circularQueue[];
	int start,end,addIndex, deleteIndex;
	public CircularQueue(int size){
		circularQueue =new int[size];
		start = 0;
		addIndex=0;
		deleteIndex=0;
		end = size-1;
	}
	/**
	 *  This function is adding items to Queue
	 *  @param item: int value
	 *  @return boolean value for success or failure
	 *  @exception when queue is fill (Assertion Error)
	 */
	@Override
	public boolean add(int item) {
		if(!isFull()){
			circularQueue[addIndex]=item;
			if(addIndex==end){
				addIndex=0;
			}else{
				addIndex++;
			}
		}else{
			throw new AssertionError("Queue Is Full");
		}
		return true;
	}

	/**
	 * delete element from queue
	 * @exception Assertion Error when queue is empty
	 * @return boolean value for success or failure
	 */
	@Override
	public boolean delete() {
		if(!isEmpty()){
			circularQueue[deleteIndex]=0;
			if(deleteIndex==end){
				deleteIndex=0;
			}else{
				deleteIndex++;
			}
		}else{
			throw new AssertionError("Queue Is Empty");
		}
		return true;
	}

	/**
	 * this function is returns if queue is empty or not
	 * @return boolean value for success or failure
	 */
	@Override
	public boolean isEmpty() {
		for(int value: circularQueue){
			if(value!=0){
				return false;
			}
		}
		return false;
	}

	/**
	 * this function evolute is queue is full or not
	 * @return boolean value for success or failure
	 */
	@Override
	public boolean isFull() {
		for(int value: circularQueue){
			if(value==0){
				return false;
			}
		}
		return true;
	}

}
