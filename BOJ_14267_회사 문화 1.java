import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int a = Integer.parseInt(st.nextToken());   // a : 상사, i : 부하

            // 부하 정보 저장
            if(a != -1)
                list[a].add(i);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum[a] += b;
        }

        // 1번부터 시작
        func(1);

        for(int i=1; i<=N ;i++){
            sb.append(sum[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void func(int a){
        for(int i : list[a]){
            sum[i] += sum[a];
            func(i);
        }
    }

}