package ws.step05;

import java.util.Scanner;
import java.util.Stack;


public class SwitchOnOFF
{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		new SwitchOnOFF().solution();
	}

	// *+ out
	// ++ out
	// ** out
	// +* 08
	private void solution()
	{
		int N = sc.nextInt();
		int[] nums = new int[N];

		for (int i = 0; i < N; i++)
		{
			nums[i] = sc.nextInt();
		}
		int nS = sc.nextInt();

		for (int i = 0; i < nS; i++)
		{
			
			int n1 = sc.nextInt();
			int index = sc.nextInt() ;
			if (n1 == 1)
			{
				while (index < N)
				{
					nums[index-1] = (nums[index-1] + 1) % 2;
					index *= 2;
				}
			} else
			{
				int toEnd = N - (index-1)-2 ;
				int dist=(toEnd>(index-1))?index-1:N - (index-1)-2;
				nums[index-1] = (nums[index-1] + 1) % 2;
				for(int strat=1;strat<=dist;strat++) {
					nums[index-1+strat] =(nums[index-1+strat] + 1) % 2;
					nums[index-1-strat] =(nums[index-1-strat] + 1) % 2;
				}
				
			}
		}
		
		for(int x:nums) {
			System.out.printf("%d ",x);
		}

	}
}
