import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] r = {-1, 1, 0, 0};
	public static int[] c = {0, 0, -1, 1};
	public static int[][] arr;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	public static int min_cnt = Integer.MAX_VALUE;
	
	static class Node{
		int i, j, cnt;
		boolean b;
		
		public Node(int i, int j, boolean b, int cnt) {
			this.i = i;
			this.j = j;
			this.b = b;
			this.cnt = cnt;
		}
	}
	
	public static void bfs(int i, int j, boolean b) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(i, j, false, 1));
		
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.i == N-1 && node.j == M-1)
				if(min_cnt > node.cnt)
					min_cnt = node.cnt;
			
			for(int p = 0; p < 4; p++) {
				int ii = node.i + r[p];
				int jj = node.j + c[p];
				boolean bb = node.b;
				int ccnntt = node.cnt;
				
				// 벽 부순 적 o
				if(bb) {	
					if(ii>=0 && ii<N && jj>=0 && jj<M && !visited2[ii][jj] && arr[ii][jj]==0) {
						queue.add(new Node(ii, jj, true, ccnntt+1));
						visited2[ii][jj] = true;
					}
				}
				else {	// 벽 부순 적 x
					if(ii>=0 && ii<N && jj>=0 && jj<M && !visited[ii][jj]) {
						if(arr[ii][jj] == 1) {
							queue.add(new Node(ii, jj, true, ccnntt+1));
							visited2[ii][jj] = true;
							
						}
							
						else {
							queue.add(new Node(ii, jj, false, ccnntt+1));
							visited[ii][jj] = true;
						}
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(0, 0, false);
		
		if(min_cnt == Integer.MAX_VALUE)
			min_cnt = -1;
		
		System.out.println(min_cnt);
	}
}