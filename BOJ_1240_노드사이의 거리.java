import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Node>[] list;
	static boolean[] visited;
	
	static class Node{
		int node;
		int dist;
		
		Node(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			visited = new boolean[N+1];
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs(a, b));
		}
	}
	
	public static int bfs(int start, int end) {
		int dist = 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.node == end) {
				dist = now.dist;
				break;
			}
			
			for(Node next : list[now.node]) {
				if(!visited[next.node]) {
					visited[next.node] = true;
					queue.add(new Node(next.node, now.dist + next.dist));
				}
			}
		}
		
		return dist;
	}
}