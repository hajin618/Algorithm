import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[][] dist;	// 최소 거리
	public static int[][] firstVisited;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1][N+1];
        firstVisited = new int[N+1][N+1];
        
        for(int i=0; i<=N; i++) {
        	for(int j=0; j<=N; j++) {
        		if(i == j) {
        			dist[i][j] = 0;
        			firstVisited[i][j] = Integer.MAX_VALUE;
        		}
        		else {
        			dist[i][j] = Integer.MAX_VALUE;
        			firstVisited[i][j] = j;
        		}
        	}
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	dist[a][b] = c;
        	dist[b][a] = c;
        }
        
        for(int k=1; k<=N; k++) {
        	for(int i=1; i<=N; i++) {
        		if(i == k)		// 시작지 == 경유지
        			continue;
        		for(int j=1; j<=N; j++) {
        			if(i == j)	// 시작지 == 목적지
        				continue;
        			if(k == j)	// 경유지 == 목적지
        				continue;

        			if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
        				if(dist[i][k] + dist[k][j] < dist[i][j]) {
        					dist[i][j] = dist[i][k] + dist[k][j];
        					firstVisited[i][j] = firstVisited[i][k];
        				}
        			}
        			
        		}
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(i == j)
        			sb.append("- ");
        		else
        			sb.append(firstVisited[i][j] + " ");
        	}
        	sb.append("\n");
        }

        System.out.println(sb);

    }
 
}