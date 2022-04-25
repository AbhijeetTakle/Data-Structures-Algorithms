package singlylinkedlist;

public class SinglyLinkedList {
	public ListNode head;
	
	public static class ListNode {		
		public int data;
		public ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void display() {
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
	
	public int length() {
		if(head == null) {
			return 0;
		} 
		int count = 0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	public void addNodeAtFirst(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void addNodeAtLast(int data) {
		ListNode newNode = new ListNode(data);
		if(this.head == null) {
			this.head = newNode;
			return;
		}
		ListNode current = this.head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = newNode;
			
	}
	
	public void addNodeAtPos(int data, int pos) {
		ListNode newNode = new ListNode(data);
		if(pos == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}
		ListNode current = head;
		while(pos-1>1) {
			pos--;
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public ListNode removeNodeAtFirst() {
		 if(head==null) {
			 return null;
		 }
		 ListNode temp = head;
		 head = head.next;
		 temp.next = null;
		 
		 return temp;
	}
	
	public ListNode removeNodeAtLast() {
		if(this.length()<2) {
			head = null;
			return null;
		}
		ListNode current = head;
		while(current.next.next != null) {
			current = current.next;
		}
		ListNode temp = current.next;
		current.next = null;
		
		return temp;
	}
	
	public ListNode removeNodeAtPos(int pos) {
		if(length()<pos) {
			System.out.println("Given list is short for deletion.");
			return null;
		}
		if(length()<2) {
		    ListNode temp = head;
			head = null;
			return temp;
		}
		if(pos<2) {
			ListNode temp = head;
			head = head.next;
			temp.next = null; 
			return temp;
		}
		ListNode current = head;
		ListNode previous = null;
		while(pos-1>=1) {
			previous = current;
			current = current.next;
			pos--;
		}	
		previous.next = current.next;
		current.next = null;
		
		return current;
	}
	
	public int searchNode(int key) {
		if(head == null)
			return 0 ;
		ListNode current = head;
		int pos = 1;
		while(key != current.data) {
			pos++;
			current = current.next;
		}
		return pos;
	}
	
	public void reverseList() {
		ListNode current = head;
		ListNode previous = null;
		ListNode next = head.next;
		
		while(next != null) {
			current.next = previous;
			previous = current;
			current = next;
			next = next.next;
		}
		current.next = previous;
		head = current;
	}
	
	public void reverseLinkedList() {
		if(head == null) {
			System.out.println("List Is Empty.");
			return;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	public ListNode middleNode() {
		ListNode slowptr = head;
		ListNode fastptr = head;
		
		while(fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		return slowptr;
	}
	
	public ListNode nodeFromLast(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("invalid value of n.");
		}
		ListNode mainptr = head;
		ListNode refptr = head;
		while(n >= 1) {
			try {
				refptr = refptr.next;
			} catch(NullPointerException e){
				throw new IllegalArgumentException("invalid value of n.");
			}
			n--;
		}
		System.out.println(refptr);
		while(refptr != null) {
			refptr = refptr.next;
			mainptr = mainptr.next;
		}
		return mainptr;
	}
	
	public void removeDuplicates() {
		if(head == null) {
			System.out.println("List is too small.");
		}
		ListNode current =  head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}
			else {
				current = current.next; 
			}
		}
	}
	
	public void  insertNode(int data) {
		if(head == null) {
			addNodeAtLast(data);
			return;
		}
		ListNode newnode = new ListNode(data);
		ListNode current = head;
		ListNode temp = null;
		while(current != null && current.data < newnode.data) {
			temp = current;
			current = current.next;
		}
		if(temp == null) {
			head = newnode;
		}
		else {
			temp.next = newnode;
		}
		newnode.next = current;
	}
	
	public ListNode removeKey(int key) {
		if(head == null) {
			System.out.println("List is too small");
			return null;
		}
		ListNode current = head;
		ListNode temp = null;
		while(current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		if(current == null) {
			System.out.println("key not found.");
		}
		else if(temp == null) {
			head = current.next;
		}
		else {
			temp.next = current.next;
		}
		return current;
	}
	
    public static void main(String[] args) {
		 SinglyLinkedList sll = new SinglyLinkedList();
		 sll.addNodeAtLast(10);
		 sll.addNodeAtLast(20);
		 sll.addNodeAtLast(30);
		 sll.addNodeAtLast(40);
		 sll.addNodeAtLast(50);
		 sll.addNodeAtLast(60);
		 sll.addNodeAtPos(70, 7); 
		 sll.display();
//		 try {
//		 System.out.println(sll.removeNodeAtPos(1).data);
//		 } catch (NullPointerException e) {
//		 System.out.println("null");
//		 }
//		 sll.reverseList();
//		 sll.display();
//		 System.out.println(sll.searchNode(40));//		 
//		 System.out.println(sll.length());
//		 System.out.println(sll.middleNode().data);
//		 System.out.println(sll.nodeFromLast(8).data);
//		 sll.removeDuplicates();
//		 sll.insertNode(75);
		 sll.removeKey(80);
		 sll.display();
	     }

	}
