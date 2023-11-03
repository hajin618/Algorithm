import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        String name;
        int korean;
        int english;
        int math;

        Node(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Node o){
            if(this.korean == o.korean && this.english == o.english && this.math == o.math){
                return name.compareTo(o.name);
            }
            else if(this.korean == o.korean && this.english == o.english){
                return o.math - this.math;
            }
            else if(this.korean == o.korean){
                return this.english - o.english;
            }
            else
                return o.korean - this.korean;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Node(name, korean, english, math));
        }

        Collections.sort(list);

        for(Node now : list){
            sb.append(now.name).append("\n");
        }
        System.out.println(sb);
    }
}