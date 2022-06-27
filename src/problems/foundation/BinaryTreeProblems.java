package problems.foundation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeProblems {
	
	public class Node {
		
		private int data;
		private Node left;
		private Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public class BinaryTree {
		private Node root;
		private int sum;
		private int height;
		private int max;
		private int size;
		
		BinaryTree(Node root){
			this.root = root;
			this.sum = sumOfBinaryTree(root);
			this.height = heightOfBinaryTree(root)-1;
			this.max = maxOfBinaryTree(root);
			this.size = sizeOfBinaryTree(root);
		}
		
		private int sumOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (root.data+sumOfBinaryTree(root.left)+sumOfBinaryTree(root.right));
		}
	
		
		private int heightOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (1+Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)));
		}
		
		private int maxOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return Math.max(root.data, Math.max(maxOfBinaryTree(root.left), maxOfBinaryTree(root.right)));
		}
		
		private int sizeOfBinaryTree(Node root) {
			if(root==null) {
				return 0;
			}
			return (1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right));
		}
		
	}
	
	public class Pair {
		
		private Integer key;
		private Node node;
		
		Pair(Node node, Integer key){
			this.key = key;
			this.node = node;
		}
		
	}
	
	public Node binaryTreeConstructor(Integer[] arr) {
		
		Node root = new Node(arr[0]);
		Pair rtp = new Pair(root, 1);
		Stack<Pair> st = new Stack<>();
		st.push(rtp);
		Pair top;
		int idx = 0;
		while(!st.isEmpty()) {
			top = st.peek();
			if(top.key == 1) {
				idx++;
				if(arr[idx] != null) {
					top.node.left = new Node(arr[idx]);
					Pair ln = new Pair(top.node.left, 1); 
					st.push(ln);
				}
				top.key++;
			}else if(top.key == 2) {
				idx++;
				if(arr[idx] != null) {
					top.node.right = new Node(arr[idx]);
					Pair rn = new Pair(top.node.right, 1); 
					st.push(rn);
				}
				top.key++;
			}else {
				st.pop();
			}
			
		}
		return root;
		
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
	
	public void detailsOfBinaryTree(BinaryTree tree) {
		
		System.out.println("Size of Tree = "+tree.size);
		System.out.println("Sum of Tree = "+tree.sum);
		System.out.println("Max of Tree = "+tree.max);
		System.out.println("Height of Tree = "+tree.height);
		
	}
	
	public void levelOrderTraversal(Node root) {
		
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		que.add(null);
		while(!que.isEmpty()) {
			Node node = que.poll();
			if(node!=null) {
				if(node.left!=null) {
					que.add(node.left);
				}
				if(node.right!=null) {
					que.add(node.right);
				}
				System.out.print(node.data+" ");
			}else {
				if(!que.isEmpty()) {
					que.add(null);
				}
				System.out.println();
			}
		}
		
	}
	
	public void printArrayList(ArrayList<Node> order, String s) {
		
		System.out.print(s+" = ");
		for(Node node: order) {
			System.out.print(node.data+" ");
		}
		System.out.println();
		
	}
	
	public void iterativeTraversals(BinaryTree tree) {
		
		ArrayList<Node> pre = new ArrayList<>();
		ArrayList<Node> in = new ArrayList<>();
		ArrayList<Node> post = new ArrayList<>();
		Pair rtp = new Pair(tree.root, 1);
		Stack<Pair> st = new Stack<>();
		st.push(rtp);
//		pre.add(tree.root);
		Pair top;
		while(!st.empty()) {
			top = st.peek();
			if(top.key==1) {
				if(top.node!=null) {
					Node ln = top.node.left;
					if(ln!=null) {
						Pair lp = new Pair(ln, 1);
						st.push(lp);
					}
					pre.add(top.node);
				}
				top.key++;
			}else if(top.key==2) {
				if(top.node!=null) {
					Node rn = top.node.right;
					if(rn!=null) {
						Pair rp = new Pair(rn, 1);
						st.push(rp);
					}
					in.add(top.node);
				}
				top.key++;				
			}else {
				if(top.node!=null) {
					post.add(top.node);
				}
				st.pop();
			}
		}
		printArrayList(pre, "PreOrder Traversal");
		printArrayList(in, "InOrder Traversal");
		printArrayList(post, "PostOrder Traversal");
		
	}
	
	public ArrayList<Node> nodeToRootPath(Node root, int key){
		
		ArrayList<Node> path = new ArrayList<>();
		if(root==null) {
			return path;
		}
		if(root.data==key) {
			path.add(root);
			return path;
		}
		ArrayList<Node> path1 = nodeToRootPath(root.left, key);
		ArrayList<Node> path2 = nodeToRootPath(root.right, key);
		path = path1.isEmpty() ? path2 : path1;
		if(!path.isEmpty()) {
			path.add(root);
		}
		return path;
		
	}
	
	public void printKLevelsDown(Node root, int k) {
		
		Queue<Node> que = new LinkedList<Node>();
		que.add( root);
		que.add(null);
		int lvl = 0;
		while(lvl<k) {
			Node top = que.remove();
			if(top!=null) {
				que.add(top.left);
				que.add(top.right);
			}else {
				que.add(null);
				lvl++;
			}
		}
		while(!que.isEmpty()) {
			if(que.element()!=null) {
				System.out.print(que.remove().data+" ");
			}else {
				que.remove();
			}
		}
		
	}
	
	public void transformToLeftClonedTree(Node root) {
		
		if(root==null) {
			return;
		}
		Node node = new Node(root.data);
		node.left = root.left;
		root.left = node;
		transformToLeftClonedTree(node.left);
		transformToLeftClonedTree(root.right);
		
	}
	
	public void transformBackFromLeftClonedTree(Node root) {
		
		if(root==null) {
			return;
		}
		root.left = root.left.left;
		transformBackFromLeftClonedTree(root.left);
		transformBackFromLeftClonedTree(root.right);
		
	}
	
	public void removeLeaves(Node root) {
		
		if(root==null) {
			return;
		}
		if(root.left!=null && root.left.left==null && root.left.right==null) {
			root.left =null;
		}
		if(root.right!=null && root.right.left==null && root.right.right==null) {
			root.right =null;
		}
		removeLeaves(root.left);
		removeLeaves(root.right);
		
	}
	
	private class DiameterMaxEdgePair {
		
		private int dimtr;
		private int maxedge;
		
		public DiameterMaxEdgePair(int dimtr, int maxedge) {
			this.dimtr = dimtr;
			this.maxedge = maxedge;
		}
		
	}
	
	public DiameterMaxEdgePair maxDiameterOfBinaryTree(Node root) {
		
		if(root==null) {
			DiameterMaxEdgePair pair = new DiameterMaxEdgePair(0, 0);
			return pair;
		}
		
		DiameterMaxEdgePair pair1 = maxDiameterOfBinaryTree(root.left);
		DiameterMaxEdgePair pair2 = maxDiameterOfBinaryTree(root.right);
		
		DiameterMaxEdgePair pair = new DiameterMaxEdgePair(0, 0);
		pair.dimtr = pair1.maxedge + pair2.maxedge + 1;
		pair.maxedge = Math.max(pair1.maxedge, pair2.maxedge) + 1;
		return pair;
		
	}

	public static void main(String[] args) {

		BinaryTreeProblems btp = new BinaryTreeProblems();
		Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, 68, 45, null, null, null, null};
		Node root = btp.binaryTreeConstructor(arr);
		BinaryTree bt = btp.new BinaryTree(root);
//		btp.displayBinaryTree(bt.root);
//		btp.detailsOfBinaryTree(bt);
//		btp.levelOrderTraversal(bt.root);
//		btp.iterativeTraversals(bt);
//		ArrayList<Node> path = btp.nodeToRootPath(bt.root, 70);
//		btp.printArrayList(path, "Node "+70+" to root path");
//		btp.printKLevelsDown(bt.root, 2);
//		btp.transformToLeftClonedTree(bt.root);
//		btp.displayBinaryTree(bt.root);		
//		btp.transformBackFromLeftClonedTree(bt.root);
//		btp.displayBinaryTree(bt.root);
//		btp.removeLeaves(bt.root);
//		btp.displayBinaryTree(bt.root);
		DiameterMaxEdgePair pair = btp.maxDiameterOfBinaryTree(bt.root);
		System.out.println(pair.dimtr);
		
	}

}
