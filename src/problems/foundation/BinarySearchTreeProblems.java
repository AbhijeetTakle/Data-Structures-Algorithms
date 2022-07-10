package problems.foundation;

public class BinarySearchTreeProblems {
	
	static class Node{
		
		Node left;
		Node right;
		int data;
		Node(int data, Node left, Node right){
			
			this.data = data;
			this.left = left;
			this.right = right;
			
		}
		
	}
	
	static class BinarySearchTree{
		
		Node head;
		int size;
		int max;
		int sum;
		int height;
		BinarySearchTree(int[] arr){
			
			this.head = BSTConstructor(arr, 0, arr.length-1);
			this.size = sizeOfBinaryTree(this.head);
			this.max = maxOfBinaryTree(this.head);
			this.sum = sumOfBinaryTree(this.head);
			this.height = heightOfBinaryTree(this.head);
			
			
		}
		Node BSTConstructor(int[] arr, int lo, int hi) {
			
			if(lo>hi) {
				return null;
			}
			int mid = (lo + hi)/2;
			Node ln = BSTConstructor(arr, lo, mid-1);
			Node rn = BSTConstructor(arr, mid+1, hi);
			Node node = new Node(arr[mid], ln, rn);
			size++;
			max = arr[hi];
			return node;
			
		}
		int sumOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (root.data+sumOfBinaryTree(root.left)+sumOfBinaryTree(root.right));
		}
		int heightOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (1+Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)));
		}
		int maxOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return Math.max(root.data, Math.max(maxOfBinaryTree(root.left), maxOfBinaryTree(root.right)));
		}
		int sizeOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right));
		}
		
	}
	
	public void displayBinaryTree(Node root) {
		
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			System.out.print(root.left.data+" -> ");
		}else {
			System.out.print(". -> ");
		}
		System.out.print(root.data);
		if(root.right!=null) {
			System.out.println(" <- "+root.right.data);
		}else {
			System.out.println(" <- .");
		}
		displayBinaryTree(root.left);
		displayBinaryTree(root.right);
		
	}

	public static void main(String[] args) {
		
		BinarySearchTreeProblems bstp = new BinarySearchTreeProblems();
		int[] arr = {12, 25, 37, 50, 62, 75, 87};
		BinarySearchTree bst = new BinarySearchTree(arr);
		bstp.displayBinaryTree(bst.head);
		System.out.println(bst.max);
		System.out.println(bst.size);
		System.out.println(bst.sum);
		System.out.println(bst.height);		

	}

}
