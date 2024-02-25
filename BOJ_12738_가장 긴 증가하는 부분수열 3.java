import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            if(list.isEmpty()){
                list.add(arr[i]);
            }
            else if(list.get(list.size() - 1) < arr[i]){
                list.add(arr[i]);
            }
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= arr[i]){
                        right = mid;
                    }
                    else{
                        left = mid + 1;
                    }
                }

                list.set(right, arr[i]);
            }
        }

        System.out.println(list.size());
    }
}