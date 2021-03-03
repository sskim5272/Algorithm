package hw.step15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_connectingProcessor
{
	static int grid[][], N, max, min, totalCnt; // 멕시노스판, 판크기, 최대 코어수, 최소 간선 길이,처리할 코어수
	static ArrayList<int[]> list;
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception
	{
		new SWEA_1767_connectingProcessor().testCase();
	}

	private void testCase() throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(in.readLine());
			grid = new int[N][N];
			list = new ArrayList<int[]>(); // 처리해야할 가장자리가 아닌 코어들을 저장할 리스트
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; i++)
			{
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++)
				{
					grid[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || j == 0 || i == N - 1 || j == N - 1) && grid[i][j] == 1)
						continue; // 가장자리에 있는 코어는 리스트에 추가하지 않음
					// 가장자리에 있지 않은 코어 리스트에 추가
					if (grid[i][j] == 1)
					{
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			} 
			go(0, 0);
			System.out.println("#" + t + " " + min);
		} 

	}

	// index : 처리할 코어의 index, cnt :직전까지 포함된 코어수
	private void go(int index, int cnt)
	{
		if (index == totalCnt)
		{
			int res = getLength();
			if (max < cnt)
			{
				max = cnt;
				min = res;
			} else if (max == cnt)
			{
				if (min > res)
				{
					min = res;
				}
			}
			return;

		}

		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		// 해당 코어 선택
		// 4방향의 직선으로 전선 놓아보는 시도
		for (int dir = 0; dir < 4; dir++)
		{
			// 해당 방향으로 전선을 놓는게 가능한지 체크
			if (isAvailable(r, c, dir))
			{
				// 가능하다면 전선놓기 : 2로 체크
				setStatus(r, c, dir, 2);
				// 다음 코어로 넘어가기
				go(index + 1, cnt + 1);
				// 전선 회수
				setStatus(r, c, dir, 0);
			}
		}

		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 코어로 넘어가기
		go(index + 1, cnt);

	}

	// 현코어 위치에서 해당 방향으로 전선을 놓은게 가능한지 체크
	private boolean isAvailable(int r, int c, int dir)
	{
		int nr = r, nc = c;
		while (true)
		{
			nr += dy[dir];
			nc += dx[dir];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;
			if (grid[nr][nc] >= 1)
				return false;

		}
		return true;
	}

	void setStatus(int r, int c, int dir, int s)
	{
		int nr = r, nc = c;
		while (true)
		{
			nr += dy[dir];
			nc += dx[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;
			grid[nr][nc] = s;
		}
	}

	int getLength()
	{
		int cnt = 0;
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < N; c++)
			{
				if (grid[r][c] == 2)
					cnt++;
			}
		}
		return cnt;
	}
}
