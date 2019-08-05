package utility;

public class Dictonary  implements Comparable<Dictonary>{
	int key;
	String value;
	Dictonary left;
	Dictonary right;
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public Dictonary(int key, String value){
		this.key = key;
		this.value = value;
	}
	/**
	 * 
	 */

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public Dictonary getLeft() {
		return left;
	}

	public Dictonary getRight() {
		return right;
	}
	/**
	 * 
	 */
	@Override
	public int compareTo(Dictonary obj) {
		return this.key - obj.key;
	}
	/**
	 * complexity O(log n) avg case, O(n) worst case
	 * @param dictonary
	 * @return
	 */
	public boolean put(Dictonary dictonary){
		if(dictonary == null){
			throw new AssertionError("Null Object Can't Added Into Directory");
		}
		Dictonary current = this;
		while(true){
			if(dictonary.key < this.key){
				if(current.left == null){
					current.left = dictonary;
					break;
				}else{
					current = current.left;
				}
			}else{
				if(current.right == null){
					current.right = dictonary;
					break;
				}else{
					current = current.right;
				}
			}
		}
		return true;
	}
}
