/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 * 
 */
package meta.utility;

public interface Queue {
	public boolean add(int item);
	public boolean delete();
	public boolean isEmpty();
	public boolean isFull();
}
