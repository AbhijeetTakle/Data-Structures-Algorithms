package algorithms;

import java.util.ArrayList;

public class Sorting {

	void displayArray(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
	}
	
	void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	void selectionSort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}				
			}
			swap(arr, min, i);
		}
		displayArray(arr);
		
	}
	
	void bubbleSort(int[] arr) {
		
		final int n = arr.length;
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i=0; i<n-1; i++) {
				if(arr[i]>arr[i+1]) {
					sorted = false;
					swap(arr, i, i+1);
				}
			}
		}
		displayArray(arr);
		
	}
	
	void insertionSort(int[] arr) {
		
		final int n = arr.length;
		for(int i=1; i<n; i++) {
			if(arr[i]<arr[i-1]) {
				int j=i;
				while((j-1)>=0 && arr[j]<arr[j-1]) {
					swap(arr, j-1, j);
					j--;
				}
			}
		}
		displayArray(arr);
		
	}
	
	int[] mergeSortedArray(int[] arr, int[] arr1) {
		
		int[] arr2 = new int[arr.length+arr1.length];
		int i=0, j=0, k=0;
		while(j<arr.length && k<arr1.length) {
			if(arr[j]<=arr1[k]) {
				arr2[i] = arr[j];
				j++;
			}else{
				arr2[i] = arr1[k];
				k++;
			}
			i++;
		}
		while(j<arr.length || k<arr1.length) {
			if(j<arr.length) {
				arr2[i] = arr[j];
				j++;
			}else {
				arr2[i] = arr1[k];
				k++;
			}
			i++;
		}
		return arr2;
		
	}
	
	int[] mergeSort(int[] arr, int i, int j) {
		
		if(i==j) {
			int[] arr1 = {arr[i]};
			return arr1;
		}
		int[] arr1 = mergeSort(arr, i, (i+j)/2);
		int[] arr2 = mergeSort(arr, ((i+j)/2)+1, j);
		return mergeSortedArray(arr2, arr1);
		
	}
	
	int partition(int[] arr, int l, int h) {
		
		int i = l;
		int j = h;
		while(i<j) {
			do {
				i++;
			}while(i<j && arr[l]>arr[i]);
			do {
				j--;
			}while(j>i && arr[l]<=arr[j]);
			if(i<j) {
				swap(arr, i, j);
			}
		}
		return j;
		
	}
	
	void quickSort(int[] arr, int l, int h) {
		
		
		if(l==(h-1)|| l==h) {
			return;
		}
		int j = partition(arr, l, h);
		displayArray(arr);
		quickSort(arr, l, j);
		quickSort(arr, j+1, h);
		
	}
	
	public static void main(String[] args) {
		
//		Sorting srt = new Sorting();
//		srt.selectionSort(new int[]{1, 2, 3, 4, 6, 5});
//		srt.bubbleSort(new int[]{1, 2, 3, 4, 6, 5});
//		srt.insertionSort(new int[]{1, 1, 1, 2, 1, 1});
//		srt.displayArray(srt.mergeSort(new int[]{1, 2, 3, 4, 6, 5}, 0, 5));
//		srt.quickSort(new int[]{9, 7, 3, 4, 6, 5}, 0, 6);
		ArrayList<Integer> mat = new ArrayList<>();
		mat.add(1);
		mat.add(2);
		mat.add(3);
		int x = 1;
				mat.set(2, x);
		System.out.println(mat.get(2));

	}

}
