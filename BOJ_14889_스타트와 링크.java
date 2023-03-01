import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] arr;
    public static int[] ans;
    public static boolean[] visited;
    public static int ansMin = Integer.MAX_VALUE;

    public static void func(int idx, int k){
        if(k == N/2){
            visited = new boolean[N];
            for(int i=0; i<N/2; i++){
                visited[ans[i]] = true;
            }

            int trueValue = calTrue();
            int falseValue = calFalse();

            int sub = Math.abs(trueValue - falseValue);
            if(ansMin > sub)
                ansMin = sub;

            return;
        }

        for(int i=idx; i<N; i++){
            ans[k] = i;
            func(i+1, k+1);
        }
    }

    public static int calTrue(){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<N; i++){
            if(visited[i])
                list.add(i);
        }

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++)
                sum += arr[list.get(i)][list.get(j)];
        }

        return sum;
    }

    public static int calFalse(){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<N; i++){
            if(!visited[i])
                list.add(i);
        }

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++)
                sum += arr[list.get(i)][list.get(j)];
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ans = new int[N/2];
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);

        System.out.println(ansMin);
    }
}
