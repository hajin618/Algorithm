import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int[] x = {-1, 1, 0, 0};
	public static int[] y = {0, 0, -1, 1};
	public static int[][] arr;
	public static int[][] cnt;
	public static boolean[][] visited;
	public static int m;
	public static int n;
	
	public static int func(int i, int j) {
		
		if(i==m-1 && j==n-1)
			return 1;
		
		if(visited[i][j] == true) {
			return cnt[i][j];
		}
		else {
			visited[i][j] = true;
			
			for(int t=0; t<4; t++) {
				int xx = i + x[t];
				int yy = j + y[t];
				
				if(xx>=0 && xx<m && yy>=0 && yy<n) {
					
					if(arr[i][j] > arr[xx][yy]) {

						cnt[i][j] += func(xx, yy);
					}
				}
			}
		}
		
		return cnt[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[505][505];
		cnt = new int[505][505];
		visited = new boolean[505][505];
	
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(func(0, 0));
	}
}
