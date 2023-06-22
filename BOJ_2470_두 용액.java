import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int left = 0;
        int right = N - 1;
        int sum = Integer.MAX_VALUE;

        int ans1 = 0;
        int ans2 = 0;

        while(left < right){
            int tmp = list.get(left) + list.get(right);
            int tmpAbs = Math.abs(tmp);

            if(tmpAbs < sum){
                ans1 = list.get(left);
                ans2 = list.get(right);
                sum = tmpAbs;
            }

            if(tmp > 0)
                right -= 1;
            else left += 1;
        }

        System.out.println(ans1 + " " + ans2);

    }
}