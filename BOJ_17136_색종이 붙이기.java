import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ANS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[10][10];
        ANS = Integer.MAX_VALUE;
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, 0);

        if(ANS == Integer.MAX_VALUE){
            ANS = -1;
        }

        System.out.println(ANS);
    }

    public static void DFS(int x, int y, int cnt){
        if(x >= 9 && y > 9){
            ANS = Math.min(ANS, cnt);
            return;
        }
        if(ANS <= cnt){
            return;
        }
        if(y > 9){
            DFS(x+1, 0, cnt);
            return;
        }

        if(arr[x][y] == 1){
            for(int i=5; i>=1; i--){
                if(paper[i] > 0 && isAttach(x, y, i)){
                    attach(x, y, i, 0);
                    paper[i] -= 1;
                    DFS(x, y+1, cnt+1);
                    attach(x, y, i, 1);
                    paper[i] += 1;
                }
            }
        }
        else{
            DFS(x, y+1, cnt);
        }
    }

    public static void attach(int x, int y, int size, int state){
        for(int i=x; i<x + size; i++){
            for(int j=y; j<y+size; j++){
                arr[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(i<0 || i>=10 || j<0 || j>=10){
                    return false;
                }

                if(arr[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}