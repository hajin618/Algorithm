package SSAFY;

import java.util.*;

public class Algorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            String s = sc.next();
            if(hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s)+1);
            }
            else{
                hashMap.put(s, 1);
            }
        }

        int max_cnt = 0;
        String ans = "";
        ArrayList<String> tmp_arr = new ArrayList<>();

        for(String s : hashMap.keySet()){
            if(max_cnt < hashMap.get(s)){
                ans = s;
                max_cnt = hashMap.get(s);
            }
            else if(max_cnt == hashMap.get(s)){
                tmp_arr.add(ans);
                tmp_arr.add(s);
                Collections.sort(tmp_arr);
                ans = tmp_arr.get(0);
                tmp_arr.clear();
            }
        }

        System.out.println(ans);

    }
}
