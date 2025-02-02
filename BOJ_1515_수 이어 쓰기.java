import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        int idx = 0;
        int num = 0;
        
        while(num++ <= 30000){
            String tmpS = String.valueOf(num);

            for(int i=0; i<tmpS.length(); i++){
                if(tmpS.charAt(i) == s.charAt(idx)){
                    idx += 1;
                }
                if(idx == len){
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}