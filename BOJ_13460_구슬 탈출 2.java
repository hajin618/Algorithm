import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	public static int N, M;
    public static char[][] arr;
    public static int ANS = Integer.MAX_VALUE;
    public static int[] nr = {-1, 1, 0, 0};
    public static int[] nc = {0, 0, -1, 1};
    
    public static class Info{
    	int Rx, Ry, Bx, By;	// dir : 0123=상하좌우
    	boolean result;		// result : true = 굴리기 성공, 다음 굴리기 진행
        					//			false = 굴리기 실패 ( 빨간공 들어감, 파란공 들어감, 둘 다 위치 변화 없음)
    	
    	Info(int Rx, int Ry, int Bx, int By, boolean result){
    		this.Rx = Rx;
    		this.Ry = Ry;
    		this.Bx = Bx;
    		this.By = By;
    		this.result = result;
    	}
    }
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int Rx = 0; int Ry = 0; int Bx = 0; int By = 0;
        
        arr = new char[N][M];
        
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j);
                
                if(arr[i][j] == 'R') {
                    Rx = i;
                    Ry = j;
                    arr[i][j] = '.';
                }
                else if(arr[i][j] == 'B') {
                    Bx = i;
                    By = j;
                    arr[i][j] = '.';
                }
            }
        }
        
        for(int i=0; i<4; i++) {
        	func(1, i, new Info(Rx, Ry, Bx, By, true));
        }
        
        if(ANS == Integer.MAX_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(ANS);
        
        
    }
    
    // dir : 상하좌우=0123
    
    public static void func(int cnt, int dir, Info info) {
    	if(cnt == 11) {
    		return;
    	}
        
        if(ANS < cnt)
    		return;
    	
    	int Rx = info.Rx;
    	int Ry = info.Ry;
    	int Bx = info.Bx;
    	int By = info.By;
    	
    	//Info nextInfo = info;
    	Info endRed = info;
    	Info endBlue = info;
    	Info end = info;
    	
    	
    	// 위로 기울이는 경우 : 더 위에 있는 구슬부터 굴리기
    	if(dir == 0) {
    		if(Rx < Bx) {
    			endRed = goRed(cnt, info, dir);
    			endBlue = goBlue(cnt, endRed, dir);
    			end = endBlue;
    		}
    		else {
    			endBlue = goBlue(cnt, info, dir);
    			endRed = goRed(cnt, endBlue, dir);
    			end = endRed;
    		}
    	}
    	// 아래로 기울이는 경우 : 더 아래에 있는 구슬부터 굴리기
    	else if(dir == 1) {
    		if(Rx > Bx) {
    			endRed = goRed(cnt, info, dir);
    			endBlue = goBlue(cnt, endRed, dir);
    			end = endBlue;
    		}
    		else {
    			endBlue = goBlue(cnt, info, dir);
    			endRed = goRed(cnt, endBlue, dir);
    			end = endRed;
    		}
    	}
    	// 왼쪽으로 기울이는 경우 : 더 왼쪽에 있는 구슬부터 굴리기
    	else if(dir == 2) {
    		if(Ry < By) {
    			endRed = goRed(cnt, info, dir);
    			endBlue = goBlue(cnt, endRed, dir);
    			end = endBlue;
    		}
    		else {
    			endBlue = goBlue(cnt, info, dir);
    			endRed = goRed(cnt, endBlue, dir);
    			end = endRed;
    		}
    	}
    	// 오른쪽으로 기울이는 경우 : 더 오른쪽에 있는 구슬부터 굴리기
    	else if(dir == 3) {
    		if(Ry > By) {
    			endRed = goRed(cnt, info, dir);
    			endBlue = goBlue(cnt, endRed, dir);
    			end = endBlue;
    		}
    		else {
    			endBlue = goBlue(cnt, info, dir);
    			endRed = goRed(cnt, endBlue, dir);
    			end = endRed;
    		}
    	}
    	
    	// 빨간구슬 들어감 파란구슬 안들어감
    	if(!endRed.result && endBlue.result) {
    		if(cnt < ANS)
    			ANS = cnt;
    		return;
    	}
    	
    	// 빨간 구슬과 파란 구슬 처음위치와 모두 동일하면 nextInfo.result = false
    	if(info.Rx==end.Rx && info.Ry==end.Ry && info.Bx==end.Bx && info.By==end.By) {
    		end.result = false;
    	}
    	
    	
    	if(endRed.result && endBlue.result) {
    		for(int i=0; i<4; i++) {
    			func(cnt+1, i, end);
    		}
    	}
    	
    }
 
    public static Info goRed(int cnt, Info info, int dir) {
    	
    	boolean result = true;
    	int nowX = info.Rx;
    	int nowY = info.Ry;
    	int nextX = info.Rx;
    	int nextY = info.Ry;
    	
    	while(true) {
    		nextX = nowX + nr[dir];
    		nextY = nowY + nc[dir];
    		
    		if(arr[nextX][nextY] == '.') {
    			nowX = nextX;
    			nowY = nextY;
    		}
    		else if(arr[nextX][nextY] == 'O') {

    			nowX = nextX;
    			nowY = nextY;
    			result = false;
    			
    			break;
    		}
    		else {
    			break;
    		}
    	}
    	
    	if(nowX == info.Bx && nowY == info.By) {
    		nowX -= nr[dir];
    		nowY -= nc[dir];
    	}
    	
    	return new Info(nowX, nowY, info.Bx, info.By, result);
    }

    public static Info goBlue(int cnt, Info info, int dir) {
    	
    	boolean result = true;
    	int nowX = info.Bx;
    	int nowY = info.By;
    	int nextX = info.Bx;
    	int nextY = info.By;
    	
    	while(true) {
    		nextX = nowX + nr[dir];
    		nextY = nowY + nc[dir];
    		
    		if(arr[nextX][nextY] == '.') {
    			nowX = nextX;
    			nowY = nextY;
    		}
    		else if(arr[nextX][nextY] == 'O') {
    			result = false;
    			nowX = nextX;
    			nowY = nextY;
    			break;
    		}
    		else {
    			break;
    		}
    	}
    	
    	if(nowX == info.Rx && nowY == info.Ry) {
    		nowX -= nr[dir];
    		nowY -= nc[dir];
    	}
    	
    	return new Info(info.Rx, info.Ry, nowX, nowY, result);
    }
}