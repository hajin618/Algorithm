import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	public static int n;
	public static int[] arr;
	public static boolean flag = false;
	
	public static void func(int idx) {
		
		// arr 좋은 수열인지 판별
		for(int i=1; i<=idx/2; i++) {
			String s1 = "";
			String s2 = "";
			for(int j=1; j<=i; j++) {
				s1 += Integer.toString(arr[idx-j]);
				s2 += Integer.toString(arr[idx-j-i]);
			}

			if(s1.equals(s2)) {
				// 같으면 나쁜수열
				return;
			}
		}
				
		if(idx == n) {
			flag = true;
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]);
			}
			
			return;
		}
		
		for(int i=1; i<=3; i++) {
			
			arr[idx] = i;
			func(idx+1);
			if(flag)
				break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int [n];
		arr[0] = 1;
		func(1);

	}
}

