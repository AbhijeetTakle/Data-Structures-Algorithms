package problems.foundation;
import java.util.Scanner;
import java.util.Stack;

public class MatrixProblems {
	
	public int[][] create2DArray(int x, int y){
		
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[x][y];
		System.out.println(arr.length);
		System.out.print("Enter array = ");
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		scn.close();
		return arr;
		
	}
	
	public void print2DArray(int[][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	
	public void MatrixMultiplication(int[][] a, int[][] b) {
		
		if(a[0].length!=b.length) {
			System.out.println("Dimension doesnot match ("+a.length+"x"+a[0].length+") and ("+b.length+"x"+b[0].length+")");
		}
		int[][] mul = new int[a.length][b[0].length];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b[0].length; j++) {
				for(int k=0; k<b.length; k++) {
					mul[j][k] = a[i][k]*b[k][j];
				}
			}
		}
		print2DArray(mul);
		
	}
	
	public void waveTraversal(int[][] arr) {
		
//		int i = 0;
//		int j = 0;
		int trig = 1;
//		System.out.print(arr[i][j]+" ");
//		i++;
//		while(i<=arr.length-1 || j<=arr[0].length-1) {
//			if(j<=arr[0].length-1) {
//				System.out.print(arr[i][j]+" ");	
//			}
//			if(i==arr.length-1  || i==0) {
//				j++;
//				System.out.println();
//				if(j<=arr[0].length-1) {
//					System.out.print(arr[i][j]+" ");	
//				}
//				trig*=-1;
//			}
//			i+=trig;
//		}	
		for(int j=0; j<arr[0].length; j++) {
			for(int i=0; i<arr.length; i+=trig) {
				System.out.print(arr[i][j]+" ");
			}
			trig*=-1;
			System.out.println();
		}
	}
	
	public void allSubArrays(int[] a) {
		
		for(int i=0; i<a.length; i++) {
			Stack<Integer> st = new Stack<>();
			for(int j=i; j<a.length; j++) {
				st.push(a[j]);
				System.out.println(st);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		MatrixProblems mp = new MatrixProblems();
//		System.out.print("A = ");
////		int [][] a = mp.create2DArray(2, 3);
//		
//		Scanner scn = new Scanner(System.in);
//		int[][] a = new int[2][3];
//		for(int i=0; i<a.length; i++) {
//			for(int j=0; j<a[i].length; j++) {
//				System.out.print("Enter arr["+i+"]["+j+"] = ");
//				a[i][j] = scn.nextInt();
//			}
//		}
//		mp.print2DArray(a);
//		System.out.print("B = ");
////		int[][] b = mp.create2DArray(3, 4);
//		
//		int[][] b = new int[3][4];
//		for(int i=0; i<b.length; i++) {
//			for(int j=0; j<b[i].length; j++) {
//				System.out.print("Enter arr["+i+"]["+j+"] = ");
//				b[i][j] = scn.nextInt();
//			}
//		}
//		mp.print2DArray(b);
//		mp.MatrixMultiplication(a, b);
//		scn.close();
		
//		int[][] a =  mp.create2DArray(3, 4);
//		mp.waveTraversal(a);
		
		int[] a = { 1, 2, 3, 4 };
		mp.allSubArrays(a);
		
	}

}
