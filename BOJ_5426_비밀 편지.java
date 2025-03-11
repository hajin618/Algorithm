import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            int len = s.length();
            int size = (int)Math.sqrt(len);
            arr = new char[size][size];

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    arr[i][j] = s.charAt(i*size + j);
                }
            }

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    sb.append(arr[j][size-i-1]);
                }
            }

            System.out.println(sb);
        }
    }
}