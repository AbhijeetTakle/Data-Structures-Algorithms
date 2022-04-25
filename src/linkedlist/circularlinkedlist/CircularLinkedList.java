package linkedlist.circularlinkedlist;

public class CircularLinkedList {
	
	public ListNode last;
	
	public static class ListNode{
		public int data;
		public ListNode next;
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	private void insertNode(int data) {
		ListNode newnode = new ListNode(data);
		if(last == null) {
			newnode.next = newnode;
			last = newnode;
			return;
		}
		newnode.next = last.next;
		last.next = newnode;
	}
	
	public void addNodeAtStart(int data) {
		insertNode(data);
	}
	
	public void addNodeAtLast(int data) {
		insertNode(data);
		last = last.next;
	}	
	
	public void display() {
		if(last == null) {
			return;
		}
		ListNode current = last.next;
		while(current != last) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println(current.data+" -> head");		
	}
	
	public ListNode removeNodeFromStart() {
		if(last == null) {
			return null;
		}
		ListNode temp = last.next;
		last.next = last.next.next;
		return temp;
	}
	
	public ListNode removeNodeFromLast() {
		if (last == null) {
			return null;
		}
		ListNode current = last.next;
		while(current.next != last) {
			current = current.next;
		}
		ListNode temp = last;
		current.next = last.next;
		last = current;
		return temp;
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addNodeAtLast(1);
		cll.addNodeAtLast(2);
		cll.addNodeAtLast(3);
		cll.addNodeAtLast(4);
		cll.addNodeAtLast(5);
		cll.addNodeAtLast(6);
		cll.display();
		cll.removeNodeFromLast();
		cll.display();
	}

}
