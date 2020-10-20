package ws.step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tomato
{
	static int row, col;
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static int grid[][];
	static int cnt = 0;

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		grid = new int[row][col];
		int state, x, y;
		Stack<int[]> s = new Stack<int[]>();
		boolean allzero = false;
		for (int r = 0; r < row; r++)
		{
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < col; c++)
			{
				state = Integer.parseInt(st.nextToken());
				grid[r][c] = state;
				if (state == 1)
					s.push(new int[] { r, c, 0 });
				allzero = true;
			}
		}

		while (!s.isEmpty())
		{
			q.offer(s.pop());
		}

		while (!q.isEmpty())
		{
			bfs();
		}
		boolean flag = true;
		outer: for (int r = 0; r < row; r++)
		{
			for (int c = 0; c < col; c++)
			{
				state = grid[r][c];
				if (state == 0)
				{
					System.out.println(-1);
					flag = false;
					break outer;

				}
			}
		}
		if (flag)
			System.out.println(cnt);

	}

	private static void bfs()
	{
		int pos[] = q.poll();
		int x = pos[1];
		int y = pos[0];
		int c = pos[2];
		for (int dir = 0; dir < 4; dir++)
		{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < col && ny >= 0 && ny < row && grid[ny][nx] == 0)
			{
				grid[ny][nx] = 1;
				q.offer(new int[] { ny, nx, c + 1 });
				cnt = c + 1;
			}
		}
	}
}
