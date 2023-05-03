import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static List<Node> list;
	static int[] parent;
	static double ANS;
	
	static class Node implements Comparable<Node>{
		int node1;
		int node2;
		double dist;
		
		Node(int node1, int node2, double dist){
			this.node1 = node1;
			this.node2 = node2;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.dist > o.dist)
				return 1;
			else if(this.dist < o.dist)
				return -1;
			else
				return 0;
		}
		
	}
	
	public static int find(int a) {
		if(parent[a] == a)
			return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			if(pa < pb)
				parent[pb] = parent[pa];
			else
				parent[pa] = parent[pb];
		}
	}
	
	public static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		arr = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				list.add(new Node(i, j, dist(arr[i][0], arr[i][1], arr[j][0], arr[j][1])));
			}
		}
		
		Collections.sort(list);
		
		int cnt = 0;
		for(Node node : list) {
			if(cnt == N-1)
				break;
			if(find(node.node1) != find(node.node2)) {
				union(node.node1, node.node2);
				ANS += node.dist;
				cnt += 1;
			}
		}
		
		System.out.printf("%.2f", ANS);
	}
}