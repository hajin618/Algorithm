import java.io.*;
import java.util.*;

public class Main {
    static int ANS, stack_size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '('){
                stack_size += 1;
            }
            else if(s.charAt(i) == ')'){
                if(stack_size == 0){
                    ANS += 1;
                }
                else{
                    stack_size -= 1;
                }
            }
        }
        ANS += stack_size;
        System.out.println(ANS);
    }
}