package problems.foundation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GenericTreeProblems {

	public class TreeNode {
		private int data;
		private ArrayList<TreeNode> nodelist = new ArrayList<>(); 
		private TreeNode(int val) {
			this.data = val;
		}
	}
	
	public int treeSize(TreeNode root) {
		if(root.nodelist.isEmpty()) {
			return 1;
		}
		int size =0;
		for(TreeNode node: root.nodelist) {
			size += treeSize(node);
		}
		return 1+size;
	}
	
	public void createTree(TreeNode root) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		
		root.nodelist.add(node1);
		root.nodelist.add(node2);
		root.nodelist.add(node3);

		TreeNode node4 = new TreeNode(4);		
		node3.nodelist.add(node4);
		TreeNode node6 = new TreeNode(6);		
		node3.nodelist.add(node6);
		
		TreeNode node5 = new TreeNode(6);		
		node4.nodelist.add(node5);
		TreeNode node7 = new TreeNode(7);		
		node4.nodelist.add(node7);
	}
	
	public void displayTree(TreeNode root) {
		if(root.nodelist.isEmpty()) {
			System.out.println(root.data);
			return;
		}

		System.out.print(root.data+" -> ");
		for(TreeNode node: root.nodelist) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
		for(TreeNode node: root.nodelist) {
			displayTree(node);
		}
	}
	
	public int maxInTree(TreeNode root) {
		if(root.nodelist.isEmpty()) {
			return root.data;
		}
		int max = Integer.MIN_VALUE;
		for(TreeNode node: root.nodelist) {
			max = Integer.max(max, maxInTree(node));
		}
		return Integer.max(root.data, max);
	}
	
	public int heightOfTree(TreeNode root) {
		if(root.nodelist.isEmpty()) {
			return 1;
		}
		int max = Integer.MIN_VALUE;
		for(TreeNode node: root.nodelist) {
			max = Integer.max(max, heightOfTree(node));
		}
		return 1+max;
	}
	
	public void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
		Queue<TreeNode> que1 = new LinkedList<>();
		que.offer(root);
		
		while(!que.isEmpty() || !que1.isEmpty()) {	
			
			while(!que.isEmpty()) {
				TreeNode node = que.poll();
				for(TreeNode child: node.nodelist) {
					que1.offer(child);
				}
				System.out.print(node.data+" ");
			}
			System.out.println(". ");
			Queue<TreeNode> temp = que;
			que = que1;
			que1 = temp;
		}
		System.out.println(".");
	}
	
	public void levelOrderZigZagTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		st.push(root);
		int flag = 1;
		while(!st.isEmpty()) {
			while(!st.isEmpty()) {
				if(flag == 1) {
					for(TreeNode node: st.peek().nodelist) {
						st2.push(node);
					}
				}else {
					for(int i= st.peek().nodelist.size()-1; i>=0; i--) {
						st2.push(st.peek().nodelist.get(i));
					}
				}
				System.out.print(st.pop().data+" ");				
			}
			if(flag ==1) {
				flag = -1;
			}else {
				flag = 1;
			}
			Stack<TreeNode> temp = st;
			st = st2;
			st2 = temp;
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		GenericTreeProblems gtp = new GenericTreeProblems();
		TreeNode root = gtp.new TreeNode(1);
		gtp.createTree(root);
		
//		System.out.println(gtp.treeSize(root));
		
//		gtp.displayTree(root);
		
//		System.out.println(gtp.maxInTree(root));
		
//		System.out.println(gtp.heightOfTree(root));
		
//		gtp.levelOrderTraversal(root);
		
		gtp.levelOrderZigZagTraversal(root);
	}

}
