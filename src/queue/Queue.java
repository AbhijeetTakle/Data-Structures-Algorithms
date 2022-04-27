package queue;

public class Queue {

	public ListNode front;
	public ListNode rear;
	
	public static class ListNode {
		public int data;
		public ListNode next;
		
		public ListNode(int val) {
			this.data = val;
		}
	}
	
	public void enqueue(int val) {
		ListNode newnode = new ListNode(val);
		if(front == null) {
			front = newnode;
			rear = newnode;
			return;
		}
		rear.next = newnode;
		rear = newnode;
	}
	
	public ListNode dequeue() {
		if(front == null) {
			return null;
		}
		ListNode current = front;
		front = front.next;
		current.next = null;
		if(front == null) {
			rear = null;
		}
		return current;
	}
	
	public void display() {
		if(this.front == null) {
			return;
		} 
		ListNode current = this.front;
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		Queue que = new Queue();
		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		que.enqueue(4);
		que.enqueue(5);
		que.display();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.enqueue(1);
		que.display();
	}

}
