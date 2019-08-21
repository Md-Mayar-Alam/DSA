package com.collection;

import java.util.Scanner;

public class Queue {

	int arr[];		//used to store the data
	int front;		//front is used to delete i.e Dequeue
	int rear;		//rear is used to add i.e Enqueue
	int capacity;	//total capacity of the queue	
	int size;		//current size of the queue
	
	public Queue(int capacity){
		arr= new int[capacity];
		front= -1;
		rear= 0;
		this.capacity= capacity;
		size= 0;
	}

	boolean isEmpty() {
		return size == 0 ? true : false;
	}

	void enQueue(int data) {
		if(getSize() == getCapacity()) {
			System.out.println("Queue Overflow");
		}else {
			arr[++rear]= data; 
			size++;
		}
	}
	
	int deQueue() {
		if(front > rear) {
			System.out.println("Queue Underflow");
			return -1;
		}else {
			size--;
			return arr[front++];
		}
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the capacity of Queue");
		int capacity= sc.nextInt();
		
		Queue queue= new Queue(capacity);
		
		for(;;) {
			System.out.println("Enter");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Size");
			int choice= sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the data");
				int data= sc.nextInt();
				queue.enQueue(data);
				break;
			case 2:
				int deqData= queue.deQueue();
				System.out.println("Dequed data "+deqData);
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
