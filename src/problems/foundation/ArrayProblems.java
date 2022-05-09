package problems.foundation;

import java.util.Scanner;

public class ArrayProblems {
	
	public void printBarChart(int n, int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		for(int i=max; i>0; i--) {
			for(int j=0; j<arr.length; j++) {
				if(arr[j]==i) {
					System.out.print("*");
					arr[j]-=1;
				}else {
					System.out.print(" ");
		 		}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("arr["+i+"] = ");
			arr[i] = scn.nextInt();
		}
		ArrayProblems arrp = new ArrayProblems();
		arrp.printBarChart(n, arr);
		
		scn.close();
	}

}
