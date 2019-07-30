/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * Assumption all queue values are either positive or negative number
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
	 * 
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
			return false;
		}
		return true;
	}

	/**
	 * 
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
			return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		for(int value: circularQueue){
			if(value!=0){
				return false;
			}
		}
		return false;
	}

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
