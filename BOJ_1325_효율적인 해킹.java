import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static List<Integer>[] arr;
    public static int[] ans;
    public static boolean[] visited;

    public static void func(int start) {
    	int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int nowNum = queue.poll();
            cnt += 1;
            
            for(int i : arr[nowNum]) {
            	if(!visited[i]){
                    visited[i]= true;
                    queue.add(i);
                }
            }
        }
        
        ans[start] = cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        ans = new int[N+1];

        for(int i=0; i<N+1; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        int MAX = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            
            func(i);

            if(MAX == ans[i])
            	queue.add(i);
            else if(MAX < ans[i]) {
            	MAX = ans[i];
            	queue.clear();
            	queue.add(i);
            }
        }
        
        for(int a : queue) {
        	bw.write(a + " ");
        }

        bw.close();
    }

}