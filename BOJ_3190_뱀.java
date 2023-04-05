import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N, K, L;
	public static int[][] arr;	    // 뱀 : 1, 사과 : 5
	public static int now_x, now_y;	// 뱀 현재 위치
	public static int now_dir;		// 뱀 현재 방향 (0:상, 1:하, 2:좌, 3:우)
	public static String[][] info;
	public static int info_idx = 0;
	public static int ANS = 0;
	public static Queue<Node> queue = new LinkedList<>();
	
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] nr = {-1, 1, 0, 0};
	public static int[] nc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		int a, b;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr[a-1][b-1] = 5;
		}
		
		L = Integer.parseInt(br.readLine());
		info = new String[L][2];
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = st.nextToken();
			info[i][1] = st.nextToken();
		}
		
		// 뱀 초기 위치 (0, 0), 초기 방향 오른쪽
		now_x = 0;
		now_y = 0;
		now_dir = 3;
		arr[0][0] = 1;
		queue.add(new Node(0, 0));
		
		while(true) {
			ANS += 1;
			
			// 머리를 다음칸에 위치시킨다.
			int next_x = now_x + nr[now_dir];
			int next_y = now_y + nc[now_dir];
			
			// 범위 확인
			if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) {
				break;
			}
			
			// 이동한 칸에 자기자신 있는 경우
			if(arr[next_x][next_y] == 1) {
				break;
			}
			
//			// 이동한 칸에 사과 있는 경우
//			if(arr[next_x][next_y] == 5) {
//				
//			}
			
			// 이동한 칸에 사과 없는 경우
			if(arr[next_x][next_y] == 0) {
				Node node = queue.poll();
				int last_x = node.x;
				int last_y = node.y;
				arr[last_x][last_y] = 0;
			}
			
			arr[next_x][next_y] = 1;
			
			// queue에 머리칸 넣기
			queue.add(new Node(next_x, next_y));
			
			now_x = next_x;
			now_y = next_y;
			
			// X초 끝난 후 방향 전환
            if(info_idx < L && Integer.parseInt(info[info_idx][0]) == ANS) {
                changeDir(info[info_idx][1].charAt(0));
                info_idx += 1;
            }
			
		}
		
		System.out.println(ANS);
	}
	
	public static void changeDir(char dir) {
		if(dir == 'L') {
			if(now_dir == 0)
				now_dir = 2;
			else if(now_dir == 1)
				now_dir = 3;
			else if(now_dir == 2)
				now_dir = 1;
			else
				now_dir = 0;
		}
		else if(dir == 'D') {
			if(now_dir == 0)
				now_dir = 3;
			else if(now_dir == 1)
				now_dir = 2;
			else if(now_dir == 2)
				now_dir = 0;
			else
				now_dir = 1;
		}
	}
}
