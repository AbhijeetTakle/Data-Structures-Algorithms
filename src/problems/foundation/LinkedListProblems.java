package problems.foundation;

import java.util.Queue;
import java.util.Stack;

//import java.util.Iterator;
import java.util.LinkedList;
//import java.util.ListIterator;

public class LinkedListProblems {
	public class Linkedlist{ 
		private ListNode head;
		private ListNode tail;
		private int size;
		public Linkedlist() {
			this.size = 0;
		}
	}	
	
	public class ListNode{
		int data;
		ListNode next;
		
		private ListNode(int val) {
			this.data = val;
		}
	}
	
	public void addNodeAtLast(Linkedlist list, int val) {
		ListNode newnode = new ListNode(val);
		list.size++;
		if(list.head == null) {
			list.head = list.tail = newnode;
			return;
		}
		list.tail = list.tail.next = newnode;

	}
	
	public void displayLinkedlist(Linkedlist list) {
		ListNode current = list.head;
		while(current.next != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}
	
	public int size(Linkedlist list) {
		
		return list.size;
	}
	
	public void reverseLinkedlist(Linkedlist list) {
		ListNode current = list.head;
		ListNode previous = null;
		ListNode next = current.next;
		while(current != null) {
			current.next = previous;
			previous = current;
			current = next;
			try {
				next = next.next;
			}catch(NullPointerException  e) {
				break;
			}
		}
		list.tail = list.head;
		list.head = previous;
		
	}
	
	public int kthNodeFromEnd(Linkedlist list,int k) {
		ListNode current = list.head;
		ListNode kthelement =list.head;
		int d=0;
		while(kthelement.next != null) {
			if(d == k) {
				current = current.next;
			}else {				
				d++;
			}
			kthelement = kthelement.next;
		}
		if(d!=k) {
			return -1;
		}
		return current.data;
	}
	
	public ListNode middleNode(Linkedlist list) {
		ListNode current = list.head;
		ListNode doublenext = list.head;
		doublenext = doublenext.next;
		
		while(doublenext != null && doublenext.next != null) {
		current = current.next;
		try {
			doublenext = doublenext.next.next;
		}catch(NullPointerException e) {
			break;
		}
		}
		return current;
	}
	
	public Linkedlist mergeTwoList(Linkedlist list1, Linkedlist list2) {
		ListNode itr1 = list1.head;
		ListNode itr2 = list2.head;
		
		Linkedlist list3 = new Linkedlist();
		ListNode itr3;
		
		if(itr1.data <= itr2.data) {
			list3.head = itr3 = itr1;
			itr1 = itr1.next;
		}else {
			list3.head = itr3 = itr2;
			itr2 = itr2.next;
		}
		
		while(itr1 != null && itr2 != null) {
			if(itr1.data <= itr2.data) {
				itr3.next = itr1;
				itr1 = itr1.next;
			}else {
				itr3.next = itr2;
				itr2 = itr2.next;
			}
			itr3 = itr3.next;
		}
		if(itr1 == null) {
			itr3.next = itr2;
			list3.tail = list2.tail;
			
		}else {
			itr3.next = itr1;
			list3.tail = list1.tail;
		}
		list3.size = list1.size + list2.size;
		return list3;
	}
	
	public Linkedlist mergeSortLinkedList(Linkedlist list) {
		if(list.head == list.tail) {
			return list;
		}
		
		Linkedlist list2 = new Linkedlist();
		ListNode midnode = middleNode(list);
		list2.tail = list.tail;
		list2.head = midnode.next;
		list.tail = midnode;
		midnode.next = null;
		
		list = mergeSortLinkedList(list);
		list2 = mergeSortLinkedList(list2);
		
		Linkedlist list3 = mergeTwoList(list, list2);
		return list3;		
	}
	
	public Linkedlist removeDuplicatesFromList(Linkedlist list) {
		ListNode current = list.head;
		ListNode newnode = current.next;
		while(newnode != null) {
			if(current.data != newnode.data) {
				current.next = newnode;
				current = current.next;
			}else {
				current.next = null;
				list.size--;
			}
			newnode = newnode.next;
		}
		list.tail = current;
		
		return list;
	}
	
	public void oddEvenList(Linkedlist list) {
		ListNode oddhead = null;
		ListNode evenhead = null;
		ListNode oddtail = null;
		ListNode eventail = null;
		ListNode itr = list.head;
		while((oddhead == null || evenhead == null) && itr != null) {
			if(itr.data%2 == 0) {
				if(evenhead == null) {
					evenhead = itr;
				}
				eventail = itr;
			}else {
				if(oddhead == null) {
					oddhead = itr;
				}
				oddtail = itr;
			}
			itr = itr.next;
		}
		while(itr != null) {
			if(itr.data%2 == 0) {
				eventail.next = itr;
				eventail = itr;
			}else {
				oddtail.next = itr;
				oddtail = itr;
			}
			itr = itr.next;
		}
		if(oddhead == null) {
			list.head = evenhead;
			list.tail = eventail;
		}else {
			list.head = oddhead;
			oddtail.next = evenhead;
			if(evenhead != null) {
				eventail.next = null;
			}
		}
	}
	
	public void kReverse(Linkedlist list, int k) { 
		ListNode itr = list.head;
		int i = k;
		Stack<ListNode> st = new Stack<>();
		Queue<Integer> que = new LinkedList<>();
		
		while(itr!=null) {
			if(i>0) {
				i--;
			}else {
				while(!st.isEmpty() && !que.isEmpty()) {
					System.out.println(st.peek().data+" "+que.element());
					st.pop().data = que.poll();
				}
				i=k-1;
			}
			st.push(itr);
			que.offer(itr.data);
			itr = itr.next;
		}
		while(!st.isEmpty() && !que.isEmpty()) {
			System.out.println(st.peek().data+" "+que.element());
			st.pop().data = que.poll();
		}
	}
	
	public void printReverse(ListNode node) {
		if(node == null) {
			return;
		}
		printReverse(node.next);
		System.out.print(node.data+" -> ");
	}
	
	public Linkedlist reverseLinkedList(ListNode node) {
		if(node.next == null) {
			Linkedlist list = new Linkedlist();
			list.head = node;
			list.tail = node;
			list.size++;
			return list;
		}
		Linkedlist list1 = reverseLinkedList(node.next);
		list1.tail.next = node;
		list1.tail = node;
		list1.size++;
		return list1;
	}
	
	  

	public static void main(String[] args) {
		LinkedListProblems llp = new LinkedListProblems();
		Linkedlist list1 = llp.new Linkedlist();
		llp.addNodeAtLast(list1, 1);
		llp.addNodeAtLast(list1, 2);
		llp.addNodeAtLast(list1, 3);
		llp.addNodeAtLast(list1, 4);
		llp.addNodeAtLast(list1, 5);
		llp.addNodeAtLast(list1, 6);
		
		Linkedlist list2 = llp.new Linkedlist();
		llp.addNodeAtLast(list2, 20);
		llp.addNodeAtLast(list2, 30);
		llp.addNodeAtLast(list2, 40);
		llp.addNodeAtLast(list2, 60);
		llp.addNodeAtLast(list2, 70);
		llp.addNodeAtLast(list2, 110);
		
//		llp.reverseLinkedlist(list1);
//		llp.displayLinkedlist(list1);
				
//		System.out.println(llp.kthNodeFromEnd(list1, 5));
		
//		System.out.println(llp.middleNode(list1).data);
		
//		Linkedlist list3 = llp.new Linkedlist();
//		list3 = llp.mergeTwoList(list1, list2);
//		llp.displayLinkedlist(list3);
//		System.out.println(list3.head.data+" "+list3.tail.data+" "+list3.size);
		
//		Linkedlist list3 = llp.new Linkedlist();
//		list3 = llp.mergeSortLinkedList(list1);
//		System.out.println(list3.tail.data);
//		llp.displayLinkedlist(list3);
		
		
//		llp.displayLinkedlist(llp.removeDuplicatesFromList(list3));
//		System.out.println(llp.removeDuplicatesFromList(list3).size);

//		llp.displayLinkedlist(list1);
//		llp.oddEvenList(list1);
//		llp.displayLinkedlist(list1);
		
//		llp.kReverse(list2, 3);	
//		llp.displayLinkedlist(list2);
		
//		llp.printReverse(list2.head);
//		System.out.println("null");
		
//		list2 = llp.reverseLinkedList(list2.head);
//		list2.tail.next = null;
//		llp.displayLinkedlist(list2);
		
		
		
	}

}
