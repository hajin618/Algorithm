import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static Map<String, Integer> map;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String s = st.nextToken();

            if(!map.containsKey(s)){
                list.add(s);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Collections.sort(list);

        for(String s : list){
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}