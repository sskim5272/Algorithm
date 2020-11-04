package Algo1029;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_1249_보급로
{
	static BufferedReader br;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case + " " + solution());
		}
	}

	private static int solution() throws Exception
	{
		int N = Integer.parseInt(br.readLine().trim());
		int grid[][][] = new int[N][N][2];

		for (int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = new int[] { str.charAt(j) - '0', Integer.MAX_VALUE };
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
		{

			@Override
			public int compare(int[] o1, int[] o2)
			{
				return o1[2] - o2[2];
			}

		});

		grid[0][0][1] = 0;
		pq.offer(new int[] { 0, 0, 0 });

		while (!pq.isEmpty())
		{
			int pos[] = pq.poll();
			int c = pos[0];
			int r = pos[1];
			if (r == N - 1 && c == N - 1)
			{
				return pos[2];
			}
			for (int dir = 0; dir < 4; dir++)
			{
				int nx = c + dx[dir];
				int ny = r + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N)
				{
					int until = grid[r][c][1] + grid[ny][nx][0];
					if (grid[ny][nx][1] <= until)
						continue;
					grid[ny][nx][1] = until;
					pq.offer(new int[] { nx, ny, grid[ny][nx][1] });
				}
			}
		}
		
		return 0;
	}
}
