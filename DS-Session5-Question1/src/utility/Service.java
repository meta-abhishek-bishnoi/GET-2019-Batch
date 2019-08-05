package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Service {
	Loader load = new Loader();
	Dictonary root;
	boolean isRootSet=false;
	/**
	 * 
	 * @return
	 */
	public boolean setMap(){
		BalancedTree bst = new BalancedTree();
		JSONArray elementList = load.loadJSON();
		// Adding Root Element
		JSONObject element = (JSONObject) elementList.get(0);
		JSONObject elementObject = (JSONObject) element.get("keyValue");
        Long key = (Long) elementObject.get("key");  
        String value = (String) elementObject.get("value"); 
        int intKey = (int) key.intValue();
		root = new Dictonary(intKey,value);
		isRootSet = true;
		// Adding Chlid Nodes
		for(int i=1; i<elementList.size(); i++){
			//System.out.println(i);
			element = (JSONObject) elementList.get(i);
			elementObject = (JSONObject) element.get("keyValue");
			key = (Long) elementObject.get("key");  
	        value = (String) elementObject.get("value"); 
	        intKey = (int) key.intValue();
	        //System.out.println(intKey+" "+value);
			root.put(new Dictonary(intKey,value));
		}
		// Creating Balance Tree
		root = bst.getBST(root);
		return true;
	}
	/**
	 * 
	 */
	public boolean deleteNode(int key){
		BalancedTree bst = new BalancedTree();
		root = bst.deleteKey(root, key);
		return true;
	}
	/**
	 * 
	 */
	public List<Dictonary> getSortedPair(){
		 List<Dictonary> list = new ArrayList<Dictonary>();
		 Queue<Dictonary> queue = new LinkedList<Dictonary>();
		 queue.add(root);
		 while(queue.size() != 0){
			Dictonary dic = queue.poll();
			list.add(dic);
			if(dic.getLeft() != null){
				queue.add(dic.getLeft());
			}
			if(dic.getRight() != null){
				queue.add(dic.getRight());
			}
		}
		Collections.sort(list);
		return list;
	}
	/**
	 * 
	 */
	public List<Dictonary> getSortedPair(int k1, int k2){
		 List<Dictonary> list = new ArrayList<Dictonary>();
		 Queue<Dictonary> queue = new LinkedList<Dictonary>();
		 queue.add(root);
		 while(queue.size() != 0){
			Dictonary dic = queue.poll();
			if( dic.getKey() >= k1 && dic.getKey() <= k2){
				list.add(dic);
			}
			if(dic.getLeft() != null){
				queue.add(dic.getLeft());
			}
			if(dic.getRight() != null){
				queue.add(dic.getRight());
			}
		}
		Collections.sort(list);
		return list;
	}
	/**
	 * 
	 */
	public String get(int key){
		Dictonary current = root;
		while(current!=null){
			if(current.getKey()==key){
				return current.getValue();
			}else if(key < current.getKey()){
				current = current.left;
			}
			else{
				current = current.right;
			}
		}
		return "No Value Found";
	}
	/**
	 * 
	 */
	public Dictonary getMap(){
		return root;
	}
	
}
