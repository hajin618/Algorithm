import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        int ans = 1;
        int tmp = 0;

        for(int i=0; i<n; i++){
            int a;
            a = sc.nextInt();
            tmp+=a;
            if(tmp > m){
                ans +=1;
                tmp=a;
            }
        }
        if(n==0)
            ans = 0;
        System.out.println(ans);
    }
}
