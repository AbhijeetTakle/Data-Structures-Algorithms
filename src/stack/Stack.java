package stack;
import java.util.EmptyStackException;

public class Stack {
	
	public ListNode top;
	public int length;
	
	private class ListNode{
		public int data;
		public ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public void push(int val) {
		ListNode newnode = new ListNode(val);
		newnode.next = top;
		top = newnode;		
		length++;
	}
	
	public ListNode pop() {
		if(top == null) {
			return null;
		}
		ListNode current = top;
		top = top.next;
		current.next = null;
		length--;
		return current;
	}
	
	public int peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public void display() {
		ListNode current = top;
		while(current != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println(current);
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.display();
		System.out.println(st.pop().data);
		System.out.println(st.pop().data);
		st.display();
		System.out.println(st.peek());
		
	}

}
