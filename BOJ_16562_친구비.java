import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K;
	public static List<Node> cost;
	public static int[] parent;
	public static int ANS;
	
	public static class Node implements Comparable<Node>{
		int num;
		int cost;
		
		Node(int num, int cost){
			this.num = num;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static int find(int a) {
		if(parent[a] == a)
			return a;
		else 
			return parent[a] = find(parent[a]);
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        cost = new ArrayList<>();
        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
        	parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
        	cost.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	union(a, b);
        }
        
        Collections.sort(cost);
        
        for(Node n : cost) {
        	if(find(n.num) != find(0)) {
        		if(n.cost <= K) {
        			K -= n.cost;
        			ANS += n.cost;
        			union(0, n.num);
        		}
        	}
        }
        
        boolean flag = true;
        for(int i=1; i<=N; i++) {
        	if(find(0) != find(i)) {
        		flag = false;
        		break;
        	}
        }
        
        if(flag)
        	System.out.println(ANS);
        else
        	System.out.println("Oh no");
     
    }
}