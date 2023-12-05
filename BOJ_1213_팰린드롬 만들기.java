import java.io.*;
import java.util.*;

public class Main{
    static int[] alphabet = new int[26];
    static StringBuilder sb = new StringBuilder();
    static StringBuilder front = new StringBuilder();
    static StringBuilder end = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        boolean check = false;	
        int oddCheck = 0;	
        char mid = '0';

        for(int i=0;i<name.length();i++)
            alphabet[name.charAt(i) - 65]++;

        for(int i=0;i< alphabet.length;i++){
            if(alphabet[i] != 0 && alphabet[i]%2 == 1){
                if(oddCheck==0){
                    oddCheck++;
                    mid = (char)('A' + i);
                }
                else{
                    sb = new StringBuilder("I'm Sorry Hansoo");
                    check = true;
                    break;
                }
            }
            for(int j=0;j<alphabet[i]/2;j++){
                front.append((char)('A' + i));
                end.insert(0, (char)('A' + i));
            }
        }

        if(!check){
            if(mid == '0')
                sb.append(front).append(end);
            else
                sb.append(front).append(mid).append(end);
        }

        System.out.println(sb);
    }
}