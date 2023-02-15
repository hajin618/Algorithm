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
	
	public static int N;
	public static int[][] arr;
	public static endPoint[][] exists;
	
	static class endPoint{
		int garo = 0;
		int sero = 0;
		int dae  = 0;
	}
	
	public static boolean moveRight(int i, int j) {
		if(j == N-1)
			return false;
		if(arr[i][j+1] == 1)
			return false;
		
		return true;
	}
	
	public static boolean moveDown(int i, int j) {
		if(i == N-1)
			return false;
		if(arr[i+1][j] == 1)
			return false;
		
		return true;
	}
	
	public static boolean moveDae(int i, int j) {
		if(i == N-1 || j == N-1)
			return false;
		if(arr[i+1][j] == 1 || arr[i][j+1] == 1 || arr[i+1][j+1] == 1)
			return false;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		exists = new endPoint[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				exists[i][j] = new endPoint();
			}
		}
		
		exists[0][1].garo += 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 1. 가로 이동 확인
				boolean right = moveRight(i, j);
				// 2. 세로 이동 확인
				boolean down = moveDown(i, j);
				// 3. 대각선 이동 확인
				boolean dae = moveDae(i, j);
					
				if(arr[i][j] == 0 && exists[i][j].garo != 0) {
					if(right) {
						exists[i][j+1].garo += exists[i][j].garo;
					}
					if(dae) {
						exists[i+1][j+1].dae += exists[i][j].garo;
					}
				}
				if(arr[i][j] == 0 && exists[i][j].sero != 0) {
					if(down) {
						exists[i+1][j].sero += exists[i][j].sero;
					}
					if(dae) {
						exists[i+1][j+1].dae += exists[i][j].sero;
					}	
				}
				if(arr[i][j] == 0 && exists[i][j].dae != 0) {
					if(right) {
						exists[i][j+1].garo += exists[i][j].dae;
					}
					if(down) {
						exists[i+1][j].sero += exists[i][j].dae;
					}
					if(dae) {
						exists[i+1][j+1].dae += exists[i][j].dae;
					}
				}
				
			}
		}
		System.out.println(exists[N-1][N-1].garo + exists[N-1][N-1].sero + exists[N-1][N-1].dae);
	}
}