import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr = new int[9];
    public static boolean[] ans = new boolean[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        sum = sum - 100;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(i == j)
                    continue;
                if(arr[i] + arr[j] == sum){
                    ans[i] = true;
                    ans[j] = true;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(!ans[i])
                System.out.println(arr[i]);
        }
    }
}-