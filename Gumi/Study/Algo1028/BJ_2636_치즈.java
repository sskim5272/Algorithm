package Algo1028;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈
{
	static int M, N, grid[][], temp[][];
	static int dx[] = { 0, 0, -1, +1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean check[][];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		temp = new int[N][M];

		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int ans2 = 0;

		while (true)
		{
			if (check() == false)
				break;
			ans++;
			copy();
			defineAir();
			change();
		}

		for (int xx[] : temp)
		{
			for (int x : xx)
			{
				if (x == 1)
					ans2++;
			}
		}

		System.out.println(ans + " " + ans2);
	}

	private static void change()
	{
		check = new boolean[N][M];
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				if (grid[r][c] == 1)
				{
					for (int dir = 0; dir < 4; dir++)
					{
						int nx = c + dx[dir];
						int ny = r + dy[dir];
						int val = grid[ny][nx];
						if (nx >= 0 && ny >= 0 && nx < M  && ny < N  && grid[ny][nx] == -1)
						{
							check[r][c] = true;
							break;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				if (check[r][c])
					grid[r][c] = -1;
			}
		}
	}

	private static void copy()
	{
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				temp[r][c] = grid[r][c];
			}
		}
	}

	private static void defineAir()
	{
		check = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		check[0][0] = true;

		while (!q.isEmpty())
		{
			int pos[] = q.poll();
			int x = pos[0];
			int y = pos[1];
			for (int dir = 0; dir < 4; dir++)
			{
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < M && ny < N && grid[ny][nx] < 1 && check[ny][nx] == false)
				{
					check[ny][nx] = true;
					grid[ny][nx] = -1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	private static boolean check()
	{
		for (int xx[] : grid)
		{
			for (int x : xx)
			{
				if (x > 0)
					return true;
			}
		}
		return false;
	}
}