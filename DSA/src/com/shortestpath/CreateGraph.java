package com.shortestpath;

import java.util.Arrays;
import java.util.Scanner;

public class CreateGraph {

	static int noOFNodes;
	static int arr[][];
	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		createGraph();
		
		while(true) {
			System.out.println("Enter");
			System.out.println("1. Insert a node");
			System.out.println("2. Insert an edge");
			System.out.println("3. Delete a node");
			System.out.println("4. Delete an edge");
			System.out.println("5. Display");
			System.out.println("6. Exit");
			
			int choice= sc.nextInt();
			
			switch (choice) {
			case 1:
				insertNode();
				break;
			case 2:
				System.out.println("Enter an edge to be inserted");
				int origin= sc.nextInt();
				int destin= sc.nextInt();
				insertEdge(origin, destin);
			break;
			case 3:
				System.out.println("Enter the node to delete");
				int node= sc.nextInt();
				deleteNode(node);
			break;
			case 4:
				insertNode();
			break;
			case 5:
				insertNode();
			break;
			case 6:
				insertNode();
			break;
			
			default:
				break;
			}
		}
		
		
		
	}
	
	private static void createGraph() {
		System.out.println("Enter the no of Nodes");
		
		noOFNodes= sc.nextInt();
		arr= new int[noOFNodes][noOFNodes];
		
		int maxEdges= noOFNodes * (noOFNodes - 1);
		
		for(int i=1; i< maxEdges; i++) {
			System.out.println("Enter edge "+ i + " 0 0 to quit");
			int origin= sc.nextInt();
			int destin= sc.nextInt();
			
			if(origin == 0 && destin == 0) {
				break;
			}
			
			if(origin >= noOFNodes || destin >= noOFNodes || origin < 0 || destin < 0) {
				System.out.println("Invalid Edge");
				i--;
			}
			arr[origin][destin]= 1;
		}
	}/*End of createGraph() */
	
	private static void insertNode() {
		
		int newArr[][]= new int[noOFNodes+1][noOFNodes+1];
		
		for(int i=0; i< noOFNodes; i++) {
			/* Copying one by one rows from arr to newArr */
			
			newArr[i]= Arrays.copyOf(arr[i], noOFNodes+1);
		}
		arr= newArr;
		noOFNodes++;
	}

	private static void insertEdge(int origin, int destin) {
		if(origin > noOFNodes || origin < 0) {
			System.out.println("Source node doesn't exists");
		}
		
		if(destin > noOFNodes || destin < 0) {
			System.out.println("Destination node doesn't exists");
		}
		
		arr[origin][destin]= 1;
	}

	private static void deleteNode(int node) {
		for(int i= node-1; i< noOFNodes-1; i++) {
			for(int j= 0; j< noOFNodes; j++) {
				arr[i][j]= arr[i+1][j];
				arr[j][i]= arr[j][i+1];
			}
		}
		noOFNodes--;
	}

	
}
