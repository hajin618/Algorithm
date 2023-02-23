import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;		// 결과 저장
    static int[][] newArr;
    static boolean flag = false;

    public static void func(int i, int j) {
 	
    	if(i == 5) {
    		if(same())
    			flag = true;
    		return;
    	}
    	
    	for(int k=0; k<3; k++) {

    		getResult(i, j, k);
    		
    		int nextI = i;
    		int nextJ = j+1;
    		
    		if(nextJ == 6) {
    			nextI = i+1;
    			nextJ = nextI + 1;
    		}
    		
    		func(nextI, nextJ);
    		
    		returnResult(i, j, k);
    	}
    }
    
    public static void getResult(int i, int j, int k) {
    	if(k == 0) {
    		newArr[i][0] += 1;
    		newArr[j][2] += 1;
    	}
    	else if(k == 1) {
    		newArr[i][1] += 1;
    		newArr[j][1] += 1;
    	}
    	else if(k == 2) {
    		newArr[i][2] += 1;
    		newArr[j][0] += 1;
    	}
    }
    
    public static void returnResult(int i, int j, int k) {
    	if(k == 0) {
    		newArr[i][0] -= 1;
    		newArr[j][2] -= 1;
    	}
    	else if(k == 1) {
    		newArr[i][1] -= 1;
    		newArr[j][1] -= 1;
    	}
    	else if(k == 2) {
    		newArr[i][2] -= 1;
    		newArr[j][0] -= 1;
    	}
    }
    
      public static boolean same() {
    	for(int i=0; i<6; i++) {
    		for(int j=0; j<3; j++) {
    			if(arr[i][j] != newArr[i][j])
    				return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        for(int test_case = 0; test_case < 4; test_case++) {
            flag = false;

            arr = new int[6][3];
            newArr = new int[6][3];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++) {
                for(int j=0; j<3; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken()) ;
            }

            int vic = 0;
            int tie = 0;
            int lose = 0;
            for(int i=0; i<6; i++) {
            	vic += arr[i][0];
            	tie += arr[i][1];
            	lose += arr[i][2];
            }
            
            if(vic == lose && tie%2 == 0)   
            	func(0, 1);

            if(flag)
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);

    }
}
