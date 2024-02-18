import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        TreeSet<Integer> ts = new TreeSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int cnt = 0;
        for(int i=0; i<N; i++){
            hm.put(arr[i], ++cnt);
            ts.add(arr[i]);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            Integer a = Integer.parseInt(st.nextToken());
            Integer b = Integer.parseInt(st.nextToken());

            a = ts.lower(a);
            b = ts.floor(b);

            a = a==null?0:hm.get(a);
            b = b==null?0:hm.get(b);

            sb.append(b-a).append("\n");
        }

        System.out.println(sb);
    }
}