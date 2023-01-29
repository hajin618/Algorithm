
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n, m, a, time, tmp=0;
            int ans=0;
            n=sc.nextInt();
            m=sc.nextInt();
            
            ArrayList<Integer> arrN = new ArrayList<>();
            ArrayList<Integer> arrM = new ArrayList<>();
            
            for(int i=0;i<n;i++){
            	a=sc.nextInt();
                arrN.add(a);
            }
            for(int i=0;i<m;i++){
            	a=sc.nextInt();
                arrM.add(a);
            }
            
            if(n>m)
                time=n-m+1;
            else
                time=m-n+1;
            
            if(n<m){
                for(int i=0;i<m-n+1;i++){
                    tmp=0;
                	for(int j=0;j<n;j++){
                    	tmp+=arrN.get(j)*arrM.get(i+j);
                    }
                    if(tmp>ans)
                            ans=tmp;
                }
            }
            else{
                for(int i=0;i<n-m+1;i++){
                    tmp=0;
                	for(int j=0;j<m;j++){
                    	tmp+=arrM.get(j)*arrN.get(i+j);
                    }
                    if(tmp>ans)
                            ans=tmp;
                }
            }
            
            System.out.println("#"+test_case+" "+ans);
		}
            
	}
}