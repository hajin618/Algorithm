import java.io.*;
import java.util.*;

public class Main{

    static int N, M;
    static String[] strings;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strings = new String[N];
        nums = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            strings[i] = st.nextToken();
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int n = Integer.parseInt(br.readLine());

            String s = FUNC(n);
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static String FUNC(int n){
        int left = 0;
        int right = N - 1;

        while(left <= right){
            int middle = (left + right) / 2;

            if(n <= nums[middle]){
                right = middle - 1;
            }
            else if(n > nums[middle]){
                left = middle + 1;
            }
        }
        return strings[right + 1];
    }
}