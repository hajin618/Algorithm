import java.io.*;
import java.util.*;

public class Main{
    static int nA, nB;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nA; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nB; i++){
            set.remove(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());
        List<Integer> list = new ArrayList<>();
        for(int a : set){
            list.add(a);
        }
        Collections.sort(list);
        for(int a : list){
            System.out.print(a + " ");
        }
    }
}