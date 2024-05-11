import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, Integer> hashMap;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        hashMap = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            hashMap.put(st.nextToken(), 0);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String s = st.nextToken();

                hashMap.put(s, hashMap.get(s) + 1);
            }
        }

        list = new ArrayList<>(hashMap.keySet());

        list.sort((o1, o2) -> {
            if(hashMap.get(o1) == hashMap.get(o2))
                return o1.compareTo(o2);
            else
                return hashMap.get(o2) - hashMap.get(o1);
        });

        for(String s : list){
            sb.append(s).append(" ").append(hashMap.get(s)).append("\n");
        }

        System.out.print(sb);
    }
}