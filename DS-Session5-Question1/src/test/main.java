/**
 * @author Abhishek Bishnoi
 * @since Aug 5, 2019
 */
package test;

import java.util.LinkedList;
import java.util.Queue;

import utility.BalancedTree;
import utility.Dictonary;
import utility.Service;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BalancedTree bst = new BalancedTree();
		Service service = new Service();
		service.setMap();
		Dictonary root = service.getMap();
		Queue<Dictonary> queue = new LinkedList<Dictonary>();
		queue.add(root);
		while(queue.size() != 0){
			Dictonary dic = queue.poll();
			System.out.print(dic.getKey()+" ");
			if(dic.getLeft() != null){
				queue.add(dic.getLeft());
			}
			if(dic.getRight() != null){
				queue.add(dic.getRight());
			}
		}
		System.out.println("\n"+service.get(15));
		service.deleteNode(15);
		System.out.println();
		root = service.getMap();
		queue = new LinkedList<Dictonary>();
		queue.add(root);
		while(queue.size() != 0){
			Dictonary dic = queue.poll();
			System.out.print(dic.getKey()+" ");
			if(dic.getLeft() != null){
				queue.add(dic.getLeft());
			}
			if(dic.getRight() != null){
				queue.add(dic.getRight());
			}
		}
	}

}
