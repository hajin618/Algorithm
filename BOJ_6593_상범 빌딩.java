import java.io.*;
import java.util.*;

public class Main {
	
	static int L, R, C;
	static char[][][] arr;
	static boolean[][][] visited;
	static int start_h, start_x, start_y;
	static int end_h, end_x, end_y;
	
	static int[] nl = {-1, 1, 0, 0, 0, 0};
	static int[] nr = {0, 0, -1, 1, 0, 0};
	static int[] nc = {0, 0, 0, 0, -1, 1};

	static class Node{
		int h;
		int x;
		int y;
		int time;
		Node(int h, int x, int y, int time){
			this.h = h;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	L = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	if(L==0 && R==0 && C==0) {
        		break;
        	}
        	
        	visited = new boolean[L][R][C];
        	arr = new char[L][R][C];
        	
        	for(int i=0; i<L; i++) {
        		for(int j=0; j<R; j++) {
        			String s = br.readLine();
        			for(int k=0; k<C; k++) {
        				arr[i][j][k] = s.charAt(k);
        				
        				if(arr[i][j][k] == 'S') {
        					start_h = i;
        					start_x = j;
        					start_y = k;
        					arr[i][j][k] = '.';
        				}
        				
        				if(arr[i][j][k] == 'E') {
        					end_h = i;
        					end_x = j;
        					end_y = k;
        					arr[i][j][k] = '.';
        				}
        			}
        		}
        		String s = br.readLine();
        	}
        	
        	int ANS = bfs(start_h, start_x, start_y);
        	
        	if(ANS == Integer.MAX_VALUE)
        		System.out.println("Trapped!");
        	else {
        		System.out.println("Escaped in "+ANS+" minute(s).");
        	}
        }
    }
    
    public static int bfs(int start_h, int start_x, int start_y) {
    	int cnt = Integer.MAX_VALUE;
    	
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(start_h, start_x, start_y, 0));
    	visited[start_h][start_x][start_y] = true;
    	
    	while(!queue.isEmpty()) {
    		Node now = queue.poll();
    		
    		if(now.h == end_h && now.x == end_x && now.y == end_y) {
    			cnt = now.time;
    			break;
    		}
    		
    		for(int p=0; p<6; p++) {
    			int next_h = now.h + nl[p];
    			int next_x = now.x + nr[p];
    			int next_y = now.y + nc[p];
    			
    			if(next_h < 0 || next_h >= L)
    				continue;
    			if(next_x < 0 || next_x >= R)
    				continue;
    			if(next_y < 0 || next_y >= C)
    				continue;
    			
    			if(!visited[next_h][next_x][next_y] && arr[next_h][next_x][next_y] == '.') {
    				visited[next_h][next_x][next_y] = true;
    				queue.add(new Node(next_h, next_x, next_y, now.time + 1));
    			}
    		}
    	}
    	
    	return cnt;
    }
}