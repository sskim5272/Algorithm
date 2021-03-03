package Algo1209;

import java.util.LinkedList;
import java.util.Queue;

public class PG_KAKAO_컬러링북
{

	static int numberOfArea = 0;
	static int maxSizeOfOneArea = 0;
	static boolean grid[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int N, M;

	public int[] solution(int m, int n, int[][] picture)
	{
		grid = new boolean[m][n];
		N = n;
		M = m;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (grid[i][j] == false && picture[i][j] != 0)
				{
					bfs(i, j, picture[i][j], picture);
					numberOfArea++;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static void bfs(int y, int x, int num, int[][] picture)
	{
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		grid[y][x] = true;
		int cnt = 1;

		while (!q.isEmpty())
		{
			int pos[] = q.poll();
			int xx = pos[0];
			int yy = pos[1];
			for (int dir = 0; dir < 4; dir++)
			{
				int nx = xx + dx[dir];
				int ny = yy + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || grid[ny][nx] == true || picture[ny][nx] != num)
					continue;
				grid[ny][nx] = true;
				q.offer(new int[] { nx, ny });
				cnt++;
			}
		}
		if (num != 0)
			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
	}

	public static void main(String[] args)
	{
		new PG_KAKAO_컬러링북().solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
	}
}
