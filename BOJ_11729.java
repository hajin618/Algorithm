import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	
	// 원반 개수, 시작기둥, 목적기둥, 임시기둥
	public static void hanoi(int n, int start, int end, int tmp) {
		if(n == 0) {
			return;
		}
			
		hanoi(n-1, start, tmp, end);
		//System.out.println(start + " " + end);
		//ans += start + " " + end + "\n";
		sb.append(start).append(" ").append(end).append("\n");
		cnt += 1;
		hanoi(n-1, tmp, end, start);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		hanoi(n, 1, 3, 2);
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
