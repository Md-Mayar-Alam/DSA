package com.sorting;

public class QuickSort {
	
	public static void main(String args[]) {
		int a[]= {10, 7, 8, 9, 1, 5}; 
		
		int length= a.length;
		
		quickSort(a, 0, length-1);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+ " ");
		}
	}

	private static void quickSort(int[] a, int low, int high) {
		if(low < high) {
			int pivotPosn= partition(a, low, high);
			quickSort(a, low, pivotPosn-1);
			quickSort(a, pivotPosn+1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		
		int pivot= a[high];
		
		int i= low - 1;
		
		for(int j=low; j<= high; j++) {
			if(a[j] < pivot) {
				i++;
				int temp= a[i];
				a[i]= a[j];
				a[j]= temp;
			}
		}
		
		i++;
		int temp= a[i];
		a[i]= a[high];
		a[high]= temp;
		
		return i;
	}
}
