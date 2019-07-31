/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 */
package meta.utility;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> implements Queue {
	List<Object> queue = new ArrayList<Object>();

	@Override
	public boolean add( Object t ) {
		if( t == null ){
			throw new  AssertionError("Null Can't Be Add");
		}else{
			queue.add(t);
		}
		return true;
	}

	@Override
	public boolean delete() {
		if(size()==0){
			throw new  AssertionError("Null Can't Be Remove");
		}else{
			queue.remove(0);
		}
		return false;
	}

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
	
	@Override
	public int size() {
		return queue.size();
	}

}
