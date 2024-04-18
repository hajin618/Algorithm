import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] arr;
    static boolean[][] newArr;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        newArr = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == '.')
                    continue;

                int tmp = 0;

                for(int p=0; p<4; p++){
                    int nextI = i + nr[p];
                    int nextJ = j + nc[p];

                    if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C){
                        tmp += 1;
                        continue;
                    }

                    if(arr[nextI][nextJ] == '.')
                        tmp += 1;
                }

                if(tmp >= 3){
                    newArr[i][j] = true;
                }
            }
        }

        int minR = R-1;
        int maxR = 0;
        int minC = C-1;
        int maxC = 0;

        // 행 확인
        for(int i=0; i<R; i++){
            boolean flag = false;
            for(int j=0; j<C; j++){
                if(!newArr[i][j] && arr[i][j] == 'X'){
                    flag = true;
                    break;
                }
            }

            if(flag){
                if(minR > i)
                    minR = i;
                if(maxR < i)
                    maxR = i;
            }
        }

        // 열 확인
        for(int i=0; i<C; i++){
            boolean flag = false;
            for(int j=0; j<R; j++){
                if(!newArr[j][i] && arr[j][i] == 'X'){
                    flag = true;
                    break;
                }
            }

            if(flag){
                if(minC > i)
                    minC = i;
                if(maxC < i)
                    maxC = i;
            }
        }

        for(int i=minR; i<=maxR; i++){
            for(int j=minC; j<=maxC; j++){
                if(arr[i][j] == 'X' && !newArr[i][j])
                    sb.append("X");
                else
                    sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}