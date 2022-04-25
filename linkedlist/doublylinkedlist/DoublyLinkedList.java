package doublylinkedlist;

public class DoublyLinkedList {

	public ListNode head;
	public ListNode tail;
	public int length;
	
	public static class ListNode {
		public int data;
		public ListNode previous;
		public ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void displayFromStart() {
		if(this.head == null) {
			return;
		} 
		ListNode current = this.head;
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void displayFromLast() {
		if(this.tail == null) {
			return;
		} 
		ListNode current = this.tail;
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.previous;
		}
		System.out.println("null");
	}
	
	public void insertNodeAtStart(int data) {
		ListNode newnode = new ListNode(data);
		length++;
		if(head == null) {
			tail = newnode;
		}else {
		head.previous = newnode;
		}
		newnode.next = head;
		head = newnode;
		
	}
	
	public void insertNodeAtLast(int data) {
		ListNode newnode = new ListNode(data);
		length++;
		if(head == null) {
			head = newnode;
		}
		else {
			tail.next = newnode;
		}
		newnode.previous = tail;
		tail = newnode;

	}
	
	public ListNode removeFirstNode() {
		ListNode current = head;
		if(head != null) {
			length--;
			head = head.next;
			head.previous = null;
		}
		return current;
	}
	
	public ListNode removeLastNode() {
		ListNode current = tail;
		if(head != null) {
			length--;
			tail = tail.previous;
			tail.next = null;
		}
		return current;
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertNodeAtLast(10);
		dll.insertNodeAtLast(20);
		dll.insertNodeAtLast(30);
		dll.insertNodeAtLast(40);
		dll.insertNodeAtLast(50);
		dll.insertNodeAtLast(60);
		try {
			System.out.println(dll.removeLastNode());
		}catch(NullPointerException e){
			System.out.println("null");
		}
		dll.displayFromStart();
		dll.displayFromLast();		
	}

}
