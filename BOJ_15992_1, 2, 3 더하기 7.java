import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int T, N, M;
	public static long[][] arr;
	public static int[][] p;
	public static int maxN;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		p = new int[T][2];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p[i][0] = N;
			p[i][1] = M;

			if(maxN < N)
				maxN = N;
		}
		
		arr = new long[1001][1001];
		
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		arr[3][1] = 1;
		arr[3][2] = 2;
		arr[3][3] = 1;
		
		for(int i=4; i<=maxN; i++) {
			for(int j=1; j<=i; j++) {
				arr[i][j] = (arr[i-1][j-1] + arr[i-2][j-1] + arr[i-3][j-1]) % 1000000009;
			}
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(arr[p[i][0]][p[i][1]]);
		}
	}
}