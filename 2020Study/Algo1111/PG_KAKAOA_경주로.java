package Algo1111;

public class PG_KAKAOA_경주로
{


    static int N, ans;
    // 우하좌상
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static boolean[][] visited;
    static int value[][];
    static int board2[][];

    public int solution(int[][] board)
    {
//      board = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        board2=board;
        N = board.length;
        value = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                value[i][j] = Integer.MAX_VALUE;
            }
        }
        ans = Integer.MAX_VALUE;
        visited[0][0] = true;
        dfs(0, 0, -500, -1);
        return ans;
    }

    private void dfs(int x, int y, int cnt, int preDir)
    {
        if (value[y][x] < cnt)
            return;
        else

            value[y][x] = cnt;

        if (cnt > ans)
            return;

        if (x == N - 1 && y == N - 1)
        {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int dir = 0; dir < 4; dir++)
        {
            int xx = x + dx[dir];
            int yy = y + dy[dir];

            if (xx < 0 || yy < 0 || xx > N - 1 || yy > N - 1 || visited[yy][xx] || board2[yy][xx] == 1)
                continue;
            visited[yy][xx] = true;
            if (preDir == dir)
            {
                dfs(xx, yy, cnt + 100, dir);
            } else
            {
                dfs(xx, yy, cnt + 600, dir);
            }
            visited[yy][xx] = false;
        }
    }



	public static void main(String[] args)
	{
		new PG_KAKAOA_경주로().solution(board2);
	}

}
