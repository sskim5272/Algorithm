package ws.step22;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_3307_MaxIncreaseNumbers
{

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int ans[]=new int[N+1];
			int nums[]=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				nums[i]=sc.nextInt();
				ans[i]=1;
				for(int j=1;j<i;j++) {
					if(nums[i]>nums[j] && ans[i]<1+ans[j])
						ans[i]=1+ans[j];
				}
			}
			int max=0;
			for(int x:ans) max=Math.max(max, x);
			System.out.println("#"+test_case+" "+max);
		}
	}

}
