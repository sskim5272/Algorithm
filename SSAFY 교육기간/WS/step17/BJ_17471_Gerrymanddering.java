package ws.step17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17471_Gerrymanddering
{
	static int N, values[], parents[], answer;
	static boolean grid[][];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		grid = new boolean[N][N];
		values = new int[N];
		parents = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
		{
			values[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++)
			{
				int to = Integer.parseInt(st.nextToken());
				grid[i][to - 1] = true;
				grid[to - 1][i] = true;
			}
		}
		
		if(N==2) {
			System.out.println(Math.abs(values[0]-values[1]));
			return ;
		}
		
		for (int i = 1; i < N - 1; i++)
		{
			combination(new boolean[N], N, i, 0);
		}

		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	private static void combination(boolean visited[], int depth, int r, int cur)
	{
		if (r == 0)
		{
//			for (boolean x : visited)
//			{
//				System.out.print(x + " ");
//			}
//			System.out.println();
			check(visited);
			return;
		}

		for (int i = cur; i < depth; i++)
		{
			visited[i] = true;
			combination(visited, depth, r - 1, i + 1);
			visited[i] = false;
		}

	}

	private static void check(boolean[] visited)
	{
		int sum1 = 0, sum2 = 0;
		int parcnt = N;

		for (int i = 0; i < N; i++)
		{
			parents[i] = i;
		}

		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				// 부모 다르고 이어져 있을때
				if (grid[i][j] && visited[j] == visited[i])
				{
					if (Union(i, j))
						parcnt--;
				}
			}
		}

		if (parcnt != 2)
			return;

		for (int i = 0; i < N; i++)
		{
			if (visited[i])
				sum1 += values[i];
			else
				sum2 += values[i];
		}

		answer = Math.min(answer, Math.abs(sum1 - sum2));
	}

	private static int find(int i)
	{
		if (parents[i] == i)
			return i;
		return parents[i] = find(parents[i]);

	}

	private static boolean Union(int i, int j)
	{
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		parents[i] = j;
		return true;

	}
}
