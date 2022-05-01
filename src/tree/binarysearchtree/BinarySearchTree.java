package tree.binarysearchtree;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	private TreeNode root;
	
	private static class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(int val) {
			this.data = val;
		}
	}
	
	public TreeNode insert(TreeNode root, int val) {
		if(root == null) {
			TreeNode newnode = new TreeNode(val);
			root = newnode;
			return root;
		}
		if(val<root.data) {
			root.left = insert(root.left, val);
		}else {
			root.right = insert(root.right, val);
		}
		return root;
	}
	
	public TreeNode searchTree(TreeNode root, int key) {
		if(root == null) {
			return null;
		}
		TreeNode current = new TreeNode(0);
		if(root.data>key) {
			current = searchTree(root.left, key);
		}else if(root.data<key) {
			current = searchTree(root.right, key);
		}else {
			current = root;
		}
		return current;
	}
	
	public void createTree() {		
		root = insert(this.root, 3);		
		root = insert(this.root, 1);		
		root = insert(this.root, 2);		
		root = insert(this.root, 4);		
		root = insert(this.root, 5);
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

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.createTree();
		bst.levelOrder(bst.root);
		System.out.println(bst.root.data);
	}

}
