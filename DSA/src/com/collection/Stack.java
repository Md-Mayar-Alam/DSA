package com.collection;

import java.util.Scanner;

public class Stack {

	private int arr[];
	private int capacity;
	private int top;
	
	public Stack(int capacity) {
		this.capacity= capacity;
		arr= new int[capacity];
		top= -1;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter capacity of stack");
		int capacity= sc.nextInt();
		
		Stack stack= new Stack(capacity);
		
		outer:
		for(;;) {
			System.out.println("Enter :");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			
			int input= sc.nextInt();
			
			switch(input) {
				case 1:
						System.out.println("Enter the data to push ");
						int data= sc.nextInt();
						stack.push(data);
					break;
				case 2:
						int poppedElement= stack.pop();
						if(poppedElement != -1) {
							System.out.println("Element "+ poppedElement +" popped successfully");
						}
					break;
				case 3:
						stack.display();
					break;
				case 4:
					break outer;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

	private void display() {
		if(top == -1) {
			System.out.println("Stack Underflow");
		}else {
			for(int i=0; i<= top; i++) {
				System.out.println(arr[i]);
			}
		}
	}

	private void push(int data) {
		if(isFull()) {
			System.out.println("Stack overflow");
		}else {
			top++;
			System.out.println("Inserting "+ data);
			arr[top]= data;
		}
	}
	
	private int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow");
			return -1;
		}
		System.out.println("Removing "+ arr[top]);
		return arr[top--];
	}

	private boolean isEmpty() {
		return top == -1;
	}

	private boolean isFull() {
		/*if(top == capacity -1)return true;
		else return false;*/
		
		return top == capacity -1;
	}
}
