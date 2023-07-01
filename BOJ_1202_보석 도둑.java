import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static List<jewel> jewelList;
    static List<Integer> bag;
    static PriorityQueue<Integer> pq;

    static class jewel implements Comparable<jewel>{
        int weight;
        int price;
        jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(jewel o){
            return this.weight - o.weight;
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewelList = new ArrayList<>();
        bag = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            jewelList.add(new jewel(w, p));
        }

        for(int i=0; i<K; i++){
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        Collections.sort(jewelList);

        long sum = 0;
        int idx = 0;
        
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<K; i++){
            for(int j=idx; j<N; j++){
                if(jewelList.get(j).weight <= bag.get(i)){
                    idx += 1;
                    pq.add(jewelList.get(j).price);
                }
                else{
                    break;
                }
            }

            if(pq.isEmpty())
                continue;

            sum += pq.poll();
        }

        System.out.println(sum);
    }
}