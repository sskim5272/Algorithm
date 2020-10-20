package ws.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pos
{
	int x;
	int y;
	boolean used = false;
	int cnt = 0;

	public Pos()
	{
		super();
	}

	public Pos(int x, int y, boolean used, int cnt)
	{
		super();
		this.x = x;
		this.y = y;
		this.used = used;
		this.cnt = cnt;
	}

}

public class BJ_2206번_MoveBreakingWall
{

	static int M, N;
	static int grid[][], visited[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		grid = new int[M][N]; // 미로 정보
		visited = new int[M][N]; // 미로 방문정보
		// 입력
		for (int row = 0; row < M; row++)
		{
			String str = in.readLine();
			for (int col = 0; col < N; col++)
			{
				grid[row][col] = (int) (str.charAt(col) - '0');
			}
		}
		// 출발점 방문 초기화
		int ans = bfs(new Pos(0, 0, false, 1));
		System.out.println(ans);
	}

	private static int bfs(Pos pos)
	{
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(pos);
		visited[pos.y][pos.x] = 1;

		while (!q.isEmpty())
		{
			Pos temp = q.poll();

			if (temp.x == N-1 && temp.y == M-1)
			{
				return temp.cnt;
			}

			for (int dir = 0; dir < 4; dir++)
			{
				int ny = temp.y + dy[dir];
				int nx = temp.x + dx[dir];
				boolean tempUsed= temp.used;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M)
				{
					if (grid[ny][nx] == 1)
					{
						if (temp.used==true) continue;
						else temp.used=true;
					}
					
					//처음 방문 
					if(visited[ny][nx] == 0 && tempUsed==false) {
						q.add(new Pos(nx, ny, temp.used, temp.cnt + 1));
						visited[ny][nx] = 1;
					}
					// 처음 방문 벽 부수기
					else if(visited[ny][nx] == 0 && tempUsed==true) {
						q.add(new Pos(nx, ny, temp.used, temp.cnt + 1));
						visited[ny][nx] = 2;
					}
					//이전에 벽을 부수고 온 상태고 나는 안부순 상태
					else if( visited[ny][nx] == 2 && temp.used==false) {
						q.add(new Pos(nx, ny, temp.used, temp.cnt + 1));
						visited[ny][nx] = 1;
					}

				}

			}

		}

		return -1;
	}
}
