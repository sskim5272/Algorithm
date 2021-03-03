package hw.step20;

import java.util.Scanner;

public class SWEA_5607_combination
{
	static long mod=1234567891;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int R=sc.nextInt();
			long fac[] = new long[N + 1];
			fac[0]=1;
			for(int i=1;i<=N;i++) fac[i]=(i*fac[i-1])%mod;
				
				
			long q=fac[R]*fac[N-R];
			q%=mod;
			long n1=fac[N];
			long n2=repet(q,mod-2)%mod;
			long ans=(n1*n2)%mod;
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static long repet(long q,long x){
		if(x==0) return 1;
		long temp=repet(q, x/2);
		long ret = (temp * temp) % mod;
        if (x % 2 == 0) return ret;
        else return (ret * q) % mod;
		
	}
	
	
	
	
	
}
