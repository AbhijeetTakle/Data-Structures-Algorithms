package stack;
import java.util.Stack;

public class StackUtils {

	public String reverseString(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		
		for(char c: chars) {
			stack.push(c);
		}
		
		for(int i=0; i<str.length(); i++) {
			chars[i] = stack.pop();
		}
		str = new String(chars);
		
		return str;
		
	}
	
	public int[] nextGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] result = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			if(!st.isEmpty()) {
				while(!st.isEmpty() && st.peek()<=arr[i]) {
					st.pop();
				}
			}
			if(st.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = st.peek();
			}
			st.push(arr[i]);
		}
		st.sort(null);
		return result;
	}
	
	
	
	public static void main(String[] args) {
		StackUtils st = new StackUtils();
		String str = "ABCD";
		System.out.println(st.reverseString(str));
		int[] arr = {4,7,3,4,8,1};
		for(int a: st.nextGreaterElement(arr)) {
			System.out.print(a);
		}
		
	}

}
