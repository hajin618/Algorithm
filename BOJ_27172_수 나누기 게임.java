import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] player;
    static int[] score;
    static boolean[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        player = new int[N];
        card = new boolean[1000001];
        score = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }

        for(int i : player){
            for(int j=i*2; j < 1000001; j+=i){
                if(card[j]){
                    score[i] += 1;
                    score[j] -= 1;
                }
            }
        }

        for(int i : player){
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);
    }
}