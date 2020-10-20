package ws.step13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WS_PipeLine
{
	static int grid[][];
	static boolean[][] visited;
	static int R, C;
	static int dy[] = { -1, 0, 1 };
	static int answer = 0;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new int[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++)
		{
			String rowStr = br.readLine();
			for (int c = 0; c < C; c++)
			{
				if (rowStr.charAt(c) == '.')
				{
					grid[r][c] = 0;
				} else
				{
					grid[r][c] = 1;
					visited[r][c]=true;
				}
			}
		}

		for (int row = 0; row < R; row++)
		{
			installPipe(row, 0);
		}
		
		System.out.println(answer);
	}

	private static boolean installPipe(int row, int col)
	{
		if (col == C-1)
		{
			answer++;
			return true;
		}
		
		for (int dir = 0; dir < 3; dir++)
		{
			int ny = row + dy[dir];
			if (ny<0|| ny>=R) continue;
			if (visited[ny][col + 1]) continue;
			
			visited[ny][col+1]=true;
			if(installPipe(ny, col+1)) {
				return true;
			}
			
		}
		
		return false;

	}
}
