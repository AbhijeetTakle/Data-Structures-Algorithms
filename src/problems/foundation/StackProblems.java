package problems.foundation;

import java.util.Scanner; 
import java.util.Stack;

public class StackProblems {

	public boolean duplicateBrackets(String s) {
		char[] chars = s.toCharArray();
		char d;
		Stack<Character> st = new Stack<>();
		for(char ch: chars) {
			if(ch ==')' || ch =='}' || ch ==']') {
				d = st.peek();
				if(d=='{' || d=='[' || d=='(') {
					return true;
				}else {
					while(d!='{' && d!='[' && d!='(') {
						d = st.pop();
					}
				}
			}else {
				st.push(ch);
			}
		}
		return false;
	}
	
	public boolean blancedBrackets(String s) {
		char[] chars = s.toCharArray();
		char d;
		Stack<Character> st = new Stack<>();
		for(char ch: chars) {
			System.out.println(st);
			if(ch ==')' || ch =='}' || ch ==']') {
				d = ch;
				while(((ch ==')')&&(d!='(')) || ((ch =='}')&&(d!='{')) || ((ch ==']')&&(d!='['))){
					if(st.isEmpty()) {
						return false;
					}
					d = st.pop();
				}
			}else if(ch =='(' || ch =='{' || ch =='[') {				
				st.push(ch);
			}else {
				if(!st.isEmpty()) {
					st.push(ch);
				}
			}
		}if(st.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void printNextGreaterRight(int[] arr) {
		Stack<Integer> st = new Stack<>();
		for(int i=arr.length-1; i>=0; i--) {
			while(!st.isEmpty() && arr[i]>st.peek()) {
				st.pop();
			}
			if(!st.isEmpty()) {
				System.out.print(st.peek()+" ");
			}else {
				System.out.print(-1+" ");
			}
			st.push(arr[i]);
		}
	}
	
	public int[] nextGreaterRight(int[] arr) {
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i=1; i<arr.length; i++) {
			while(!st.isEmpty()&&arr[i]>arr[st.peek()]) {
				nge[st.pop()] = arr[i];
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			nge[st.pop()] = -1;
		}
		return nge;
	}
	
	public void stockSpan(int[] arr) {
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			while(!st.isEmpty()&&arr[i]>arr[st.peek()-1]) {
				st.pop();
			}
			if(!st.isEmpty()) {
				System.out.print(st.peek()+" ");
			}else {
				System.out.print(i+1+" ");
			}
			st.push(i+1);
		}
	}
	
	public int[] nextSmallerRight(int[] arr) {
		int[] nse  = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
				nse[st.pop()] = i;
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			nse[st.pop()] = arr.length;
		}
		return nse;
	}	

	public int[] nextSmallerLeft(int[] arr) {
		int[] nse  = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for(int i=arr.length-1; i>=0; i--) {
			while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
				nse[st.pop()] = i;
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			nse[st.pop()] = -1;
		}
		return nse;
	}
	
	public int largestAreaHistogram(int[] arr) {
		int[] lb = nextSmallerLeft(arr);
		int[] rb = nextSmallerRight(arr);
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			int area = arr[i]*(rb[i]-lb[i]-1);
			if(max<area) {
				max = area;
			}
		}
		return max;
	}
	
	public void slidingWindowMaximum(int[] arr, int k) {
		int[] nge = nextGreaterRight(arr);
		int j=0;
//		int[] sw = new int[arr.length-k+1];
		for(int i=0; i<=arr.length-k; i++) {
			if(i>j) {
				j=i;
			}
			while(nge[j]<i+k) {
				j=nge[j];
			}
			System.out.println(arr[j]);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StackProblems stp = new StackProblems();
		
//		String s = scn.nextLine();
//		System.out.println(stp.duplicateBrackets(s));
		

//		String s = scn.nextLine();
//		System.out.println(stp.blancedBrackets(s));
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		stp.printNextGreaterRight(arr);
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		int[] res = stp.printNextGreaterRightAlt(arr);
//		for(int i=0; i<res.length; i++) {
//			System.out.print(res[i]+" ");
//		}
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		stp.stockSpan(arr);
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		int k = scn.nextInt();
//		stp.slidingWindowMaximum(arr, k);
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		int[] res = stp.nextSmallerRight(arr);
//		for(int i=0; i<res.length; i++) {
//			System.out.print(res[i]+" ");
//		}
		
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		int[] res = stp.nextSmallerLeft(arr);
//		for(int i=0; i<res.length; i++) {
//			System.out.print(res[i]+" ");
		
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(stp.largestAreaHistogram(arr));
		
		
		
		scn.close();
	}

}
