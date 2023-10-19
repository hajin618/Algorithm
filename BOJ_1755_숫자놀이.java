import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static class Node implements Comparable<Node>{
        int n;
        String s;
        Node(int n, String s){
            this.n = n;
            this.s = s;
        }

        @Override
        public int compareTo(Node o){
            return this.s.compareTo(o.s);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=M; i<=N; i++){
            String now = String.valueOf(i);
            String intToString = "";
            for(int j=0; j<now.length(); j++){
                intToString += num[now.charAt(j) - '0'];
            }
            list.add(new Node(i, intToString));
        }

        Collections.sort(list);

        for(int i=1; i<=list.size(); i++){
            sb.append(list.get(i-1).n).append(" ");
            if(i % 10 == 0)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}