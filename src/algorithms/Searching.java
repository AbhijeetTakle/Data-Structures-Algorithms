package algorithms;

import java.util.ArrayList;

public class Searching {

	
	int linearSearch(int[] arr, int key) {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==key) {
				return i+1;
			}
		}
		return -1;
		
	}
	
	int recursiveLinearSearch(int[] arr, int key, int i) {
		
		if(i>arr.length-1) {
			return -1;
		}
		if(arr[i]==key) {
			return i+1;
		}
		int n = recursiveLinearSearch(arr, key, i+1);
		return n;
	
	}
	
	int binarySearch(int[] arr, int key) {
		
		int low=0, high=arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]==key) {
				return mid+1;
			}else if(key<arr[mid]) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
		
	}
	
	int recursiveBinarySearch(int[] arr, int key, int low, int high) {
		
		int mid = (low+high)/2;
		if(low>high) {
			return -1;
		}
		if(arr[mid]==key) {
			return mid+1;
		}else if(key<arr[mid]) {
			high=mid-1;
		}else {
			low=mid+1;
		}
		int n = recursiveBinarySearch(arr, key, low, high);
		return n;
		
	}
	public static void setZeros(int matrix[][]) {
        int[] rowz = new int[matrix.length];
        int[] colz = new int[matrix[0].length];
        for( int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    rowz[i] = 1;
                    colz[j] = 1;
                }
            }
        }
        for( int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(rowz[i]!=1 && colz[j]!=1){
                    System.out.print(matrix[i][j]+" ");
                }else{
                    System.out.print(0+" ");
                }
            }
            System.out.println("");
        }
    }
	
	public static void main(String[] args) {
		
		long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Searching srch = new Searching();
//		System.out.println(srch.linearSearch(arr, 5));
//		System.out.println(srch.recursiveLinearSearch(arr, 5, 0));
//		System.out.println(srch.binarySearch(arr, 0));
//		System.out.println(srch.recursiveBinarySearch(arr, 0, 0, arr.length-1));
		


	}

}
