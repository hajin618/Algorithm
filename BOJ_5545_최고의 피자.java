import java.io.*;
import java.util.*;

public class Main {

    static int N, A, B, C;
    static int PRICE, KCAL, ANS;
    static List<Integer> d_list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());   // 도우 가격
        B = Integer.parseInt(st.nextToken());   // 토핑 가격
        C = Integer.parseInt(br.readLine());    // 도우 열량

        d_list = new ArrayList<>();
        for(int i=0; i<N; i++){
            d_list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(d_list, Collections.reverseOrder());

        PRICE = A;
        KCAL = C;
        ANS = KCAL / PRICE;

        for(int i=0; i<N; i++){
            PRICE += B;
            KCAL += d_list.get(i);

            int tmp = KCAL / PRICE;

            if(tmp >= ANS)
                ANS = tmp;
            else{
                break;
            }
        }
        System.out.println(ANS);
    }
}