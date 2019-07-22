package meta.utility;

public interface IntSetInterface {
	public boolean isMember( int x );
	public int size();
	public boolean isSubSet( IntSet subSet );
	public IntSet getCompliment();
	public IntSet union( IntSet set1, IntSet set2 );
}
