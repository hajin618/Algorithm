import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int maxCnt = 2;

        for(int i=1; i<=N; i++){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(N);
            tmpList.add(i);

            int first = N;
            int sec = i;

            while(true){
                int tmp = first - sec;
                if(tmp >= 0){
                    tmpList.add(tmp);
                }
                if(tmp < 0)
                    break;
                first = sec;
                sec = tmp;
            }

            if(tmpList.size() >= maxCnt){
                maxCnt = tmpList.size();
                list = tmpList;
            }
        }

        System.out.println(maxCnt);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}