import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] start;
    static List<Info> treeInfo;
    static long ANS;

    static class Info implements Comparable<Info>{
        int start;
        int grow;

        Info(int start, int grow){
            this.start = start;
            this.grow = grow;
        }

        @Override
        public int compareTo(Info o){
            return this.grow - o.grow;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        start = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            start[i] = Integer.parseInt(st.nextToken());
        }

        treeInfo = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());

            treeInfo.add(new Info(start[i], tmp));
        }

        Collections.sort(treeInfo);

        ANS = 0;
        for(int i=0; i<n; i++){
            Info info = treeInfo.get(i);
            ANS += info.start + (info.grow * i);
        }

        System.out.println(ANS);
    }
}