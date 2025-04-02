package com.collection;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		System.out.println("Hello");

		priorityQueueDefault();
	}

	public static void priorityQueueDefault() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(1);
		priorityQueue.add(5);
		priorityQueue.add(2);
		priorityQueue.add(4);
		priorityQueue.add(3);

		while (!priorityQueue.isEmpty()) {
			Integer data = priorityQueue.poll();
			System.out.println(data);
		}
	}
}
