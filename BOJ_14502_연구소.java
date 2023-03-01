import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static int[][] newArr;
    public static List<Node> list = new ArrayList<>();
    public static int[] ans;    // 조합 저장 배열
    public static int maxCnt = 0;
    public static boolean[][] visited;

    public static int[] nr = {-1, 1, 0, 0};
    public static int[] nc = {0, 0, -1, 1};
    public static class Node{
        int i;
        int j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0)
                    list.add(new Node(i, j));
            }
        }

        ans = new int[3];
        // list 값 중 조합으로 3개 뽑기
        comb(0, 0);

        System.out.println(maxCnt);
    }

    public static void comb(int idx, int k){
        if(k == 3){
            // arr[ans 배열에 있는 값들] = 1 로 만들고 bfs 돌리기

            int cnt = change();

            if(maxCnt < cnt)
                maxCnt = cnt;

            return;
        }

        for(int i=idx; i<list.size(); i++){
            ans[k] = i;
            comb(i+1, k+1);
        }
    }

    public static int change(){
        // 새로운 배열 만들기
        newArr = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newArr[i][j] = arr[i][j];
            }
        }

        for(int i=0; i<3; i++){
            newArr[list.get(ans[i]).i][list.get(ans[i]).j] = 1;
        }

        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(newArr[i][j] == 2 && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(newArr[i][j] == 0)
                    cnt += 1;
            }
        }

        return cnt;

    }

    public static void bfs(int i, int j){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(i, j));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int ii = node.i;
            int jj = node.j;

            for(int p=0; p<4; p++){
                int iii = ii + nr[p];
                int jjj = jj + nc[p];

                if(iii>=0 && iii<N && jjj>=0 && jjj<M && !visited[iii][jjj] && newArr[iii][jjj]==0){
                    queue.add(new Node(iii, jjj));
                    visited[iii][jjj] = true;
                    newArr[iii][jjj] = 2;
                }
            }
        }
    }
}