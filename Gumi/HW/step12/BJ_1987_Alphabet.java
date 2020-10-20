package hw.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_Alphabet
{
	static int R, C, grid[][];
	static boolean visited[];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new int[R][C];
		visited = new boolean['Z' - 'A' + 1];

		for (int row = 0; row < R; row++)
		{
			String strTemp = br.readLine();
			for (int col = 0; col < C; col++)
			{
				grid[row][col] = strTemp.charAt(col) - 'A';
			}
		}
		visited[grid[0][0]] = true;
		System.out.println(dfs(0, 0, 1));

	}

	private static int dfs(int x, int y, int cnt)
	{
		int ans = cnt;
		for (int dir = 0; dir < 4; dir++)
		{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < C && ny >= 0 && ny < R && !visited[grid[ny][nx]])
			{
				int nextNum = grid[ny][nx];
				visited[nextNum] = true;
				int result = dfs(nx, ny, cnt + 1);
				visited[nextNum] = false;
				if (result > ans)
					ans = result;
			}
		}

		return ans;
	}
}
