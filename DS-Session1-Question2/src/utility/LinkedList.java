/**
 * @author Abhishek Bishnoi
 * @slowScale Jul 29, 2019
 * This Class Provides Dynamic List as where,
 * it provides various methods like add, toString, substring, rotateSubstring etc etc
 */
package utility;

public class LinkedList {
	Node headNode=null;
	Node lastNode=null;
	/**
	 * This Function is used to Add Data into Node And Connecting them with Next Node 
	 * @param node : Node to adding in List
	 * @return boolean: true or false for operation success or not
	 * @exception : when adding of element can't be done
	 */
	public boolean add(Node node){
		try{
			if(lastNode==null){
				headNode=node;
				lastNode=node;
			}else{
				lastNode.next = node;
				lastNode = node;
			}
			return true;
		}catch(Exception exception){
			throw new AssertionError("Error in Insertion");
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean isLoop(){
		Node currentNode = headNode;
		Node checkNode = null;
		int slowScale = 0;
		int fastScale = 2;
		do {
		   if (checkNode == currentNode) return true;
		   if (slowScale >= fastScale){
		      checkNode = currentNode;
		      slowScale = 0;
		      fastScale = 2*fastScale;
		   }
		   slowScale++;
		   currentNode = currentNode.next;
		 } while (currentNode!=null);
		  return false;
	}
	/**
	public boolean loop(){
		if(lastNode!=null){
			return true;
		}
		return false;
	}
	*/
	/**
	 * This Method returns All Linked List Values As String 
	 * @return String : list values in String
	 */
	public String toString(){
		Node current = headNode;
		StringBuffer toString = new StringBuffer();
		while(current!=null){
			toString.append(current.value+" ");
			current = current.next;
		}
		return toString.toString();
	}
	/**
	 * @return size of Linked List
	 */
	public int size(){
		int size=0;
		Node current = headNode;
		while(current!=null){
		    
			size++;
			current = current.next;
		}
		return size;
	}
	/**
	 * 
	 */
	public int[] toArray(){
		int size = size();
		int resultArray[] = new int[size];
		int index=0;
		Node current = headNode;
		while(current!=null){
			resultArray[index++]=current.value;
			current = current.next;
		}
		return resultArray;
	}
}
