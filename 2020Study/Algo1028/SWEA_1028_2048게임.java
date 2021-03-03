package Algo1028;

import java.util.Scanner;

public class SWEA_1028_2048게임
{
	static int grid[][], N;
	static boolean check[][];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			solution();
			System.out.println("#" + test_case);
			for (int xx[] : grid)
			{
				for (int x : xx)
				{
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}

	private static void solution()
	{
		N = sc.nextInt();
		char direction = sc.next().charAt(0);
		grid = new int[N][N];
		check= new boolean[N][N];
		
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = sc.nextInt();
			}
		}

		switch (direction) {
		case 'l':
			left();
			break;
		case 'u':
			up();
			break;
		case 'd':
			down();
			break;
		case 'r':
			right();
			break;
		}

	}

	private static void right()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j =N-1; j >=0 ; j--)
			{
				int val = grid[i][j];
				if (val == 0)
					continue;				
				for (int k = j + 1; k <N ; k++)
				{		
					
					if (val != grid[i][k] && 0 < grid[i][k])
						break;
					if(check[i][k]) break;				
					if (val == grid[i][k])
					{
						check[i][j]=true;
						grid[i][k] = 0;
						grid[i][j] *= 2;
						break;
					}
				}

			}
		}

		for (int i = 0; i < N; i++)
		{
			for (int j = N - 1; j >= 0; j--)
			{
				int val = grid[i][j];
				if (val != 0)
					continue;
				for (int k = j - 1; k >= 0; k--)
				{
					if (grid[i][k] != 0)
					{
						grid[i][j] = grid[i][k];
						grid[i][k] = 0;
						break;
					}
				}

			}
		}
	}

	private static void left()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 1; j <N ; j++)
			{
				int val = grid[i][j];
				if (val == 0)
					continue;
				for (int k = j - 1; k >=0 ; k--)
				{
					if (val != grid[i][k] && 0 < grid[i][k])
						break;
					if(check[i][k]) break;
					
					if (val == grid[i][k])
					{
						check[i][j]=true;
						grid[i][k] = 0;
						grid[i][j] *= 2;
						break;
					}
				}

			}
		}

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				int val = grid[i][j];
				if (val != 0)
					continue;
				for (int k = j + 1; k < N; k++)
				{
					if (grid[i][k] != 0)
					{
						grid[i][j] = grid[i][k];
						grid[i][k] = 0;
						break;
					}
				}

			}
		}
	}

	private static void down()
	{
		for (int j = 0; j < N; j++)
		{
			for (int i = N-1; i>=0; i--)
			{
				int val = grid[i][j];
				if (val == 0)
					continue;
				for (int k = i +1 ; k <N ; k++)
				{
					if (val != grid[k][j] && 0 < grid[k][j])
						break;
					if(check[k][j]) break;
					if (val == grid[k][j])
					{
						check[i][j]= true;
						grid[k][j] = 0;
						grid[i][j] *= 2;
						break;
					}
				}

			}
		}

		for (int j = 0; j < N; j++)
		{
			for (int i = N - 1; i >= 0; i--)
			{
				int val = grid[i][j];
				if (val != 0)
					continue;
				for (int k = i - 1; k >= 0; k--)
				{
					if (grid[k][j] != 0)
					{
						grid[i][j] = grid[k][j];
						grid[k][j] = 0;
						break;
					}
				}

			}
		}
	}

	private static void up()
	{
		for (int j = 0; j < N; j++)
		{
			for (int i = 0; i <N; i++)
			{
				int val = grid[i][j];
				if (val == 0)
					continue;
				for (int k =i-1; k >=0; k--)
				{
					if (val != grid[k][j] && 0 < grid[k][j])
						break;
					if(check[k][j]) break;
					if (val == grid[k][j])
					{
						check[i][j]= true;
						grid[k][j] = 0;
						grid[i][j] *= 2;
						break;
					}
				}

			}
		}

		for (int j = 0; j < N; j++)
		{
			for (int i = 0; i < N; i++)
			{
				int val = grid[i][j];
				if (val != 0)
					continue;
				for (int k = i + 1; k < N; k++)
				{
					if (grid[k][j] != 0)
					{
						grid[i][j] = grid[k][j];
						grid[k][j] = 0;
						break;
					}
				}

			}
		}
	}

}
