import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{

    static int N, M;
    static Map<String, Integer> map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();

            if(s.length() < M)
                continue;

            int cnt = map.getOrDefault(s, 0);
            map.put(s, cnt + 1);
        }

        List<String> list = map.keySet().stream().collect(Collectors.toList());

        list.sort((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            if(c1 == c2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length();
            }

            return c2 - c1;
        });

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}