package problems.foundation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphProblems {

	static class Edge {
		
		int src;
		int dest;
		int wgt;
		
		Edge(int src, int dest, int wgt){
			
			this.src = src;
			this.dest = dest;
			this.wgt = wgt;
			
		}
		
	}
	
	static void printPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {
		
		if(src == dest) {
			System.out.println(path+" "+src);
		}
		for(Edge edge: graph[src]) {
			
		}
		
	}
	
	static void printAns(ArrayList<Integer> ans) {
		
		for(Integer i: ans) {
			System.out.print(i+" ");
		}
		System.out.println("");
		
	}
	
	static void DFS(ArrayList<Integer>[] adj_list, boolean[] visited, List<Integer> ans, int n) {
		
		Stack<Integer> st = new Stack<>();
		st.push(n);
		
		while(!st.isEmpty()) {
			Integer x = st.pop();
			if(!visited[x]) {
				visited[x] = true;
				
				for(Integer i: adj_list[x]) {
					if(!visited[i]) {
						st.push(i);
					}
				}
				ans.add(x);
			}
		}
		
	}
	
	static void makeGraph(ArrayList<Edge>[] graph) {
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 4));
		graph[0].add(new Edge(0, 7, 8));
		graph[1].add(new Edge(1, 0, 4));
		graph[1].add(new Edge(1, 2, 8));
		graph[1].add(new Edge(1, 7, 11));
		graph[2].add(new Edge(2, 1, 8));
		graph[2].add(new Edge(2, 3, 7));
		graph[2].add(new Edge(2, 5, 4));
		graph[2].add(new Edge(2, 8, 2));
		graph[3].add(new Edge(3, 2, 7));
		graph[3].add(new Edge(3, 4, 9));
		graph[4].add(new Edge(4, 3, 9));
		graph[4].add(new Edge(4, 5, 10));
		graph[5].add(new Edge(5, 2, 4));
		graph[5].add(new Edge(5, 4, 10));
		graph[5].add(new Edge(5, 6, 2));
		graph[6].add(new Edge(6, 5, 2));
		graph[6].add(new Edge(6, 7, 1));
		graph[6].add(new Edge(6, 8, 6));
		graph[7].add(new Edge(7, 0, 8));
		graph[7].add(new Edge(7, 1, 11));
		graph[7].add(new Edge(7, 6, 1));
		graph[7].add(new Edge(7, 8, 7));
		graph[8].add(new Edge(8, 2, 2));
		graph[8].add(new Edge(8, 6, 6));
		graph[8].add(new Edge(8, 7, 7));
		
	}
	
	static void printGraph(ArrayList<Edge>[] graph) {
		
		for(int i=0; i<graph.length; i++) {
			System.out.print(i+"-> ");
			for(Edge edg: graph[i]) {
				System.out.print(edg.dest+","+edg.wgt+" | ");
			}
			System.out.println("");
		}
		
	}
	
	static boolean isGraphVisited(boolean[] visited) {
		for(boolean v: visited) {
			if(v==false) {
				return false;
			}
		}
		return true;
	}
	
	static void fillMinDistances(int[] min_distances, int src) {
		
		for(int i=0; i<min_distances.length; i++) {
			if(i==src) {
				min_distances[i] = 0;
			}else {
				min_distances[i] = Integer.MAX_VALUE;
			}
		}
		
	}
	
	static int findNearestNode(int[] min_distances, boolean[] visited) {
		
		int nearest_node = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=0; i<min_distances.length; i++) {
			if(!visited[i]) {
				if(nearest_node>min_distances[i]) {
					idx = i;
				}
			}
		}
		return idx;
		
	}
	
	static void algoDijkstras(ArrayList<Edge>[] graph, int src, int dest) {
		
		int[] min_distances = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		fillMinDistances(min_distances, src);
		
		while(!isGraphVisited(visited)) {
			int x = findNearestNode(min_distances, visited);
			for(Edge edg: graph[x]) {
				if(!visited[edg.dest]) {
					if(min_distances[edg.src]+edg.wgt<min_distances[edg.dest]) {
						min_distances[edg.dest] = min_distances[edg.src]+edg.wgt;
					}
				}
				visited[x] = true;
			}
		}
		System.out.println(src+"->"+dest+"= "+min_distances[dest]);
		
	}
	
	
	
	public static void main(String[] args) {
		
		long st = System.currentTimeMillis();
		
		ArrayList<Integer>[] adj_list = new ArrayList[8];
		for(int i=0; i<8; i++) {
			adj_list[i] = new ArrayList<>();

		}
		adj_list[0].add(1);
		adj_list[1].add(0);
		adj_list[1].add(2);
		adj_list[1].add(3);
		adj_list[1].add(4);
		adj_list[2].add(1);
		adj_list[2].add(4);
		adj_list[3].add(1);
		adj_list[4].add(1);
		adj_list[4].add(2);
		adj_list[4].add(6);
		adj_list[4].add(7);
		adj_list[5].add(6);
		adj_list[6].add(4);
		adj_list[6].add(5);
		adj_list[7].add(4);	
		
		
//		boolean[] visited = new boolean[8];
//		ArrayList<Integer> ans = new ArrayList<>();
//		for(int i=0; i<8; i++) {
//			if(!visited[i]) {
//				DFS(adj_list, visited, ans, i);
//			}
//		}
//		printAns(ans);
		
		ArrayList<Edge>[] graph = new ArrayList[9];
		makeGraph(graph);
		algoDijkstras(graph, 0, 8);
		
		
		long end = System.currentTimeMillis();
		System.out.println("Execution Time: "+((end)-(st))+"ms");
		
	}	

	

}
