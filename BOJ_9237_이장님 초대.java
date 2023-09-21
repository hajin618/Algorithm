import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        Collections.reverse(list);

        int max = 0;
        for(int i=0; i<N; i++){
            if(max < list.get(i) + i + 2){
                max = list.get(i) + i + 2;
            }
        }
        System.out.println(max);
    }
}