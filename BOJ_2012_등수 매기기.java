import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> list;
    static Long ANS = 0L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for(int i=0; i<N; i++){
            ANS += Math.abs(list.get(i) - (i + 1));
        }

        System.out.println(ANS);
    }
}