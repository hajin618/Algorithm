import java.io.*;
import java.util.*;

public class Main {

	static int k, p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'K') {
            	k += 1;
            	if(p>0) {
            		p -= 1;
            	}
            }else {
            	p += 1;
            	if(k>0) {
            		k -= 1;
            	}
            }
        }
        System.out.print(k+p);
	}
}