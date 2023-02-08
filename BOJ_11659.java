import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[100003];
		int[] sum = new int[100003];
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		sum[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 1)
				sum[1] = arr[1];
			else
				sum[i] = sum[i-1] + arr[i];
		}	
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[b] - sum[a-1]);
		}
	}
}

