import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		for(int test_case = 1; test_case <=10; test_case++) {
			Queue<Integer> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				int a = Integer.parseInt(st.nextToken());
				q.add(a);
			}

			int idx = 1;
			while(true) {
				int a = q.remove() - idx;
				
				if(a <= 0) {
					q.add(0);
					break;
				}
				else {
					q.add(a);
					idx += 1;
					
					if(idx == 6)
						idx = 1;
				}
			}
			
			System.out.printf("#%d ", test_case);
			for(int i=0; i<8; i++) {
				System.out.print(q.remove() + " ");
			}
			System.out.println();
		}
	}
}
	
