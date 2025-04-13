import java.io.*;
import java.util.*;

public class Main {

    static int C, R, K;
    static int[] nr = {-1, 0, 1, 0};
    static int[] nc = {0, 1, 0, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new int[R+2][C+2];

        for(int i=0; i<C+2; i++){
            arr[0][i] = -1;
            arr[R+1][i] = -1;
        }
        for(int i=0; i<R+2; i++){
            arr[i][0] = -1;
            arr[i][C+1] = -1;
        }

        if(K > C*R){
            System.out.println(0);
            return;
        }

        int nowX = R;
        int nowY = 1;
        int num = 1;
        int dir = 0; // 상우하좌 0123

        while(true){
            arr[nowX][nowY] = num;
            if(num == K){
                System.out.println(nowY + " " + (R-nowX+1));
                break;
            }

            if(arr[nowX + nr[dir]][nowY + nc[dir]] != 0){
                dir = (dir+1) % 4;
            }

            nowX += nr[dir];
            nowY += nc[dir];
            num += 1;

            if(num > C*R) break;
        }
    }
}