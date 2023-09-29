import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static boolean[] check;
    static int ANS;
    static int test_case;

    static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa > pb) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }

        if (pa != pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        test_case = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0)
                break;

            test_case += 1;
            ANS = 0;
            check = new boolean[N + 1];
            parent = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);

            }

            for (int i = 1; i <= N; i++) {
                int parentI = find(i);
                if (parentI != 0 && !check[parentI]) {
                    ANS += 1;
                    check[parentI] = true;
                }
            }

            if (ANS == 0) {
                sb.append("Case ").append(test_case).append(": No trees.\n");
            } else if (ANS == 1) {
                sb.append("Case ").append(test_case).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(test_case).append(": A forest of ").append(ANS).append(" trees.\n");
            }

        }
        System.out.println(sb);
    }
}