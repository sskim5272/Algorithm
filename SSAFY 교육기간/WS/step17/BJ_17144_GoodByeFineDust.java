package ws.step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_GoodByeFineDust
{
	static int R, C, T, grid[][][], st1, st2;
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static boolean flag = true;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		grid = new int[2][R][C];

		for (int r = 0; r < R; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++)
			{
				int val = Integer.parseInt(st.nextToken());
				grid[0][r][c] = val;
				grid[1][r][c] = val;
				if (val == -1)
					st2 = r;
			}
		}
		st1 = st2 - 1;
		int gridNum = 1;
		int change = 1;
		while (true)
		{
			if (T == 0)
				break;
			else
				T--;

			if (flag)
			{
				gridNum = 0;
				change = 1;
			} else
			{
				gridNum = 1;
				change = 0;
			}

			int val;
			for (int r = 0; r < R; r++)
			{
				for (int c = 0; c < C; c++)
				{
					val = grid[gridNum][r][c];

					if (val < 5)
						continue;
					int spreadCnt = 0;
					for (int dir = 0; dir < 4; dir++)
					{
						int nx = c + dx[dir];
						int ny = r + dy[dir];
						if (nx >= 0 && nx < C && ny >= 0 && ny < R && grid[gridNum][ny][nx] != -1)
						{
							spreadCnt++;
							grid[change][ny][nx] += val / 5;
						}
					}
					grid[change][r][c] -= spreadCnt * (val / 5);
				}
			}
			// 윗방향
			int tempVal1 = 0;
			int tempVal2 = 0;
			int xx = 0;
			int yy = st1;

			grid[change][st1][0] = 0;
			for (int i = 0; i < C - 1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy][xx + 1];
				grid[change][yy][xx + 1] = tempVal1;
				xx++;
			}
			for (int i = 0; i < st1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy - 1][xx];
				grid[change][yy - 1][xx] = tempVal1;
				yy--;
			}
			for (int i = 0; i < C - 1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy][xx - 1];
				grid[change][yy][xx - 1] = tempVal1;
				xx--;
			}
			for (int i = 0; i < st1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy + 1][xx];
				grid[change][yy + 1][xx] = tempVal1;
				yy++;
			}
			grid[change][st1][0] = -1;
			grid[change][st1][1] = 0;

			xx = 0;
			yy = st2;
			tempVal1 = 0;
			tempVal2 = 0;
			grid[change][st2][0] = 0;
			for (int i = 0; i < C - 1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy][xx + 1];
				grid[change][yy][xx + 1] = tempVal1;
				xx++;
			}
			for (int i = 0; i < R - st1 - 2; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy + 1][xx];
				grid[change][yy + 1][xx] = tempVal1;
				yy++;
			}
			for (int i = 0; i < C - 1; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy][xx - 1];
				grid[change][yy][xx - 1] = tempVal1;
				xx--;
			}
			for (int i = 0; i < R - st1 - 2; i++)
			{
				tempVal1 = tempVal2;
				tempVal2 = grid[change][yy - 1][xx];
				grid[change][yy - 1][xx] = tempVal1;
				yy--;
			}
			grid[change][st2][0] = -1;
			grid[change][st2][1] = 0;

			for (int r = 0; r < R; r++)
			{
				for (int c = 0; c < C; c++)
				{
					grid[gridNum][r][c] = grid[change][r][c];

				}
			}

			flag = !flag;
		}

		int answer = 0;
		for (int r = 0; r < R; r++)
		{
			for (int c = 0; c < C; c++)
			{
				int tempval = grid[gridNum][r][c];
				if (tempval > 0)
					answer += tempval;

			}
		}
		System.out.println(answer);

	}
}
