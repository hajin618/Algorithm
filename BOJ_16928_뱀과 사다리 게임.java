import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	
	public static int N, M;
	public static int[][] arr;
	public static int MIN = Integer.MAX_VALUE;
	public static int[] CNT;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+M][2];
        CNT = new int[101];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i+N][0] = Integer.parseInt(st.nextToken());
        	arr[i+N][1] = Integer.parseInt(st.nextToken());
        }
//        for(int i=0; i<N; i++) {
//        	System.out.println(arr[i][0] + " " + arr[i][1]);
//        }
        DFS(1, 0);
        
        System.out.println(MIN);
	}
	
	public static void DFS(int now, int cnt) {
//		System.out.println(now + " " + cnt);		
		if(now == 100) {
			if(cnt < MIN) {
				MIN = cnt;
			}
			return;
		}
		
		if(cnt > MIN)
			return;
		
		if(CNT[now] == 0)
			CNT[now] = cnt;
		
		if(CNT[now] < cnt)
			return;
		else
			CNT[now] = cnt;
		
		int tmpNow = now;

		boolean flag = false;
		// 사다리 또는 뱀 있는지 확인
		for(int i=0; i<N+M; i++) {
			if(tmpNow == arr[i][0]) {
				flag = true;
				tmpNow = arr[i][1];
				DFS(tmpNow, cnt);
				break;
			}
		}
		
		if(!flag) {
			for(int j=1; j<=6; j++) {
				if(tmpNow + j <= 100) {
					DFS(tmpNow+j, cnt+1);
				}
				
			}
		}
	}

}
