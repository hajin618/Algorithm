import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(a.equals("ChongChong")|| b.equals("ChongChong")){
                set.add(a);
                set.add(b);
                continue;
            }

            if(set.size() == 0)
                continue;

            if(set.contains(a))
                set.add(b);
            else if(set.contains(b))
                set.add(a);
        }
        System.out.println(set.size());
    }
}