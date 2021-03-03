package Alog1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취
{
	static int N, M, C;
	static int map[][], maxMap[][];
	static BufferedReader br;
	static StringTokenizer st;
	static boolean check[];

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
		int ans1 = 0;
		int ans2 = 0;
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		maxMap = new int[N][N - M + 1];

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> maxList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N - M + 1; j++)
			{
				makeOneMax(i, j);
				
			}
		}
		for (int i = 0; i < N; i++)
		{
			int temp=0;
			for (int j = 0; j < N - M + 1; j++)
			{
				temp = Math.max(maxMap[i][j], temp);
				
			}
			ans2 = Math.max(temp, ans2);
			int top = Math.max(ans2, ans1);
			int down = Math.min(ans2, ans1);
			ans1 = top;
			ans2 = down;
		}

		answer = ans1 + ans2;
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < N - M + 1; c++)
			{
				int t1 = maxMap[r][c];
				int t2 = 0;
				for (int i = c+C; i < N - M + 1; i = i + C)
				{
					t2 = Math.max(t2, maxMap[r][c]);
				}
				answer = Math.max(answer, t1 + t2);
			}
		}

		return answer;
	}

	private static void makeOneMax(int r, int c)
	{
		for (int pick = 1; pick <= M; pick++)
		{
			check = new boolean[M];
			combi(pick, 0, r, c);

		}
	}

	private static void combi(int pick, int st, int r, int c)
	{
		if (pick == 0)
		{
			int sum = 0;
			int size = 0;
			for (int i = 0; i < M; i++)
			{
				if (check[i] == false)
					continue;
				size += map[r][c + i];
				sum += map[r][c + i] * map[r][c + i];
				if (size > C)
					return;
			}

			maxMap[r][c] = Math.max(maxMap[r][c], sum);
			return;
		}
		for (int i = st; i < M; i++)
		{
			check[i] = true;
			combi(pick - 1, i + 1, r, c);
			check[i] = false;
		}

	}

}
