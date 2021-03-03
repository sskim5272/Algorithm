package Alog1105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑지뢰찾기
{
	static int N, ans;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean check[];
	static int dx[] = { 1,  0, -1, -1, 1, 1, 0, -1 };
	static int dy[] = { 1,  1,  1,  0, 0,-1,-1, -1 };
	static char map[][];
	static int NN;

	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++)
		{			
			System.out.println("#" + test_case + " " + solution());
		}
	}

	private static int solution() throws Exception
	{
		ans = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		NN = (N * N) / 2 + 10;
		map = new char[N][N];
		for (int i = 0; i < N; i++)
		{
			String str = br.readLine().trim();
			for (int j = 0; j < N; j++)
			{
				for (int k = 0; k < NN; k++)
				{
					map[i][j] = str.charAt(j);
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{

				if (map[i][j] != '.')
					continue;
				bfs(i, j);
				cnt++;
			}
		}
		return cnt;

	}

	private static void bfs(int y, int x)
	{

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		map[y][x] = '-';

		while (!q.isEmpty())
		{
			int pos[] = q.poll();
			int cnt = 0;
			List<int[]> list = new ArrayList<int[]>();
			x = pos[0];
			y = pos[1];
			map[y][x] = '-';
			for (int dir = 0; dir < 8; dir++)
			{
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N )
					continue;
				if(map[ny][nx] == '.')
				list.add(new int[] { nx, ny });
				else if(map[ny][nx] == '*') cnt++;
				
			}
			if(cnt==0) {
				for(int xx[]:list) {
					q.offer(xx);
				}
			}
			
		}

	}

}
