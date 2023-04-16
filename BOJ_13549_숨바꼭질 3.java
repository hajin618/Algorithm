import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, K;
	public static class Node{
		int now;
		int time;
		Node(int now, int time){
			this.now = now;
			this.time = time;
		}
	}
	public static boolean[] visited;
	public static int ANS = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[100001];
        bfs();
        System.out.println(ANS);
    }
    public static void bfs() {
    	Queue<Node> queue = new LinkedList<>();
    	
    	queue.add(new Node(N, 0));
    	visited[N] = true;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		if(node.now == K) {
    			if(ANS > node.time)
    				ANS = node.time;
    		}
    		
    		if(node.time > ANS)
    			continue;
    		
    		if(node.now*2 <= 100000 && !visited[node.now * 2]) {
				visited[node.now * 2] = true;
				queue.add(new Node(node.now * 2, node.time));
    		}
    		if(node.now-1 >=0 && !visited[node.now -1]) {
    			visited[node.now - 1] = true;
    			queue.add(new Node(node.now-1, node.time+1));
    		}
    		if(node.now +1 <= 100000 && !visited[node.now +1]) {
    			visited[node.now + 1] = true;
				queue.add(new Node(node.now+1, node.time+1));
    		}
    	}
    }
}