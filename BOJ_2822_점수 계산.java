import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int score;

        Node(int num, int score){
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Node o){
            return o.score - this.score;
        }
    }

    static List<Node> list;
    static List<Integer> ansList;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();
        ansList = new ArrayList<>();

        for(int i=1; i<=8; i++){
            int s = Integer.parseInt(br.readLine());

            list.add(new Node(i, s));
        }

        Collections.sort(list);

        int sum = 0;
        for(int i=0; i<5; i++){
            sum += list.get(i).score;
            ansList.add(list.get(i).num);
        }

        Collections.sort(ansList);

        for(int i=0; i<5; i++){
            sb.append(ansList.get(i)).append(" ");
        }

        System.out.println(sum);
        System.out.print(sb);
    }
}