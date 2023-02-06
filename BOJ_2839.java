import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[5005];
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		arr[1] = -1;
		arr[2] = -1;
		arr[3] = 1;
		arr[4] = -1;
		arr[5] = 1;
		
		for(int i=6; i<=n; i++) {
			int a = arr[i-3];
			int b = arr[i-5];
			
			if(a==-1 && b==-1)
				arr[i] = -1;
			else if(a == -1)
				arr[i] = b + 1;
			else if(b == -1)
				arr[i] = a + 1;
			else{
				arr[i] = Math.min(a, b) + 1;				
			}
		}
		System.out.println(arr[n]);
	}
}
