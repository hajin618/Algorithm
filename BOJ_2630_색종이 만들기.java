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
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] arr;		// 0: 흰색, 1: 파란색
	static int white = 0;
	static int blue = 0;
	
	public static void func(int i, int j, int n) {
		if(n == 1) {
			if(arr[i][j] == 1)
				blue += 1;
			else
				white += 1;
			
			return;
		}
		
		int tmpBlue = 0;
		int tmpWhite = 0;
		
		for(int p=i; p<i+n; p++) {
			for(int q=j; q<j+n; q++) {
				if(arr[p][q] == 0)
					tmpWhite += 1;
				else
					tmpBlue += 1;
			}
		}
		
		if(tmpBlue == n*n)
			blue += 1;
		else if(tmpWhite == n*n)
			white += 1;
		else {
			func(i, j, n/2);
			func(i+n/2, j, n/2);
			func(i, j+n/2, n/2);
			func(i+n/2, j+n/2, n/2);
		}
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
}