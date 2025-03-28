import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        list.sort((o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            } else{
                int sum1 = 0;
                int sum2 = 0;
                for(int i=0; i< o1.length(); i++){
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if(num1 > 0 && num1 < 10){
                        sum1 += num1;
                    }
                    if(num2 > 0 && num2 < 10){
                        sum2 += num2;
                    }
                }
                if(sum1 == sum2){
                    return o1.compareTo(o2);
                }
                return sum1-sum2;
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(list.get(i));
        }
    }
}