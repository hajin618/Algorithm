import java.io.*;
import java.util.*;

public class Main{
    static long s, t;
    static char[] symbol = {'*', '+', '-', '/'};

    static class Node{
        long num;
        String s;

        Node(long num, String s){
            this.num = num;
            this.s = s;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        System.out.println(BFS());
    }

    public static String BFS(){
        Set<Long> set = new HashSet<>();

        if(s == t){
            return "0";
        }

        Queue<Node> queue = new LinkedList<>();
        set.add(s);

        queue.add(new Node(s, ""));
        while(!queue.isEmpty()){
            Node now = queue.poll();

            long nextNum = 0;

            if(now.num == t){
                return now.s;
            }

            for(int i=0; i<4; i++){
                if(i == 0){
                    nextNum = now.num * now.num;
                }
                else if(i == 1){
                    nextNum = now.num + now.num;
                }
                else if(i == 2){
                    nextNum = now.num - now.num;
                }
                else if(i == 3 && now.num != 0){
                    nextNum = now.num / now.num;
                }

                if(!set.contains(nextNum)){
                    set.add(nextNum);
                    queue.add(new Node(nextNum, now.s + symbol[i]));
                }
            }
        }

        return "-1";
    }
}