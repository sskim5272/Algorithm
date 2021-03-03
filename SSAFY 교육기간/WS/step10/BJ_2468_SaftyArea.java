package ws.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_SaftyArea
{
	static int N;
	static int grid[][];
	static int visited[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < N; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int d = 0; d < 101; d++)
		{
			visited = new int[N][N];
			int temp = find(d);
			if (ans < temp)
				ans = temp;
		}
		System.out.println(ans);

	}

	private static int find(int d)
	{
		int ans = 0;
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < N; c++)
			{
				if (grid[r][c] <= d)
				{
					visited[r][c] = -1;
				}

			}
		}
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < N; c++)
			{
				if (grid[r][c] > d && visited[r][c] == 0)
				{
					ans++;
//					bfs(r, c);
					dfs(r, c);
				}
			}
		}
		return ans;
	}

	private static void bfs(int r, int c)
	{
		q.offer(new int[] { r, c });

		while (!q.isEmpty())
		{
			int pos[] = q.poll();
			int x = pos[1];
			int y = pos[0];
			int nx, ny;
			for (int dir = 0; dir < 4; dir++)
			{
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx] == 0)
				{
					visited[ny][nx] = 1;
					q.offer(new int[] { ny, nx });
				}
			}

		}
	}

	private static void dfs(int x, int y)
	{

		int nx, ny;
		visited[y][x] = 1;
		for (int dir = 0; dir < 4; dir++)
		{
			nx = x + dx[dir];
			ny = y + dy[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx] == 0)
			{
				visited[ny][nx] = 1;
				dfs(nx, ny);
			}
		}

	}

}
