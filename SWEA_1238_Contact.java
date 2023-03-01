
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static int START;
    public static HashMap<Integer, ArrayList<Integer>> list;
    public static List<Integer>[] cntList;
    public static boolean[] visited;
    public static int MAXCNT = 0;

    public static class Node{
        int num;
        int cnt;

        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case=1; test_case<=10; test_case++){

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            START = Integer.parseInt(st.nextToken());

            list = new HashMap<>();
            MAXCNT = 0;

            cntList = new ArrayList[101];
            for(int i=0; i<101; i++){
                cntList[i] = new ArrayList<>();
            }
            visited = new boolean[101];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; i++){
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                boolean flag = false;
                for(Integer I : list.keySet()){
                    if(I == s){
                        flag = true;
                        list.get(s).add(e);
                    }
                }
                if(!flag){
                    list.put(s, new ArrayList<>());
                    list.get(s).add(e);
                }
            }

            func(START);

            int max = 0;
            for(int i=0; i<cntList[MAXCNT].size(); i++){
                if(max < cntList[MAXCNT].get(i)){
                    max = cntList[MAXCNT].get(i);
                }
            }

            System.out.printf("#%d %d\n", test_case, max);


        }
    }

    public static void func(int start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nowNum = node.num;
            int nowCnt = node.cnt;

            if(MAXCNT < nowCnt)
                MAXCNT = nowCnt;

            cntList[nowCnt].add(nowNum);

            boolean flag = false;
            for(Integer I : list.keySet()){
                if(I == nowNum)
                    flag = true;
            }
            if(flag) {
                for (int i = 0; i < list.get(nowNum).size(); i++) {
                    int nextNum = list.get(nowNum).get(i);

                    if (!visited[nextNum]) {
                        queue.add(new Node(nextNum, nowCnt + 1));
                        visited[nextNum] = true;


                    }
                }
            }


        }
    }
}