package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.lang.Math;

public class BinaryTree {
	private TreeNode root;
	
	private static class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(int val) {
			this.data = val;
		}
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		
		root = first;
		first.left = second;
		first.right =  third;
		
		second.left = fourth;
		second.right = fifth;
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	public void preOrderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		System.out.println(" ");
		while(!st.isEmpty()) {
			TreeNode temp = st.pop();
			System.out.print(temp.data+" ");
			if(temp.right != null) {
				st.push(temp.right);
			}
			if(temp.left != null) {
				st.push(temp.left);
			}
		}
		System.out.println(" ");
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void inOrderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(" ");
		Stack<TreeNode> st = new Stack<>();
		TreeNode temp = root;
		while(!st.isEmpty() || temp!=null) {
			if(temp!=null) {
				st.push(temp);
				temp = temp.left;
			}
			else {
				temp = st.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
		System.out.println(" ");
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void postOrderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(" ");
		Stack<TreeNode> st = new Stack<>();
		TreeNode temp = root;
		while(!st.isEmpty() || temp!=null) {
			if(temp != null) {
				st.push(temp);
				temp = temp.left;
			}else {
				TreeNode curr = st.peek().right;
				if(curr == null) {
					curr = st.pop();
					System.out.print(curr.data+" ");
					while(!st.isEmpty() && curr==st.peek().right) {
						curr = st.pop();
						System.out.print(curr.data+" ");
					}
				}else {
					temp = curr;
				}
			}
		}
		System.out.println(" ");
	}
	
	public void levelOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()) {
			TreeNode temp = que.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null) {
				que.offer(temp.left);
			}
			if(temp.right != null) {
				que.offer(temp.right);
			}
		}
		System.out.println(" ");
	}
	
	public int findMax(TreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(Math.max(findMax(root.left),findMax(root.right)), root.data);
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		bt.createBinaryTree();
		bt.preOrder(bt.root);
		bt.preOrderIter(bt.root);
		bt.inOrder(bt.root);
		bt.inOrderIter(bt.root);	
		bt.postOrder(bt.root);	
		bt.postOrderIter(bt.root);
		bt.levelOrder(bt.root);
		System.out.println(bt.findMax(bt.root));
		
	}

}
