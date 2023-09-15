import java.io.*;
import java.util.*;

public class Main {
    static int N, ANS;
    static String type;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        type = st.nextToken();

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        if(type.equals("Y")){
            ANS = set.size();
        }
        else if(type.equals("F")){
            ANS = set.size() / 2;
        }
        else{
            ANS = set.size() / 3;
        }

        System.out.println(ANS);
    }
}