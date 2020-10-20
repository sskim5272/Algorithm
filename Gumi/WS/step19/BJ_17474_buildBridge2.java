package ws.step19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17474_buildBridge2
{
	static int grid[][], N, M, landNUm = 2, connection[][];
	static int dc[] = { 1, -1, 0, 0 };
	static int dr[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		grid = new int[N][M];

		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken().trim());
			}
		}

		numbering();
		conneting();
		System.out.println(solution());

	}

	private static int solution()
	{
		int[] minEdge = new int[landNUm - 2];
		boolean visited[] = new boolean[landNUm - 2];

		int result = 0;
		int cnt = 0;

		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		PriorityQueue<Land> pQueue = new PriorityQueue<Land>();
		pQueue.offer(new Land(0, minEdge[0]));

		while (true)
		{
			if (pQueue.isEmpty())
				break;
			Land minLand = pQueue.poll();

			visited[minLand.num] = true;

			if (++cnt == landNUm - 2)
				break;

			for (int i = 0; i < landNUm - 2; i++)
			{
				if (!visited[i] && connection[minLand.num][i] > 0 && minEdge[i] > connection[minLand.num][i])
				{
					minEdge[i] = connection[minLand.num][i];
					pQueue.offer(new Land(i, minEdge[i]));
				}
			}
		}

		for (int x : minEdge)
		{
			if (x == Integer.MAX_VALUE)
				return -1;
			result += x;
		}

		return result;
	}

	private static void conneting()
	{
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				if (grid[r][c] == 0)
					continue;

				for (int dir = 0; dir < 4; dir++)
				{
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					int dis = 0;
					int fromval = grid[r][c];

					while (true)
					{
						if (nr >= 0 && nr < N && nc >= 0 && nc < M)
						{
							int toval = grid[nr][nc];
							if (toval == fromval)
								break;
							//
							if (toval > 1)
							{
								if (dis < 2)
									break;
								if (connection[fromval - 2][toval - 2] > 0)
								{
									dis = Math.min(dis, connection[fromval - 2][toval - 2]);

								}
								connection[fromval - 2][toval - 2] = connection[toval - 2][fromval - 2] = dis;
								break;
							}

							if (grid[nr][nc] == 0)
							{
								dis++;
								nr += dr[dir];
								nc += dc[dir];
							}
						} else
							break;

					}
				}
			}
		}
	}

	private static void numbering()
	{

		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				if (grid[r][c] == 1)
				{
					dfs(r, c);
					landNUm++;
				}
			}
		}
		connection = new int[landNUm - 2][landNUm - 2];
	}

	private static void dfs(int r, int c)
	{
		grid[r][c] = landNUm;

		for (int dir = 0; dir < 4; dir++)
		{
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] == 1)
			{
				dfs(nr, nc);
			}
		}
	}
}

class Land implements Comparable<Land>
{
	int num;
	int dis;

	public Land(int num, int dis)
	{
		super();
		this.num = num;
		this.dis = dis;
	}

	@Override
	public int compareTo(Land o)
	{
		// TODO Auto-generated method stub
		return this.dis - o.dis;
	}

}
