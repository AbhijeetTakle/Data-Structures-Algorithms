package array.oneDarray;

import java.util.Scanner;

public class ArrayUtil {

	public void printArray(int[] arr) {
		System.out.print("=> ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	public int[] createArray(int n){
		Scanner sin = new Scanner(System.in);
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.print("<= ");
			arr[i] = sin.nextInt();
		}
		sin.close();
		return arr;				
	}
	
	public int[] reverseArray(int[] arr) {
		int i=0, j=arr.length -1;
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
	}
	
	public int findMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
				idx = i;
			}
		}
		System.out.print("minimum value is at index-"+ idx+" = ");
		return min;
	}
	
	public static void main(String[] args) {
		ArrayUtil array = new ArrayUtil();
		int[] arr = array.createArray(5);
		array.printArray(arr);
		array.reverseArray(arr);
//		array.printArray(arr);
		System.out.println(array.findMin(arr));
	}

}
