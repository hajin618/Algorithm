import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        String[] arr = new String[50];

        for(int i=0; i<n; i++){
            arr[i] = sc.next();

        }

        int ans = 65;

        // 시작점 : start_i, start_j
        for(int start_i=0; start_i<n; start_i++){
            for(int start_j=0; start_j<m; start_j++){

                // 끝점 : end_i, end_j
                for(int end_i = start_i+7; end_i<n; end_i++){
                    for(int end_j = start_j+7 ; end_j<m; end_j++){

                        int tmp1 = 0;
                        int tmp2 = 0;
                        int min_tmp;

                        // 사이점들
                        for(int i = start_i; i<=end_i; i++){
                            for(int j= start_j; j<=end_j; j++){
                                if((i+j)%2 == 0 && arr[i].charAt(j)=='B'){
                                    tmp1 ++;
                                }
                                if((i+j)%2 == 1 && arr[i].charAt(j)=='W'){
                                    tmp1 ++;
                                }
                                if((i+j)%2 == 0 && arr[i].charAt(j)=='W'){
                                    tmp2 ++;
                                }
                                if((i+j)%2 == 1 && arr[i].charAt(j)=='B'){
                                    tmp2 ++;
                                }

                            }
                        }
                        min_tmp = Math.min(tmp1, tmp2);
                        if(ans > min_tmp)
                            ans = min_tmp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
