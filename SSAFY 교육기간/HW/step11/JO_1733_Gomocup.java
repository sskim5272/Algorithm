package hw.step11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1733_Gomocup
{

	static int grid[][], x2, y2;
	static int dx[] = { 0, 1, 1, 1 };
	static int dy[] = { 1, 0, 1, -1 };
	static int one = 0, two = 0;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		grid = new int[21][21];
		for (int row = 1; row < 20; row++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int col = 1; col < 20; col++)
			{
				grid[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int row = 1; row < 20; row++)
		{
			for (int col = 1; col < 20; col++)
			{
				if (grid[row][col] != 0)
				{
					int result = search(row, col);
					if (result == 1)
						one++;
					if (result == 2)
						two++;
				}
			}
		}

		if ((one + two) == 1)
		{
			if (one == 1)
			{
				System.out.println(1);
			} else
			{
				System.out.println(2);
			}
			System.out.print((y2 ) + " " + (x2 ));
		} else
		{
			System.out.println(0);
		}

	}

	private static int search(int row, int col)
	{
		int target = grid[row][col];
		int fiveCnt = 0;
		if (target == 0)
			return -1;

		for (int dir = 0; dir < 4; dir++)
		{
			int nx = col;
			int ny = row;
			int cnt = 1;

			if (target == grid[row - dy[dir]][col - dx[dir]])
				continue;

			while (true)
			{
				nx += dx[dir];
				ny += dy[dir];

				if (grid[ny][nx] != target)
					break;
				cnt++;

			}
		
			if (cnt == 5)
			{
				x2 = col;
				y2 = row;
				fiveCnt++;
			}
		}

		if (fiveCnt == 1)
			return target;
		else
			return -1;
	}
}
