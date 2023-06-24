import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] arr;
    static int[][] horse;   // 말 위치
    static List<Node>[][] list;

    static int[] nr = {0, 0, -1, 1};
    static int[] nc = {1, -1, 0, 0};

    static boolean flag = false;

    public static class Node{
        int num;
        int dir;

        Node(int num, int dir){
            this.num = num;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 체스판 크기
        K = Integer.parseInt(st.nextToken());   // 말 개수

        arr = new int[N][N];
        horse = new int[K][2];
        list = new ArrayList[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            horse[i][0] = a;
            horse[i][1] = b;

            list[a][b].add(new Node(i, c));
        }

        System.out.println(start());
    }

    public static int start(){
        for(int turn=1; turn<=1000; turn++){
            for(int i=0; i<K; i++){

                int nowX = horse[i][0];
                int nowY = horse[i][1];
                int nowD = list[nowX][nowY].get(0).dir;

                // 가장 아래 있는 말만 이동 가능 : 번호 다르면 continue;
                if(list[nowX][nowY].get(0).num != i)
                    continue;

                int nextX = nowX + nr[nowD];
                int nextY = nowY + nc[nowD];

                // 범위 벗어남 || 이동하려는 칸 파란색 => 방향 바꾸기
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || arr[nextX][nextY] == 2){
                    nowD = changeDir(nowD);
                    list[nowX][nowY].get(0).dir = nowD;

                    nextX = nowX + nr[nowD];
                    nextY = nowY + nc[nowD];

                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                        continue;

                    // 방향을 반대로 한 후에도 파란색 : 방향만 바꾸기
                    if(arr[nextX][nextY] == 2)
                        continue;
                    else{
                        move(nowX, nowY, nextX, nextY);
                    }
                }
                else{
                    move(nowX, nowY, nextX, nextY);
                }
            }

            if(flag){
                return turn;
            }
        }

        return -1;
    }

    public static void move(int nowX, int nowY, int nextX, int nextY){

        int size = list[nowX][nowY].size();

        // 이동하려는 칸 흰색
        if(arr[nextX][nextY] == 0){
            for(int i=0; i<size; i++){
                Node node = list[nowX][nowY].get(i);
                // horse 정보 갱신
                horse[node.num][0] = nextX;
                horse[node.num][1] = nextY;

                list[nextX][nextY].add(node);
            }
        }
        // 이동하려는 칸 빨간색 : 순서 반대
        else{
            for(int i=0; i<size; i++){
                Node node = list[nowX][nowY].get(size - i - 1);
                // horse 정보 갱신
                horse[node.num][0] = nextX;
                horse[node.num][1] = nextY;

                list[nextX][nextY].add(node);
            }
        }
        
        // 기존 list 비우기
        list[nowX][nowY] = new ArrayList<>();

        if(list[nextX][nextY].size() >= 4){
            flag = true;
        }

    }

    public static int changeDir(int d){
        if(d == 0)
            return 1;
        if(d == 1)
            return 0;
        if(d == 2)
            return 3;
        if(d == 3)
            return 2;

        return 0;
    }
}