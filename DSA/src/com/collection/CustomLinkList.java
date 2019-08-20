package com.collection;

import java.util.HashSet;
import java.util.Scanner;

import com.exception.LinkListEmptyException;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}

class LinkList<T> {
	private Node<T> root;

	public LinkList() {
		root = null;
	}

	public void insertLast(T data) {
		if (root == null) {
			Node<T> node = new Node<T>(data);
			root = node;
		} else {
			Node<T> start = root;
			while (start.next != null) {
				start = start.next;
			}
			Node<T> node = new Node<T>(data);
			start.next = node;
		}
	}

	public void printAllNodes() {
		if (root == null) {
			System.out.println("No elements in LinkList");
		} else {
			Node<T> start = root;

			while (start != null) {
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}

	public boolean delete(T elementToRemove) {
		if (root == null) {
			throw new LinkListEmptyException("LinkList is empty");
		} else if (root.data == elementToRemove) {
			root = root.next;
			return true;
		} else {
			Node<T> start = root;

			while (start.next != null) {
				if (start.next.data == elementToRemove) {
					start.next = start.next.next;
					return true;
				}
				start = start.next;
			}
		}
		return false;
	}
	
	public void removeDuplicates() {
	
		HashSet<T> set= new HashSet<>();
		
		Node<T> start= root;
		set.add(start.data);
		
		while(start.next != null) {
			if(set.contains(start.next.data)) {
				start.next= start.next.next;
				continue;
			}else {
				set.add(start.next.data);
			}
			start= start.next;
		}
	}
}

public class CustomLinkList {

	public static void main(String args[]) {

		LinkList<Integer> ll = new LinkList<Integer>();

		Scanner sc = new Scanner(System.in);
		
		outerloop:
		for (;;) {
			System.out.println("Enter");
			System.out.println("1. Insert Last");
			System.out.println("2. Delete");
			System.out.println("3. Print");
			System.out.println("4. Remove Duplicates");
			System.out.println("5. Exit");

			try {
				int key = sc.nextInt();

				switch (key) {
				case 1:
					System.out.println("Please enter the data ");
					int data = sc.nextInt();
					ll.insertLast(data);

					break;
				case 2:
					System.out.println("Enter the element to delete");
					int elementToRemove = sc.nextInt();
					boolean isDeleted = ll.delete(elementToRemove);
					if (isDeleted) {
						System.out.println("Element deleted successfully");
					} else {
						System.out.println("Element doesn't exists");
					}

					break;
				case 3:
					ll.printAllNodes();
					break;
				case 4:
					ll.removeDuplicates();
					break;
				case 5:
					break outerloop;
				default:
					System.out.println("Invalid input");
					break;
				}
			} catch (Exception e) {
				System.out.println("Exception "+ e);
			}
		}

	}
}
