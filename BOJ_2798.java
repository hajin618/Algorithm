import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//n개 중 3개 뽑기, m을 넘지 않는 합 최대
	public static int n, m;
	public static int[] arr;
	public static int[] ans = new int[3];
	public static int max_sum = 0;
	
	public static void func(int idx, int k) {
		if(k==3) {
			int sum = ans[0] + ans[1] + ans[2];
			if(sum > m)
				return;
			if(sum > max_sum)
				max_sum = sum;
			
			return;
		}
		
		for(int i=idx; i<n; i++) {
			ans[k] = arr[i];
			func(i+1, k+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, 0);
		
		System.out.println(max_sum);
	}
}

