package com.collection;

public class BT {

	static Node root;
	
	static class Node{
		Node lc;
		char data;
		Node rc;
		
		public Node(){
			
		}
		
		public Node(Node lc, char data, Node rc) {
			this.lc= lc;
			this.data= data;
			this.rc= rc;
		}
	}
	
	public static void main(String args[]) {
		
		//Inserting data in BT
		Node nodeA= new Node(null, 'A', null);
		root= nodeA;
		Node nodeB= new Node(null, 'B', null);
		nodeA.lc= nodeB;
		Node nodeC= new Node(null, 'C', null);
		nodeA.rc= nodeC;
		Node nodeD= new Node(null, 'D', null);
		nodeB.lc= nodeD;
		Node nodeE= new Node(null, 'E', null);
		nodeB.rc= nodeE;
		Node nodeF= new Node(null, 'F', null);
		nodeC.lc= nodeF;
		Node nodeG= new Node(null, 'G', null);
		nodeC.rc= nodeG;
		Node nodeH= new Node(null, 'H', null);
		nodeD.rc= nodeH;
		
		//Traverse
		
		//1. Preorder Traversal
		Node preTemp= root;
		preorder(preTemp);
		
		System.out.println();
		
		Node inTemp= root;
		inorder(inTemp);
		
		System.out.println();
		
		Node postTemp= root;
		postorder(postTemp);
	}
	
	/*
	 * preorder conditions
	 * 1. Visit the root node
	 * 2. Visit the left subtree of root in preorder
	 * 3. Visit the right subtree of root in preorder
	 */
	
	static void preorder(Node node){
		
		if(node!= null) {
			System.out.print(node.data+ " ");
			preorder(node.lc);
			preorder(node.rc);
		}
	}
	
	/*
	 * inorder conditions
	 * 1. Visit the left subtree of root in inorder
	 * 2. Visit the root 
	 * 3. Visit the right subtree of root in inorder 
	 */
	
	static void inorder(Node node) {
		if(node != null) {
			inorder(node.lc);
			System.out.print(node.data+ " ");
			inorder(node.rc);
		}
	}
	
	/*
	 * Conditions for postorder
	 * 1. Visit the left subtree of root in postorder
	 * 2. Visit the right subtree of root in preorder
	 * 3. Visit the root
	 */
	
	static void postorder(Node node) {
		if(node != null) {
			postorder(node.lc);
			postorder(node.rc);
			System.out.print(node.data + " ");	
		}
	}
}








