import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static StringBuilder sb = new StringBuilder();
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = Math.min(N, M)/2;
		
		for(int k=0; k<R; k++) {
			for(int i=0; i<cnt; i++) {
				int tmp = arr[i][i];
				
				for(int j=i; j<M-i-1; j++) {
					arr[i][j] = arr[i][j+1];
				}
				for(int j=i; j<N-i-1; j++) {
					arr[j][M-i-1] = arr[j+1][M-i-1];
				}
				for(int j=i+1; j<M-i; j++) {
					arr[N-i-1][M-j] = arr[N-i-1][M-j-1];
				}
				for(int j=i+1; j<N-i; j++) {
					arr[N-j][i] = arr[N-j-1][i];
				}
				arr[i+1][i] = tmp;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}