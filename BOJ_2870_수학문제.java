import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int N;
    static List<BigInteger> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String s;
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            s = br.readLine();

            int len = s.length();
            String s_tmpInt = "";
            BigInteger tmp_bi;
            for(int j=0; j<len; j++){

                if(s.charAt(j)-'0' >= 0 && s.charAt(j)-'0' <= 9){
                    s_tmpInt += s.charAt(j);
                    continue;
                }

                if(!s_tmpInt.isEmpty()){
                    tmp_bi = new BigInteger(s_tmpInt);
                    list.add(tmp_bi);
                    s_tmpInt = "";
                }
            }
            if(!s_tmpInt.isEmpty()){
                tmp_bi = new BigInteger(s_tmpInt);
                list.add(tmp_bi);
            }
        }
        Collections.sort(list);
        int len = list.size();
        for(int i=0; i<len; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}