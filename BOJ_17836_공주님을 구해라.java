import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T, sord_x, sord_y;
    static int ANS = Integer.MAX_VALUE;
    static int ANS_with_sord = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};
    
    static class Node{
    	int x;
    	int y;
    	int cnt;
    	Node(int x, int y, int cnt){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringTokenizer st;
       	
       	st = new StringTokenizer(br.readLine());
       	N = Integer.parseInt(st.nextToken());
       	M = Integer.parseInt(st.nextToken());
       	T = Integer.parseInt(st.nextToken());
       	
       	arr = new int[N][M];
       	visited = new boolean[N][M];
       	
       	for(int i=0; i<N; i++) {
       		st = new StringTokenizer(br.readLine());
       		for(int j=0; j<M; j++) {
       			arr[i][j] = Integer.parseInt(st.nextToken());
       			
       			if(arr[i][j] == 2) {
       				sord_x = i;
       				sord_y = j;
       				arr[i][j] = 0;
       			}
       		}
       	}
       	
       	bfs();
       	
       	int ans = Math.min(ANS, ANS_with_sord);
       	
       	if(ans > T) 
       		System.out.println("Fail");
       	else
       		System.out.println(ans);
    }
    
    public static void bfs() {
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(0, 0, 0));
    	visited[0][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Node now = queue.poll();
    		
    		// N-1, M-1 도착
    		if(now.x == N-1 && now.y == M-1) {
    			ANS = now.cnt;
    			break;
    		}
    		
    		// 검 획득
    		if(now.x == sord_x && now.y == sord_y) {
    			ANS_with_sord = now.cnt + (N - 1 - now.x) + (M - 1 - now.y);
    		}
    		
    		for(int p=0; p<4; p++) {
    			int ii = now.x + nr[p];
    			int jj = now.y + nc[p];
    			
    			if(ii>=0 && ii<N && jj>=0 && jj<M && !visited[ii][jj] && arr[ii][jj]==0) {
    				queue.add(new Node(ii, jj, now.cnt + 1));
    				visited[ii][jj] = true;
    			}
    		}
    	}
    }
}