import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        
        int dist[]=new int[n-1];
        int sum=0;
        
        for(int i=0;i<n-1;i++) {
            dist[i]=Math.abs(arr[i][0]-arr[i+1][0])+Math.abs(arr[i][1]-arr[i+1][1]);
            sum+=dist[i];
        }
        
        int max=0;

        for(int i=0;i<n-2;i++) {
            int skip = Math.abs(arr[i][0]-arr[i+2][0])+Math.abs(arr[i][1]-arr[i+2][1]);
            max=Math.max(max,dist[i]+dist[i+1]-skip);
        }
        
        System.out.println(sum-max);
    }
}

