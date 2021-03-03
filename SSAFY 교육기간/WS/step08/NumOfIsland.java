package ws.step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumOfIsland
{
	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, +1, -1, +1, -1, 0, +1 };
	static int grid[][];
	static int visited[][];
	static Queue<int[]> q = new LinkedList<int[]>();
	static int row, col;

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			if (row == 0 && col == 0)
				break;
			grid = new int[row][col];
			visited = new int[row][col];
			int ans = 0;

			for (int r = 0; r < row; r++)
			{
				st = new StringTokenizer(in.readLine());
				for (int c = 0; c < col; c++)
				{
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < row; r++)
			{
				for	 (int c = 0; c < col; c++)
				{
					if (grid[r][c] == 1 && visited[r][c] == 0)
					{
						visited[r][c]=1;
						ans++;
						bfs(r,c);
//						dfs(c,r);
					}
				}
			}
			System.out.println(ans);
		}
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
			for (int dir = 0; dir < 8; dir++)
			{
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && nx < col && ny >= 0 && ny < row && visited[ny][nx] == 0 && grid[ny][nx] == 1)
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
		for (int dir = 0; dir < 8; dir++)
		{
			nx = x + dx[dir];
			ny = y + dy[dir];
			if (nx >= 0 && nx < col && ny >= 0 && ny < row && visited[ny][nx] == 0 && grid[ny][nx] == 1)
			{
				visited[ny][nx] = 1;
				dfs(nx, ny);
			}
		}

	}

}