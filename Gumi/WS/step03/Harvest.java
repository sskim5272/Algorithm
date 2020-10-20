package ws.step03;

import java.util.Scanner;


import java.io.FileInputStream;

public class Harvest
{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception
	{
		new Harvest().testcase();
	}

	int dx[] =
	{ 1, -1, -1, 1 }; // �ϵ�,�ϼ�,����,����
	int dy[] =
	{ -1, -1, 1, 1 };

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

	private int serchSum(int grid[][], int x, int y, int step)
	{
		if (step == 0)
			return 0;

		int sum = 0;
		for (int dir = 0; dir < 4; dir++)
		{
			for (int i = 0; i < step; i++)
			{
				x += dx[dir];
				y += dy[dir];

				sum += grid[y][x];
			}
		}

		return sum + serchSum(grid, x, y - 1, step - 1);
	}

	private int solution()
	{

		int N = sc.nextInt();
		int grid[][] = new int[N][N];
		int maxSum = 0;

		for (int row = 0; row < N; row++)
		{
			String msg = sc.next();
			for (int col = 0; col < N; col++)
			{
				grid[row][col] = msg.charAt(col) - '0';
			}
		}

		for (int size = N; size > 0; size -= 2)
		{
			for (int x = size - 1; x < N; x++)
			{
				for (int y = size - 1; y < N; y++)
				{
					int result;
					if (size == 1)
						result = grid[y][x];
					else
						result = serchSum(grid, x - (size / 2), y, size / 2)+grid[x - (size / 2)][y - (size / 2)];

					if (maxSum < result)
						maxSum = result;
				}
			}
		}

		return maxSum;
	}

}
