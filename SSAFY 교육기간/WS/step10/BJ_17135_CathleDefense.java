package ws.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/*
10 10 8
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
 */
public class BJ_17135_CathleDefense
{
	static int N, M, D;
	static int[] dx = { 1, 1 }; // 북동, 남동, 남서
	static int[] dy = { -1, 1 };
	static int[][] grid;
	static int[][] Tempgrid;
	static int[] archerPos = new int[3];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		Tempgrid = new int[N][M];
		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < M; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(selectPositonAndfind(archerPos.length, 0, 0));

	}

	private static int findEnemyKilled()
	{
		int firstLine = N;
		int enemyNumKilled = 0;
		int[][] enemyPosKilled = new int[3][2];

		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < M; c++)
			{
				Tempgrid[r][c] = grid[r][c];
			}
		}
		
		for (firstLine = N - 1; firstLine >= 0; firstLine--)
		{
			for (int i = 0; i < 3; i++)
			{
				enemyPosKilled[i] = SelectEnemyPos(firstLine + 1, archerPos[i]);
			}
			enemyNumKilled += checkOverlap(enemyPosKilled);
			deleteEnemy(enemyPosKilled);
		}

		return enemyNumKilled;

	}

	private static void deleteEnemy(int[][] enemyPosKilled)
	{
		for (int pos[] : enemyPosKilled)
		{
			if (checkOnboard(pos[0], pos[1]))
				Tempgrid[pos[0]][pos[1]] = 0;
		}

	}

	private static int checkOverlap(int[][] pos)
	{
		Stack<int[]> s = new Stack<int[]>();
		for (int i = 0; i < pos.length; i++)
		{
			if (s.isEmpty() ) {
				if(pos[i][0] != -1) {	
					s.push(pos[i]);
				}				
			}
			else
			{
				if (s.peek()[0] == pos[i][0] && s.peek()[1] == pos[i][1])
				{

				} else
				{
					if(pos[i][0]!=-1)
					s.push(pos[i]);
				}
			}

		}
		if(s.isEmpty()) return 0;
		
		return s.size();

	}

	private static boolean checkOnboard(int y, int x)
	{
		if (x >= 0 && x < M && y >= 0 && y < N)
			return true;
		return false;
	}

	private static int[] SelectEnemyPos(int y, int x)
	{
		for (int i = 1; i <= D; i++)
		{
			int nx = x - i;
			int ny = y;
			for (int step = 0; step < i; step++)
			{
				nx += dx[0];
				ny += dy[0];
				if (checkOnboard(ny, nx) && ny < y && Tempgrid[ny][nx] == 1)
					return new int[] { ny, nx };
			}
			for (int step = 0; step < i; step++)
			{
				nx += dx[1];
				ny += dy[1];
				if (checkOnboard(ny, nx) && ny < y && Tempgrid[ny][nx] == 1)
					return new int[] { ny, nx };
			}
		}

		return new int[] { -1, -1 };
	}

	private static int selectPositonAndfind(int pick, int s, int ans)
	{
		if (pick == 0)
		{
			return findEnemyKilled();
		}

		for (int i = s; i < M; i++)
		{
			archerPos[3 - pick] = i;
			int temp = selectPositonAndfind(pick - 1, i + 1, ans);
			if (temp > ans)
				ans = temp;

		}
		return ans;
	}

}
