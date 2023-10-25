import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static List<Integer> list;
    static int ANS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int right = N-1;
        int left = 0;

        while(true){
            if(left >= right)
                break;

            if(list.get(right) + list.get(left) <= K){
                ANS += 1;
                left += 1;
                right -= 1;
            }
            else{
                right -= 1;
            }
        }
        System.out.println(ANS);
    }
}