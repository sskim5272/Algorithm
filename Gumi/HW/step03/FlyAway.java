package hw.step03;

import java.util.Scanner;

public class FlyAway
{
	Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		new FlyAway().testcase();
	}
	private void testcase()
	{
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			int ans = solution();
			System.out.println("#" + test_case + " " + ans);
		}
	}

	private int solution()
	{
		int N=sc.nextInt();
		int size=sc.nextInt();
		int ans=0;
		int grid[][]=new int[N][N];
		int sum=0;
		
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				grid[row][col] = sc.nextInt();
			}
		}
		
		for (int row = 0; row < N-size+1; row++)
		{
			for (int col = 0; col < N-size+1; col++)
			{
				sum=0;
				for (int x = col; x < col+size; x++)
				{
					for (int y = row; y < row+size; y++)
					{
						
						sum+=grid[y][x];
						
					}
				}
				
				if (sum>ans) ans=sum;
				
			}
		}				
		
		return ans; 
		
	}
}
