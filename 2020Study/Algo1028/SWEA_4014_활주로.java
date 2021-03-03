package Algo1028;

import java.util.Scanner;

public class SWEA_4014_활주로
{
	static int grid[][], X, N, ans;
	static int nx[] = { 0, 1 };
	static int ny[] = { 1, 0 };
	static Scanner sc;

	public static void main(String[] args) throws Exception
	{
		sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			solution();
			System.out.println("#" + test_case + " " + ans);
		}
	}

	private static void solution() throws Exception
	{
		N = sc.nextInt();
		X = sc.nextInt();
		grid = new int[N][N];

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++)
		{
			int cnt = 0;
			int num = grid[i][0];
			for (int j = 0; j < N; j++)
			{
				if (Math.abs(num - grid[i][j]) > 1)
				{
					cnt = -1;
					break;
				} else if (Math.abs(num - grid[i][j]) == 1)
				{
					if(cnt<0) break;
					if (num < grid[i][j])
					{
						if(cnt<X) {
							cnt=-1;
							break;
						}
						else cnt=1;
					}
					else {
						cnt=1-X;
					}
					
					num = grid[i][j];
				}
				else
				{
					cnt++;
				}
			}
			if (cnt >=0)
			{
				ans++;
			}
		}
		for (int i = 0; i < N; i++)
		{
			int cnt = 0;
			int num = grid[0][i];
			for (int j = 0; j < N; j++)
			{
				if (Math.abs(num - grid[j][i]) > 1)
				{
					cnt = -1;
					break;
				} else if (Math.abs(num - grid[j][i]) == 1)
				{
					if(cnt<0) break;
					if (num < grid[j][i])
					{
						if(cnt<X) {
							cnt=-1;
							break;
						}
						else cnt=1;
					}
					else {
						cnt=1-X;
					}
					
					num = grid[j][i];
				}
				else
				{
					cnt++;
				}
			}
			if (cnt >=0)
			{
				ans++;
			}
		}
	}
}
