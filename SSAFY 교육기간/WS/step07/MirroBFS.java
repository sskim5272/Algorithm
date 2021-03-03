package ws.step07;

import java.util.LinkedList;
import java.util.Queue;

public class MirroBFS
{
	static int[][] map;
	static boolean[][] visited = new boolean[8][8];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args)
	{
		map = new int[][] { { 0, 0, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

		Queue<int[]> go = new LinkedList<int[]>();

		go.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		int ans = 0;

		while (!go.isEmpty())
		{
			int[] currentPos = go.poll();
			for (int i = 0; i < 4; i++)
			{
				int x = currentPos[0] + dx[i];
				int y = currentPos[1] + dy[i];

				if (x >= 0 && x < 8 && y >= 0 && y < 8 && !visited[y][x] && map[y][x] == 0)
				{
					if ((x + y) == 14)
					{
						ans = -1;
						break;
					}

					go.offer(new int[] { x, y });
					visited[x][y] = true;
				}

			}
		}
		System.out.println("ans : " + ans);

	}
}
