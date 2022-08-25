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
		int min;
		BinarySearchTree(int[] arr){
			
			this.head = BSTConstructor(arr, 0, arr.length-1);
			this.size = sizeOfBinaryTree(this.head);
			this.max = maxOfBinaryTree(this.head);
			this.sum = sumOfBinaryTree(this.head);
			this.height = heightOfBinaryTree(this.head);
			this.min = minOfBinaryTree(this.head);			
			
		}
		Node BSTConstructor(int[] arr, int lo, int hi) {
			
			if(lo>hi) {
				return null;
			}
			int mid = (lo + hi)/2;
			Node ln = BSTConstructor(arr, lo, mid-1);
			Node rn = BSTConstructor(arr, mid+1, hi);
			Node node = new Node(arr[mid], ln, rn);
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
			
			if(root.right==null) {
				return root.data;
			}
			int max = maxOfBinaryTree(root.right);
			return max;
		
		}
		int minOfBinaryTree(Node root) {
			
			if(root.left==null) {
				return root.data;
			}
			int min = minOfBinaryTree(root.left);
			return min;
			
		}
		int sizeOfBinaryTree(Node root) {
			
			if(root==null) {
				return 0;
			}
			return (1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right));
			
		}
		void addBSTNode(int data) {
			
			Node root = this.head;
			Node prevnode = null;
			while(root!=null) {
				if(data==root.data) {
					return;
				}else if(data>root.data) {
					prevnode = root;
					root = root.right;
				}else {
					prevnode = root;
					root = root.left;
				}
			}
			if(data>prevnode.data) {
				prevnode.right = new Node(data, null, null);
			}else {
				prevnode.left = new Node(data, null, null);
			}
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
//		bstp.displayBinaryTree(bst.head);
//		System.out.println(bst.max);
//		System.out.println(bst.min);
//		System.out.println(bst.size);
//		System.out.println(bst.sum);
//		System.out.println(bst.height);
		bstp.displayBinaryTree(bst.head);		
		bst.addBSTNode(12);
		bstp.displayBinaryTree(bst.head);
		

	}

}
