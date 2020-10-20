package Algo1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190_뱀
{
	static int grid[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException
	{
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			grid[row - 1][col - 1] = 2;
		}
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int changes[][] = new int[L][2];

		for (int i = 0; i < L; i++)
		{
			st = new StringTokenizer(br.readLine());
			int step = Integer.parseInt(st.nextToken());
			char change = st.nextToken().trim().charAt(0);
			if (change == 'D')
			{
				changes[i][0] = step;
				changes[i][1] = 1;
			} else
			{
				changes[i][0] = step;
				changes[i][1] = -1;
			}

		}
		
		int changeIdx = 0;
		int dir = 1;
		int nx = 0;
		int ny = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });
		grid[0][0] = 1;
		while (true)
		{
			nx += dx[dir];
			ny += dy[dir];
			ans++;
			if (nx >= 0 && ny >= 0 && ny < N && nx < N && grid[ny][nx] != 1)
			{
				q.offer(new int[] { nx, ny });
				if (grid[ny][nx] != 2)
				{
					int pos[] = q.poll();
					grid[pos[1]][pos[0]] = 0;
				}
				grid[ny][nx] = 1;
			} else
			{
				break;
			}

			if (changeIdx < L && changes[changeIdx][0] == ans)
			{
				if (changes[changeIdx][1] == -1)
				{
					dir = (dir == 0) ? 3 : dir - 1;
				} else
				{
					dir = (dir == 3) ? 0 : dir + 1;
				}
				changeIdx++;
			}
		}

		System.out.println(ans);
	}

}
