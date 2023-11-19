import java.io.*;
import java.util.*;

public class Main{

    static int N, MAX;
    static long ANS;
    static HashMap<Long, Integer> map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            long a = Long.parseLong(br.readLine());

            map.put(a, map.getOrDefault(a, 0) +1);

            if(map.get(a) > MAX){
                MAX = map.get(a);
                ANS = a;
            }
            else if(map.get(a) == MAX){
                ANS = Math.min(ANS, a);
            }
        }
        
        System.out.println(ANS);
    }
}