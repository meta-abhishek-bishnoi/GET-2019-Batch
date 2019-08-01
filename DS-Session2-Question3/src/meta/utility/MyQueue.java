/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 * This Is Generic Queue with some functionalities like add() delete () remove etc etc
 */
package meta.utility;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> implements Queue {
	List<Object> queue = new ArrayList<Object>();

	/**
	 * This Function Add Objects to List
	 * @param t: Object to adding into queue
	 * @return boolean value
	 * @exception Assertion Error when Object is null
	 */
	@Override
	public boolean add( Object t ) {
		if( t == null ){
			throw new  AssertionError("Null Can't Be Add");
		}else{
			queue.add(t);
		}
		return true;
	}

	/**
	 * This Function delete First Object From Queue 
	 */
	@Override
	public boolean delete() {
		if(size()==0){
			throw new  AssertionError("Null Can't Be Remove");
		}else{
			queue.remove(0);
		}
		return false;
	}

	/**
	 * This Function delete and return Object
	 * @return Object (Removed)
	 */
	@Override
	public T remove() {
		Object object;
		if(size() == 0){
			throw new  AssertionError("Null Can't Be remove");
		}else{
			object = queue.get(0);
			queue.remove(0);
		}
		return (T)object;
	}
	
	/**
	 * @return size of Queue
	 */
	@Override
	public int size() {
		return queue.size();
	}

	/**
	 * @param index
	 * @return Object At index
	 */
	public T get(int index){
		return (T) queue.get(index);
	}

}
