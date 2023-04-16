import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[][] dist;	// 최소 비용
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        dist = new int[N+1][N+1];
        for(int i=0; i<=N; i++) {
        	for(int j=0; j<=N; j++) {
        		if(i == j)
        			dist[i][j] = 0;
        		else
        			dist[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	dist[a][b] = Math.min(dist[a][b], c);
        }
        
        for(int k=1; k<=N; k++) {
        	for(int i=1; i<=N; i++) {
        		if(i == k)
        			continue;
        		for(int j=1; j<=N; j++) {
        			if(i == j || j == k)
        				continue;
        			
        			if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
        				if(dist[i][j] > dist[i][k] + dist[k][j]) {
            				dist[i][j] = dist[i][k] + dist[k][j];
            			}
        			}

        		}
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(dist[i][j] == Integer.MAX_VALUE)
        			sb.append(0).append(" ");
        		else
        			sb.append(dist[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
}