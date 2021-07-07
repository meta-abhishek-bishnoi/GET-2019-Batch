/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 * This is Generic Stack with opearions like push() pop() isEmpty() isFull()
 */
package utility;

import java.util.ArrayList;
import java.util.List;

public class Stack<T extends Object> {
 
    private List<T> stack;
     
    /**
     * constructor to create stack with size
     * @param size
     */
    public Stack() {
        this.stack = new ArrayList<T>();
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(T entry){
        this.stack.add(entry);
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public T pop(){
        if(this.isStackEmpty()){
            throw new AssertionError("Stack is empty");
        }
        T entry = this.stack.get(stack.size()-1);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public T peek() {
        return stack.get(stack.size()-1);
    }
    
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return stack.size()==0;
    }
 
}