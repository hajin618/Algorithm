import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		for(int test_case = 1; test_case <=10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean flag = true;
			
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			
			for(int i=0; i<n; i++) {
				char c = s.charAt(i);
				if(c == '(' || c == '[' || c == '{' || c == '<') {
					stack.add(c);
				}
				else if(c == ')') {
					if(stack.pop() != '(') {
						flag = false;
						break;
					}
				}
				else if(c == ']') {
					if(stack.pop() != '[') {
						flag = false;
						break;
					}
				}
				else if(c == '}') {
					if(stack.pop() != '{') {
						flag = false;
						break;
					}
				}
				else if(c == '>') {
					if(stack.pop() != '<') {
						flag = false;
						break;
					}
				}
				
			}
			
			if(flag)
				System.out.printf("#%d 1\n", test_case);
			else
				System.out.printf("#%d 0\n", test_case);
			
		}
		
	}
}
	
