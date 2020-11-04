package Algo1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거
{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 상우하좌
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, +1, 0 };
	static int N, M, R, C, L, map[][];
	static boolean visited[][];
	static boolean pipe[][] = {{ false, false, false, false }, { true, true, true, true }, { true, false, true, false }, { false, true, false, true },
			{ true, true, false, false }, { false, true, true, false }, { false, false, true, true },
			{ true, false, false, true } };

	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case + " " + solution());
		}
	}

	private static int solution() throws IOException
	{
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++)
			{
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		ans++;
		q.offer(new int[] { C, R, 1 });
		visited[R][C] = true;
		
		while (!q.isEmpty())
		{
			int info[] = q.poll();
			int r = info[1];
			int c = info[0];
			int cnt = info[2];
			int p = map[r][c];
			if(cnt==L) break;
			for (int dir = 0; dir < 4; dir++)
			{
				int nx = c + dx[dir];
				int ny = r + dy[dir];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N ||visited[ny][nx])
					continue;
				int p2 = map[ny][nx];
				int dir2 = (dir + 2) % 4;

				if (pipe[p][dir] && pipe[p2][dir2])
				{
					ans++;
					visited[ny][nx] = true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
		}

		return ans;
	}
}
