package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BalancedTree {
	public Dictonary getBST(Dictonary root)  
    { 
        // Store nodes of given BST in sorted order 
        List<Dictonary> nodes = new ArrayList<Dictonary>(); 
        // n logn
        storeBSTNodes(root, nodes); 
        // n logn 
        Collections.sort(nodes);
        // Constucts BST from nodes[] 
        int n = nodes.size(); 
        return buildTree(nodes, 0, n - 1); 
    } 
	public void storeBSTNodes(Dictonary root, List<Dictonary> nodes)  
	{ 
	    // Base case 
	    if (root == null) 
	          return; 
	    // Store nodes in Inorder (which is sorted order for BST) 
	    storeBSTNodes(root.left, nodes); 
	    nodes.add(root); 
	    storeBSTNodes(root.right, nodes); 
	} 
	Dictonary buildTree(List<Dictonary> nodes, int start, int end)  
	{ 
	     // base case 
	     if (start > end) 
	        return null; 
	  
	     /* Get the middle element and make it root */
	     int mid = (start + end) / 2; 
	     Dictonary node = nodes.get(mid); 
	  
	     /* Using index in Inorder traversal, construct left and right subtress */
	     node.left = buildTree(nodes, start, mid - 1); 
	     node.right = buildTree(nodes, mid + 1, end); 
	  
	     return node; 
	 }
	/**
	 * 
	 */
	public Dictonary deleteKey(Dictonary root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteKey(root.left, key); 
        else if (key > root.key) 
            root.right = deleteKey(root.right, key); 
  
        // if key is same as root's key, then This is the node to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteKey(root.right, root.key); 
        } 
  
        return root; 
    } 
  
    public int minValue(Dictonary root) 
    { 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
}
