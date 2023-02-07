import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	static int[] ans;
	static int k;
	
	public static void func(int idx, int cnt) {
		if(cnt == 6) {
			for(int i=0; i<6; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=idx; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[cnt] = arr[i];
				func(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0)
				break;
			else {
				arr = new int[15];
				visited = new boolean[50];
				ans = new int[7];
				
				for(int i=0; i<k; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				func(0, 0);
                System.out.println();
			}
		}
	}
}
