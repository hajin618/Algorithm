import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static char[][] arr;
	public static int[] ans;	// 뽑은 조합 저장
	public static int[][] newArr;
	public static int[] nr = {-1, 1, 0, 0};
	public static int[] nc = {0, 0, -1, 1};
	public static int CNT = 0;
	
	public static class Node{
		int i;
		int j;
		Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new char[5][5];
		ans = new int[7];
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		//25명 중 7명 조합 뽑기
		combination(0, 0);
		
		System.out.println(CNT);
	}
	
	public static void combination(int idx, int k) {
		if(k == 7) {
			if(countS() && readyBFS())
				CNT += 1;
			return;
		}
		
		for(int i=idx; i<25; i++) {
			ans[k] = i;
			combination(i+1, k+1);
		}
	}
	
	public static boolean countS() {
		int S = 0;
		int Y = 0;
		
		for(int i=0; i<7; i++) {
			int r = ans[i] / 5;
			int c = ans[i] % 5;
			
			if(arr[r][c] == 'S')
				S += 1;
			else
				Y += 1;
		}
		
		if(S >= 4)
			return true;
		else
			return false;
	}
	
	public static boolean readyBFS() {
		newArr = new int[5][5];
		
		for(int i=0; i<7; i++) {
			int r = ans[i] / 5;
			int c = ans[i] % 5;
			newArr[r][c] = 1;
		}
		
		L : for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(newArr[i][j] == 1) {
					BFS(i, j);
					break L;
				}
			}
		}
		
		boolean flag = true;
		
		L : for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(newArr[i][j] == 1) {
					flag = false;
					break L;
				}
			}
		}
		
		if(flag)
			return true;
		else
			return false;
	}
	
	public static void BFS(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(i, j));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			newArr[node.i][node.j] = 0;
			
			for(int p=0; p<4; p++) {
				int nextI = node.i + nr[p];
				int nextJ = node.j + nc[p];
				
				if(nextI>=0 && nextI<5 && nextJ>=0 && nextJ<5 && newArr[nextI][nextJ] == 1) {
					queue.add(new Node(nextI, nextJ));
				}
			}
		}
	}

}