import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 0;
        while(true){
            String s = br.readLine();
            if(s.charAt(0) == '-'){
                break;
            }

            idx += 1;
            Stack<Character> stack = new Stack<>();
            int ANS = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '{'){
                    stack.push('{');
                }
                else{
                    if(stack.empty()){
                        stack.push('{');
                        ANS += 1;
                    }
                    else{
                        stack.pop();
                    }
                }
            }

            ANS += stack.size() / 2;

            System.out.println(idx + ". " + ANS);
        }
    }
}