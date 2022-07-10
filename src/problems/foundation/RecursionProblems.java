package problems.foundation;

import java.util.ArrayList;

public class RecursionProblems {
	
	public void printDecreasingOrder(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n+" ");
		printDecreasingOrder(n-1);
	}
	
	public void printIncreasingOrder(int n) {
		if(n==0) {
			return;
		}
		printIncreasingOrder(n-1);
		System.out.println(n+" ");
	}
	
	public void printDecreasingIncreasing(int n) {
		
		if(n==0) {
			return;
		}		
		System.out.println(n);
		printDecreasingIncreasing(n-1);
		System.out.println(n);
		
	}
	
	public int factorial(int n) {
		
		if(n==0) {
			return 1;
		}
		return n*factorial(n-1);
		
	}
	
	public int power(int x, int n) {
		
		if(n==0) {
			return 1;
		}
		return x*power(x, n-1);
		
	}
	
	public boolean mex(ArrayList<Integer> arr, int n) {
		
		arr.sort(null);
		int i=0;
		for(Integer num: arr) {
			if(num!=i) {
				if(n==i)
					return true;
			}
			i++;
		}
		return false;
	}
	

	public static void main(String[] args) {
		
		RecursionProblems rp = new RecursionProblems();
		
//		rp.printDecreasingOrder(5);
		
//		rp.printIncreasingOrder(5);
		
//		rp.printDecreasingIncreasing(5);
		
//		System.out.println(rp.factorial(5));
		
//		System.out.println(rp.power(2, 4));
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(0);
		arr.add(4);
		arr.add(3);
		ArrayList<Integer> arr1 = (ArrayList<Integer>)arr.clone();
		System.out.println(rp.mex(arr1, 3));
		System.out.println(arr);
		
	}

}
