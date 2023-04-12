import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static char[][] arr;
	public static int MIN = Integer.MAX_VALUE;
	public static boolean[][][] visited;
	public static int[] nr = {-1, 1, 0, 0};
	public static int[] nc = {0, 0, -1, 1};
	public static int BLACK = 0;
	
	public static class Node{
		int i;
		int j;
		int cnt;
		Node(int i, int j, int cnt){
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == '0') {
					BLACK += 1;
				}
			}
		}

		visited = new boolean[N][N][BLACK+100];
		for(int i=0; i<BLACK+100; i++) {
			visited[0][0][i] = true;
		}
		
		bfs();
		System.out.println(MIN);
	}
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(0, 0, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.cnt > MIN)
				continue;
			
			if(node.i == N-1 && node.j == N-1) {
				if(node.cnt < MIN) {
					MIN = node.cnt;
					continue;
				}
			}
			
			for(int p=0; p<4; p++) {
				int ii = node.i + nr[p];
				int jj = node.j + nc[p];
				
				if(ii>=0 && ii<N && jj>=0 && jj<N) {
					if(arr[ii][jj] == '0') {
						if(!visited[ii][jj][node.cnt+1]) { 
							visited[ii][jj][node.cnt+1] = true;
							queue.add(new Node(ii, jj, node.cnt+1));
						}
					}
					else {
						if(!visited[ii][jj][node.cnt]) {
							visited[ii][jj][node.cnt] = true;
							queue.add(new Node(ii, jj, node.cnt));
						}
					}
				}
			}
		}
		
	}

}
