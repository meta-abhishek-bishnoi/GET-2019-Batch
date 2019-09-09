/*
 * Abstract implementation of singly linked list
 */
package utility;

import java.util.ArrayList;
import java.util.List;

public class AbstractLinkedList {
    private Node start;
    
    public void setStart(Node start) {
        this.start = start;
    }
    
    /**
     * get List
     * @param start node
     */
    public List<Integer> getList(Node start){
        Node currentNode = start;
        List<Integer> result = new ArrayList<Integer>();
        while(currentNode != null){
           result.add(currentNode.getValue());
        }
        
        return result;
    }
}