/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 * This Interface For Generic Type Queue
 */
package meta.utility;

public interface Queue<T> {
	public boolean add (T t);
	public boolean delete();
	public T remove();
	public int size();
}
