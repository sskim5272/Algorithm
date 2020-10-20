package ws.step02;

import java.util.Arrays;

public class Absadd
{
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args)
	{
		int[][] grid = new int[5][5];
		int nums[] = new int[25];
		for (int i = 0; i < 25; i++)
		{
			nums[i] = i + 1;
		}

		for (int i = 0; i < 500; i++)
		{
			int idx1 = i / 25;
			int idx2 = (i + 3) / 25;
			int temp = nums[idx1];
			nums[idx1] = nums[idx2];
			nums[idx2] = temp;
		}

		for (int r = 0; r < 5; r++)
		{
			for (int c = 0; c < 5; c++)
			{
				grid[r][c] = nums[(5 * r )+ (c)];
			}
		}
		
		int Answer = 0;
		for (int r = 0; r < 5; r++)
		{
			for (int c = 0; c < 5; c++)
			{
				for (int i = 0; i < 4; i++)
				{
					int x = dx[i] + c;
					int y = dy[i] + r;
					if (x >= 0 && x < 5 && y >= 0 && y < 5)
					{
						Answer += Math.abs(grid[r][c] - grid[y][x]);
					}
				}
			}
		}
		
		Arrays.sort(nums);

		for (int xx[] : grid)
		{
			for (int x : xx)
			{
				System.out.printf("%-3d",x);
			}
			System.out.println();
		}
		
		System.out.println("Answer is "+Answer);

	}
}
