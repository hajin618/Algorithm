import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static List<Integer> list;
    static int ANS = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        // 1 위치 list에 저장
        for(int i=0; i<N; i++){
            if(Integer.parseInt(st.nextToken()) == 1){
                list.add(i);
            }
        }

        if(list.size() < K){
            ANS = -1;
        }
        else{
            int left = 0;
            int right = K-1;

            while(right < list.size()){

                ANS = Math.min(ANS, list.get(right) - list.get(left) + 1);

                left += 1;
                right += 1;
            }
        }

        System.out.println(ANS);

    }
}
