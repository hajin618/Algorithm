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
	public static int now_r;
	public static int now_c;
	public static int now_d;
	public static int r[] = {0, 0, -1, 1};
	public static int c[] = {-1, 1, 0, 0};
	
	public static int[][] arr;
	public static boolean[][] isClean;
	
	public static void changeDir() {
		if(now_d == 0)
			now_d = 3;
		else
			now_d -= 1;
	}
	
	public static void moveFront() {
		if(now_d == 0)
			now_r -= 1;
		else if(now_d == 1)
			now_c += 1;
		else if(now_d == 2)
			now_r += 1;
		else if(now_d == 3)
			now_c -= 1;
	}
	
	public static void moveBack() {
		if(now_d == 0)
			now_r += 1;
		else if(now_d == 1)
			now_c -= 1;
		else if(now_d == 2)
			now_r -= 1;
		else if(now_d == 3)
			now_c += 1;
	}
	
	public static boolean canMoveFront() {
		if(now_d == 0) {
			if(now_r > 0 && arr[now_r - 1][now_c] == 0 && !isClean[now_r - 1][now_c])
				return true;
			else
				return false;
		}
		else if(now_d == 1) {
			if(now_c < M-1 && arr[now_r][now_c + 1] == 0 && !isClean[now_r][now_c + 1])
				return true;
			else
				return false;
		}
		else if(now_d == 2) {
			if(now_r < N-1 && arr[now_r + 1][now_c] == 0 && !isClean[now_r + 1][now_c])
				return true;
			else
				return false;
		}
		else if(now_d == 3) {
			if(now_c > 0 && arr[now_r][now_c - 1] == 0 && !isClean[now_r][now_c - 1])
				return true;
			else
				return false;
		}
		
		return true;
	}
	
	public static boolean canMoveBack() {
		if(now_d == 0) {
			if(now_r == N-1 || arr[now_r + 1][now_c] == 1)
				return false;
			else
				return true;
		}
		else if(now_d == 1) {
			if(now_c == 0 || arr[now_r][now_c - 1] == 1)
				return false;
			else
				return true;
		}
		else if(now_d == 2) {
			if(now_r == 0 || arr[now_r - 1][now_c] == 1)
				return false;
			else
				return true;
		}
		else if(now_d == 3) {
			if(now_c == M-1 || arr[now_r][now_c + 1] == 1)
				return false;
			else
				return true;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		now_r = Integer.parseInt(st.nextToken());
		now_c = Integer.parseInt(st.nextToken());
		now_d = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		isClean = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		while(true) {
			if(!isClean[now_r][now_c]) {
				isClean[now_r][now_c] = true;
				ans += 1;
			}

			boolean flag = false;
			
			for(int i=0; i<4; i++) {
				if(!isClean[now_r + r[i]][now_c + c[i]] && arr[now_r + r[i]][now_c + c[i]] == 0) {
					flag = true;
					break;
				}
			}
			
			// 주변 4칸 중 청소되지 않은 칸이 존재하는 경우
			if(flag) {
				changeDir();
				while(!canMoveFront()) {
					changeDir();
				}
				moveFront();
			}
			else {	// 주변 4칸 중 청소되지 않은 칸이 존재하지 않는 경우
				if(canMoveBack()) {
					moveBack();
				}
				else
					break;	
			}
		}
		System.out.println(ans);
	}
}