import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static List<Node>[] list;
	public static int[] dist;
	public static int[][] ANS;
	public static boolean[] visited;

	public static class Node implements Comparable<Node>{
		int node;
		int dist;
		Node(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ANS = new int[N+1][N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list[a].add(new Node(b, c));
        	list[b].add(new Node(a, c));
        }

        for(int i=1; i<=N; i++) {
        	Dijkstra(i);
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(i == j) {
        			sb.append("- ");
        		}
        		else
        			sb.append(ANS[i][j] + " ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);

    }
    
    public static void Dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	// visited 초기화
    	for(int i=0; i<=N; i++)
    		visited[i] = false;
    	
    	// dist 초기화
    	for(int i=0; i<=N; i++) {
    		dist[i] = Integer.MAX_VALUE;
    	}
    	dist[start] = 0;
    	
    	pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()){
    		Node node = pq.poll();
    	
    		
    		if(!visited[node.node]) {
    			visited[node.node] = true;
    			
    			for(Node next : list[node.node]) {
        			if(dist[next.node] > dist[node.node] + next.dist) {
        				dist[next.node] = dist[node.node] + next.dist;
        				pq.add(new Node(next.node, dist[next.node]));
        				ANS[next.node][start] = node.node;
        			}
        		}
    		}
    	}
    	
    	
    }
}