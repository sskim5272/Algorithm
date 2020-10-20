package ws.step19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16236_babyShark
{
	static int grid[][], N, answer, Sx, Sy, level, exp;
	static int dc[] = new int[] { 0, -1, 1, 0 };
	static int dr[] = new int[] { -1, 0, 0, 1 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		grid = new int[N][N];
		visited = new boolean[N][N];
		level = 2;
		exp = 0;
		answer = 0;
		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken().trim());

				if (grid[r][c] == 9)
				{
					Sx = c;
					Sy = r;
				}
			}
		}
		solution();
		System.out.println(answer);

	}

	private static void solution()
	{
		PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
		pq.offer(new Pos(Sy, Sx, 0));
		visited[Sy][Sx] = true;
		grid[Sy][Sx] = 0;

		while (!pq.isEmpty())
		{
			Pos cur = pq.poll();
			int r = cur.r;
			int c = cur.c;

			if (grid[r][c] > 0 && grid[r][c] < level)
			{				
				if (++exp == level )
				{
					level++;
					exp = 0;
				} 
				grid[r][c] = 0;
				Sy = r;
				Sx = c;

				answer += cur.cnt;
				visited = new boolean[N][N];
				visited[r][c] = true;
				pq.clear();
				pq.offer(new Pos(r, c, 0));
				continue;
			}

			for (int dir = 0; dir < 4; dir++)
			{
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && grid[nr][nc] <= level)
				{
					visited[nr][nc] = true;
					pq.offer(new Pos(nr, nc, cur.cnt + 1));
				}
			}
		}

	}
}

class Pos implements Comparable<Pos>
{
	int r, c, cnt;

	public Pos(int r, int c, int cnt)
	{
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Pos o)
	{
		if (Integer.compare(o.cnt, this.cnt) != 0)
			return Integer.compare(this.cnt, o.cnt);
		if (Integer.compare(o.r, this.r) != 0)
			return Integer.compare(this.r, o.r);
		return Integer.compare(this.c, o.c);

	}

}