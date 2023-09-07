import java.io.;
import java.util.;

public class Main{

    static int A, B, ANS;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        SetInteger set = new HashSet();

        st = new StringTokenizer(br.readLine());
        for(int i=0; iA; i++){
            int a = Integer.parseInt(st.nextToken());

            set.add(a);
        }
        ANS = set.size();

        st = new StringTokenizer(br.readLine());
        for(int i=0; iB; i++){
            int a = Integer.parseInt(st.nextToken());

            if(set.contains(a))
                ANS -= 1;
            else
                ANS += 1;
        }
        System.out.println(ANS);
    }
}