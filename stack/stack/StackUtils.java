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
	
	public static void main(String[] args) {
		StackUtils st = new StackUtils();
		String str = "ABCD";
		System.out.println(st.reverseString(str));

	}

}
