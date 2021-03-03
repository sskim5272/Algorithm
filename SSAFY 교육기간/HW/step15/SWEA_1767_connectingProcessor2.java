package hw.step15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_connectingProcessor2
{
	static int grid[][], N, max, min, totalCnt; // 멕시노스판, 판크기, 최대 코어수, 최소 간선 길이,처리할 코어수
	static ArrayList<int[]> list;
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception
	{
		new SWEA_1767_connectingProcessor2().testCase();
	}

	private void testCase() throws Exception
	{
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++)
		{
			solution();
			System.out.println("#" + t + " " + min);
		}

	}

	private int solution() throws Exception
	{
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		list = new ArrayList<int[]>();
		max = 0;
		min = Integer.MAX_VALUE;
		totalCnt = 0;

		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken());
				if ((r == 0 || c == 0 || c == N - 1 || r == N - 1) && grid[r][c] == 1)
					continue;
				if (grid[r][c] == 1)
				{
					list.add(new int[] { r, c });
					totalCnt++;
				}
			}
		}
		go(0, 0, 0);

		return 0;
	}

	// index : 처리할 코어의 index, cnt :직전까지 포함된 코어수
	private void go(int index, int cnt, int lcnt)
	{
		//현재까지 연결된 코어수  +앞으로 연결할 코어수 == 기대할수 있는 코어수 
		if(cnt+(totalCnt-index-1)<max) return ;
		
		
		if (index == totalCnt)
		{
			if (max < cnt)
			{
				max = cnt;
				min = lcnt;
			} else if (max == cnt)
			{
				if (min > lcnt)
				{
					min = lcnt;
				}
			}
			return;

		}

		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[0];
		// 해당 코어 선택
		// 4방향의 직선으로 전선 놓아보는 시도
		for (int dir = 0; dir < 4; dir++)
		{
			// 해당 방향으로 전선을 놓는게 가능한지 체크
			if (isAvailable(r, c, dir))
			{
				// 가능하다면 전선놓기 : 2로 체크
				int len=setStatus(r, c, dir, 2);
				// 다음 코어로 넘어가기
				go(index + 1, cnt + 1,lcnt+len);
				// 전선 회수
				setStatus(r, c, dir, 0);
			}
		}

		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 코어로 넘어가기
		go(index + 1, cnt,lcnt);

	}

	// 현코어 위치에서 해당 방향으로 전선을 놓은게 가능한지 체크
	private boolean isAvailable(int r, int c, int dir)
	{
		int nr = r, nc = c;
		while (true)
		{
			nr += dy[dir];
			nc += dy[dir];
			if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
				break;
			if (grid[nr][nc] > 1)
				return false;

		}
		return true;
	}

	int setStatus(int r, int c, int dir, int s)
	{
		int cnt = 0;
		int nr = r, nc = c;
		while (true)
		{
			nr += dy[dir];
			nc += dy[dir];

			if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
				break;
			grid[nr][nc] = s;
			cnt++;
		}

		return cnt;
	}

}
