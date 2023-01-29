import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 자바에서 큐는 LinkedList 활용
        // top : peek, pop : remove
        Queue<Integer> que = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int a=0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")) {
                a = Integer.parseInt(st.nextToken());
                que.add(a);
            }
            else if(s.equals("pop")) {
                if(que.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                }
                else {
                    bw.write(Integer.toString(que.poll()));
                    bw.newLine();
                }
            }
            else if(s.equals("size")) {
                int b = que.size();
                bw.write(Integer.toString(b));
                bw.newLine();
            }
            else if(s.equals("empty")) {
                if(que.isEmpty()){
                    bw.write("1");
                    bw.newLine();
                }
                else{
                    bw.write("0");
                    bw.newLine();
                }
            }
            else if(s.equals("front")) {
                if(que.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(Integer.toString(que.peek()));
                    bw.newLine();
                }
            }
            else if(s.equals("back")) {
                if(que.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                }
                else {
                    bw.write(Integer.toString(a));
                    bw.newLine();
                }
            }
        }
        bw.close();
        br.close();
    }
}

