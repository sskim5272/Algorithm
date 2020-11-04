package Algo1104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15685_드래곤커브
{
	static int N, gen[][] = new int[11][];
	static boolean map[][] = new boolean[101][101];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		gen[0] = new int[] { 0 };
		for (int i = 1; i < 11; i++)
		{
			int size = gen[i - 1].length;
			gen[i] = new int[size * 2];
			for (int j = 0; j < size; j++)
			{
				gen[i][j] = gen[i - 1][j];
				gen[i][j + size] = (gen[i - 1][size - j - 1] + 1) % 4;
			}

		}

		

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			drawDragonPath(x, y, d, g);
		}

		int ans = 0;
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					ans++;
			}
		}
		System.out.println(ans);
	}

	private static void drawDragonPath(int x, int y, int d, int g)
	{
		map[y][x] = true;
		for (int dir : gen[g])
		{
			x += dx[(dir + d) % 4];
			y += dy[(dir + d) % 4];
			map[y][x] = true;
		}

	}
}
