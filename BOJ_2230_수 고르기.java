import java.io.*;
import java.util.*;

public class Main {

	public static int N, M;
	public static int[] arr;
	public static int ANS = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        int right = 0;
        int left = 0;
        
        while(right < N) {
        	if(arr[right] - arr[left] < M) {
        		right += 1;
        		continue;
        	}
        	if(arr[right] - arr[left] == M) {
        		ANS = M;
        		break;
        	}
        	
        	ANS = Math.min(ANS, arr[right] - arr[left]);
        	left += 1;
        }
        System.out.println(ANS);
    }
}