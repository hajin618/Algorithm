import java.io.*;
import java.util.*;
public class Main {
    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V+1][V+1];

        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }

        // i ~ j 거리
        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                if(k == i)
                    continue;

                for(int j=1; j<=V; j++){
                    if(k == j || i == j)
                        continue;

                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        if(dist[i][j] > dist[i][k] + dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        // 사이클 존재하면 최소 사이클
        int ANS = Integer.MAX_VALUE;

        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i == j)
                    continue;

                if(dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE){
                    ANS = Math.min(ANS, dist[i][j] + dist[j][i]);
                }
            }
        }

        if(ANS == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(ANS);

    }
}