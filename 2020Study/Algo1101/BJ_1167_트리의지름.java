package Algo1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1167_트리의지름
{
	static int map[][], N;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			while (true)
			{
				int x1 = Integer.parseInt(st.nextToken());
				if (x1 == -1)
					break;
				int x2 = Integer.parseInt(st.nextToken());
				map[x][x1] = x2;
			}
		}

		for (int i = 0; i < N + 1; i++)
		{
			for (int j = 0; j < N + 1; j++)
			{
				if (map[i][j] == 0)
					map[i][j] = 1000000;
			}
		}

		for (int k = 1; k < N + 1; k++)
		{
			for (int i = 1; i < N + 1; i++)
			{
				for (int j = 1; j < N + 1; j++)
				{
					if (map[i][k] <= 10000 && map[k][i] <= 10000)
						map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i < N + 1; i++)
		{
			for (int j = 1; j < N + 1; j++)
			{
				if (map[i][j] < 1000000&&i!=j)
					ans = Math.max(ans, map[i][j]);
			}
		}

		System.out.println(ans);

	}
}
