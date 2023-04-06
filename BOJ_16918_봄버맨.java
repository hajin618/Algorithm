import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] arr;
	public static int R, C, N;
	public static int TIME = 1;
	public static int[] nr = {-1, 1, 0, 0};
	public static int[] nc = {0, 0, -1, 1};
	public static Queue<Node> queue;
	
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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[R][C];
        
        for(int i=0; i<R; i++) {
        	String s = br.readLine();
        	for(int j=0; j<C; j++) {
        		char c = s.charAt(j);
        		
        		if(c == '.')
        			arr[i][j] = 0;
        		else
        			arr[i][j] = 2;
        	}
        }
        
        while(true) {
        	
        	if(TIME == N) {
        		break;
        	}
        	
        	TIME += 1;
        	for(int i=0; i<R; i++) {
        		for(int j=0; j<C; j++) {
        			if(arr[i][j] != 0)
        				arr[i][j] -= 1;
        		}
        	}
        	// 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
        	for(int i=0; i<R; i++) {
        		for(int j=0; j<C; j++) {
        			if(arr[i][j] == 0)
        				arr[i][j] = 3;
        		}
        	}
        	
        	if(TIME == N) {
        		break;
        	}
        	
        	TIME += 1;
        	for(int i=0; i<R; i++) {
        		for(int j=0; j<C; j++) {
        			arr[i][j] -= 1;
        		}
        	}
        	
        	// 0인 폭탄과 인접 네 칸 없어짐
        	queue = new LinkedList<>();
        	for(int i=0; i<R; i++) {
        		for(int j=0; j<C; j++) {
        			if(arr[i][j] == 0)
        				queue.add(new Node(i, j));
        		}
        	}
        	
        	while(!queue.isEmpty()) {
        		Node now = queue.poll();
        		int nowX = now.i;
        		int nowY = now.j;
        		
        		for(int p=0; p<4; p++) {
        			int nextX = nowX + nr[p];
        			int nextY = nowY + nc[p];
        			
        			if(nextX>=0 && nextX<R && nextY>=0 && nextY<C)
        				arr[nextX][nextY] = 0;
        		}
        	}
        }
        
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(arr[i][j] == 0)
        			sb.append(".");
        		else
        			sb.append("O");
        			
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}

}
