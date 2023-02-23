import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

    static StringBuilder sb = new StringBuilder();
    static int T, N, M, R, C, L;
    static int[][] arr;
    static boolean[][] visited;
    static int ans;
    
    static int[] r1 = {-1, 1, 0, 0};
    static int[] c1 = {0, 0, -1, 1};
    
    static int[][] r2 = {
    		{0, 0},
    		{0, 0},
    		{-1, 1},
    		{0, 0},
    		{-1, 0},
    		{0, 1},
    		{0, 1},
    		{-1, 0}
    };
    
    static int[][] c2 = {
    		{0, 0},
    		{0, 0},
    		{0, 0},
    		{-1, 1},
    		{0, 1},
    		{1, 0},
    		{-1, 0},
    		{0, -1}
    };
    
    static class Node{
    	int i;
    	int j;
    	int time;
    	
    	Node(int i, int j, int time){
    		this.i = i;
    		this.j = j;
    		this.time = time;
    	}
    }
    
    public static void func(int i, int j, int l) {
    	
    	Queue<Node> queue = new LinkedList<>();
    	
    	if(l <= L && arr[i][j] != 0) {
    		ans += 1;
        	queue.add(new Node(i, j, l));
        	visited[i][j] = true;
    	}
    		
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		int ii = node.i;
    		int jj = node.j;
    		int ll = node.time;
    		
    		
    		if(arr[ii][jj] == 1) {
    			for(int p=0; p<4; p++) {
    				int iii = ii + r1[p];
    				int jjj = jj + c1[p];
    				
    				if(iii>=0 && iii<N && jjj>=0 && jjj<M && !visited[iii][jjj] && arr[iii][jjj]!=0 && ll+1<=L) {
    					
    					if(check1(ii, jj, p)) {
    					visited[iii][jjj] = true;
    					
						ans += 1;
						
    					queue.add(new Node(iii, jjj, ll+1));
    					}
    				}
    			}
    		}
    		else if(arr[ii][jj] != 0){
    			for(int p=0; p<2; p++) {
    				int iii = ii + r2[arr[ii][jj]][p];
    				int jjj = jj + c2[arr[ii][jj]][p];
    				
    				if(iii>=0 && iii<N && jjj>=0 && jjj<M && !visited[iii][jjj] && arr[iii][jjj]!=0 && ll+1<=L) {
    					
    					if(check2(ii, jj, p)) {
    						visited[iii][jjj] = true;
        					
    						ans += 1;
        					queue.add(new Node(iii, jjj, ll+1));
    					}
    				}
    			}
    		}
    	}
    }
    
    public static boolean check1(int ii, int jj, int p) {
    	int now = arr[ii][jj];				// 현재
    	int iii = ii + r1[p];
    	int jjj = jj + c1[p];
		int next = arr[iii][jjj];	// 다음
		
    	if(next == 1)
    		for(int q = 0; q < 4; q++) {
    			if((iii + r1[q]) == ii && jjj + c1[q] == jj)
    				return true;
    		}
    	else {
    		for(int q = 0; q < 2; q++) {
    			if((iii + r2[arr[iii][jjj]][q]) == ii && jjj + c2[arr[iii][jjj]][q] == jj)
    				return true;
    		}
    	}
    	return false;
    }

    public static boolean check2(int ii, int jj, int p) {
    	int now = arr[ii][jj];				// 현재
    	int iii = ii + r2[arr[ii][jj]][p];
    	int jjj = jj + c2[arr[ii][jj]][p];
		int next = arr[iii][jjj];	// 다음
		
    	if(next == 1)
    		for(int q = 0; q < 4; q++) {
    			if((iii + r1[q]) == ii && jjj + c1[q] == jj)
    				return true;
    		}
    	else {
    		for(int q = 0; q < 2; q++) {
    			if((iii + r2[arr[iii][jjj]][q]) == ii && jjj + c2[arr[iii][jjj]][q] == jj)
    				return true;
    		}
    	}
    	
    	return false;
    }
    

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	
        	ans = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	L = Integer.parseInt(st.nextToken());
        	
        	arr = new int[N][M];
        	visited = new boolean[N][M];
        	
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<M; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
            
        	func(R, C, 1);
        	
        	System.out.printf("#%d %d\n", test_case, ans);
        }
    }
}
