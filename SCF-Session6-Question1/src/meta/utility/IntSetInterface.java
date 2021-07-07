/*
 * This is Interface Class Defining Structure for IntSet
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 21-JUly-2019
 */
package meta.utility;

public interface IntSetInterface {
	public boolean isMember( int x );
	public int size();
	public boolean isSubSet( IntSet subSet );
	public IntSet getCompliment(IntSet set);
	public IntSet union( IntSet set1, IntSet set2 );
}
