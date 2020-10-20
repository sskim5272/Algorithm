package Algo1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234
{
	static int grid[][], R, L, N, ans = 0;
	static boolean visited[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		grid = new int[N][N];

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true)
		{
			int flag = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					if (visited[i][j] == false)
						flag += bfs(i, j);
				}
			}
			if (flag == 0)
				break;
			ans++;
		}

		System.out.println(ans);
	}

	public static int bfs(int row, int col)
	{
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();
		int flag = 0;

		q.add(new int[] { row, col });
		q2.add(new int[] { row, col });
		int sum = grid[row][col];
		int cnt = 1;
		visited[row][col] = true;
		
		while (!q.isEmpty())
		{			
			int pos[] = q.poll();
			int ny = pos[0];
			int nx = pos[1];
			for (int dir = 0; dir < 4; dir++)
			{
				int nxx = nx + dx[dir];
				int nyy = ny + dy[dir];
				if (nxx >= 0 && nyy >= 0 && nxx < N && nyy < N && visited[nyy][nxx] == false
						&& check(Math.abs(grid[nyy][nxx] - grid[ny][nx])))
				{
					visited[nyy][nxx] = true;
					q.offer(new int[] { nyy, nxx });
					q2.offer(new int[] { nyy, nxx });
					sum += grid[nyy][nxx];
					cnt++;
					flag = 1;
				}
			}
		}
		int avg = sum / cnt;

		while (!q2.isEmpty())
		{
			int pos[] = q2.poll();
			int ny = pos[0];
			int nx = pos[1];
			grid[ny][nx] = avg;
		}

		return flag;
	}

	public static boolean check(int a)
	{
		if (L <= a && a <= R)
			return true;
		return false;
	}

}

