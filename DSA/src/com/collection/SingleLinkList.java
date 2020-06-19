package com.collection;

import java.util.Scanner;

public class SingleLinkList {
	
	class Node{
		Node next;
		int data;
	}
	
	Node root= null;

	public static void main(String a[]) {
		Scanner sc= new Scanner(System.in);
		SingleLinkList sl= new SingleLinkList();
		for(;;) {
			System.out.println("Enter");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Print");
			
			try {
				int choice= sc.nextInt();
				
				switch(choice) {
					case 1:
						sl.insert(sc);
						break;
					case 2:
						boolean found= sl.delete(sc);
						if(found) {
							System.out.println("Element deleted successfully");
						}else {
							System.out.println("Element not found");
						}
						break;
					case 3:
						sl.search();
						break;
					case 4: 
						sl.print();
						break;
					default:
						System.out.println("Wrong Choice");
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

	private void search() {

		
	}

	private boolean delete(Scanner sc) {
		try {
			System.out.println("Enter the element to delete ");
			int elementToDelete= sc.nextInt();
			
			if(root.data == elementToDelete) {	//for first node
				root= root.next;
				return true;
			}else {
				Node node= root;
				
				while(node.next != null) {	//for nodes from second to last
					if(node.next.data == elementToDelete && node.next.next == null) {
						node.next= null;
						return true;
					}else if(node.next.data == elementToDelete && node.next.next != null){
						node.next= node.next.next;
						return true;
					}
					node= node.next;
				}
			}
			return false;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private void print() {
		Node node= root;
		
		while(node.next != null) {
			System.out.print(node.data + " ");
			node= node.next;
		}
		System.out.print(node.data);
		System.out.println();
	}

	private void insert(Scanner sc) {
		System.out.println("Enter the element to insert ");
		try {
			int elementToInsert= sc.nextInt();
			
			Node node= new Node();
			node.data= elementToInsert;
			node.next= null;
			
			if(root == null) {
				root= node;
			}else {
				Node temp= root;
				while(temp.next != null) {
					temp= temp.next;
				}
				temp.next= node;
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
