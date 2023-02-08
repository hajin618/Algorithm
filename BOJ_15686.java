import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] house;
	public static int[][] chicken;
	public static int[] ans_chick;
	public static int house_cnt = 0;
	public static int chick_cnt = 0;
	public static boolean[] visited;
	public static int ans_min = 100*2500*13;
	
	public static void func(int idx, int cnt) {
		if(cnt == M) {
			// 선택된 조합에서 집들까지 최소 거리 계산
			int tmp_min_dist = 0;
			for(int i=0; i<house_cnt; i++) {
				int min_dist = 200;
				for(int j=0 ;j<M; j++) {
					int tmp_dist = dist(house[i][0], house[i][1], chicken[ans_chick[j]][0], chicken[ans_chick[j]][1]);
					if(min_dist > tmp_dist)
						min_dist = tmp_dist;
				}
				tmp_min_dist += min_dist;
			}
			
			if(ans_min > tmp_min_dist)
				ans_min = tmp_min_dist;
			
			return;
		}
		
		for(int i=idx; i<chick_cnt; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans_chick[cnt] = i;
				func(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new int[2*N +3][2];
		chicken = new int[15][2];
		ans_chick = new int[M];
		
		int a;
		int house_idx = 0;
		int chick_idx = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				a = Integer.parseInt(st.nextToken());
				
				if(a == 1) {
					house[house_idx][0] = i;
					house[house_idx][1] = j;
					house_idx += 1;
					house_cnt += 1;
				}
				else if(a == 2) {
					chicken[chick_idx][0] = i;
					chicken[chick_idx][1] = j;
					chick_idx += 1;
					chick_cnt += 1;
				}
			}
		}
		visited = new boolean[chick_cnt];
		
		func(0, 0);
		
		System.out.println(ans_min);
	}
}

