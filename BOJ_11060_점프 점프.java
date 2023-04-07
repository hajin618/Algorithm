import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static int ANS = Integer.MAX_VALUE;
	
	public static class Node{
		int idx;
		int cnt;
		
		Node(int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(0, 0));
        visited[0] = true;
        
        while(!queue.isEmpty()) {
        	Node node = queue.poll();
        	int nowIdx = node.idx;
        	int nowCnt = node.cnt;
        	int nowNum = arr[nowIdx];
        	
        	if(nowIdx == N-1) {
        		if(ANS > nowCnt)
        			ANS = nowCnt;
        		
        		break;
        	}
        	
        	for(int i=1; i<=nowNum; i++) {
        		if(nowIdx + i <N && !visited[nowIdx + i]) {
        			visited[nowIdx + i] = true;
        			queue.add(new Node(nowIdx + i, nowCnt + 1));
        		}
        	}
        	
        }
        
        if(ANS == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(ANS);
	}
}