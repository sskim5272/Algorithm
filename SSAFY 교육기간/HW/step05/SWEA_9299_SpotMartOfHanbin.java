package hw.step05;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9299_SpotMartOfHanbin
{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		new SWEA_9299_SpotMartOfHanbin().testCase();
	}

	private void testCase()
	{
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			int ans = solutioin();
			System.out.println("#" + t + " " + ans);
		}

	}

	private int solutioin()
	{
		int N = sc.nextInt();
		int M = sc.nextInt();
		int data[] = new int[N];
		int sums[] = new int[] { 0, 0 };
		int sum = 0;
		for (int i = 0; i < N; i++)
		{
			data[i] = sc.nextInt();
		}

		Arrays.sort(data);
		for (int i = 0; i < N; i++)
		{
			for (int j = i-1; j >=0; j--)
			{
				if ((data[i] + data[j]) > sum && (data[i] + data[j]) <= M)
				{
					sum=(data[i] + data[j]);
					break;
				}
			}

		}

		if (sum==0)
			return -1;
		return sum;
	}
}
