import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static StringBuilder sb;
	public static int N, M;
	public static int[] arr;
	public static int[] ans;
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        ans = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        func(0, 0);
        System.out.println(sb);
    }
    
    public static void func(int idx, int k) {
    	if(k == M) {
    		for(int i=0; i<M; i++) {
    			sb.append(ans[i]).append(" ");
    		}
    		sb.append("\n");
    		
    		return;
    	}
    	
    	int pre = 0;
    	for(int i=idx; i<N; i++) {
    		if(arr[i] != pre) {
    			ans[k] = arr[i];
    			pre = arr[i];
    			func(i, k+1);
    		}
    	}
    }
    
}