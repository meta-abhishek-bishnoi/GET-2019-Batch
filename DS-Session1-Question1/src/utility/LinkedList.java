/**
 * @author Abhishek Bishnoi
 * @since Jul 29, 2019
 * This Class Provides Dynamic List as where,
 * it provides various methods like add, toString, substring, rotateSubstring etc etc
 */
package utility;

public class LinkedList {
	Node headNode=null;
	Node lastNode=null;
	/**
	 * This Function is used to Add Data into Node And Connecting them with Next Node 
	 * @param value : value to adding in node
	 * @return boolean: true or false for operation success or not
	 * @exception : when adding of element can't be done
	 */
	public boolean add(Node node){
		if(node==null){
			throw new AssertionError("Node Can't Be Null");
		}
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
	 * @param start
	 * @param end
	 * @return
	 */
	public void rotateSubList(int start, int end, int rotateIndex){
		Node currentNode = headNode;
		int nodeCount=1;
		int opeartionCount=0;
		validate(start,end,rotateIndex);
		if(rotateIndex > end-start){
			rotateIndex = rotateIndex%(end-start);
			if(rotateIndex == 0){
				rotateIndex = end-start;
			}
		}
		Node startCurrent=null;
		Node startLast=null;
		Node endCurrent=null;
		Node endLast=null;
		int currentStart = start;
		int currentEnd = end;
		while(true){
			if(opeartionCount>=rotateIndex || currentStart == currentEnd){
				//currentNode = headNode;
				break;
			}
			if(nodeCount == currentStart){
				startCurrent = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}else if(nodeCount<currentStart){
				startLast = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}else if(nodeCount == currentEnd){
				endCurrent = currentNode;
				endLast.next = endCurrent.next;
				startLast.next = endCurrent;
				endCurrent.next = startCurrent;
				currentNode = headNode;
				nodeCount=1;
				opeartionCount++;
					
			}else{
				endLast = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}
		}
		
		//return currentNode;
	}
	/**
	 * 
	 * @param start
	 * @param end
	 * @param rotateIndex
	 */
	private void validate(int start, int end, int rotateIndex) {
	    
		if(start <= 0){
			throw new AssertionError("Start Index Must Be Positive Number");
		}
		if(end >= size()){
			throw new AssertionError("end Index Must Be Less Then Size");
		}
		if(end < start){
			throw new AssertionError("end index can't be less then start index");
		}
	}
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
