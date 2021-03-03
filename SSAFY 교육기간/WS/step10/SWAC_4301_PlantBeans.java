package ws.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWAC_4301_PlantBeans
{
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static StringTokenizer st;
	static int grid[][];
	static int dx[] = { 0, 0, 2, -2 };
    static int dy[] = { -2, 2, 0, 0 };

	public static void main(String[] args) throws IOException
	{
		st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++)
		{
			System.out.println("#"+t+" "+solution());
		}
	}

	private static int solution() throws IOException
	{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[M][N];
		int nx, ny;
		int ans=0;		

		for (int r = 0; r < M; r++)
		{
			for (int c = 0; c < N; c++)
			{
				boolean flag=true;
				for (int dir = 0; dir < 4; dir++)
				{
					nx = c + dx[dir];
					ny = r + dy[dir];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[ny][nx] == 1)
					{
						flag=false;
						break;
					}
				}
				if(flag) {
					grid[r][c]=1;
					ans++;
				}
			}
		}
		return ans;
	}

}
