package ws.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_Cook
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer, grid[][];
	static boolean visietd[];

	public static void main(String[] args) throws Exception
	{

		new SWEA_4012_Cook().testCase();
	}

	private void testCase() throws Exception
	{
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++)
		{
			solution();
			System.out.println("#" + t + " " + answer);
		}

	}

	private void solution() throws IOException
	{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		grid = new int[N][N];
		visietd = new boolean[N];
//		for (int r = 0; r < N; r++)
//		{
//			st = new StringTokenizer(br.readLine());
//			for (int c = 0; c < N; c++)
//			{
//
//				grid[r][c] = Integer.parseInt(st.nextToken());
//			}
//		}
		int order[] = new int[N];
		for (int i = 0; i < N; i++)
			order[i] = i;

		combination(order, 0, 0);

	}

	void result(int[] arr)
	{
		int result1 = 0;
		int result2 = 0;
		int half = (arr.length / 2);
//		System.out.println("+++++++" + half);
		int cnt = 0;
		for (int i = 0; i < half; i++)
		{
			for (int j = 0; j < half; j++)
			{
				if (i == j)
					continue;
//				System.out.println(i + " " + (j));
//				System.out.println((half + i) + " " + (half + j));
				result1 += grid[arr[i]][arr[j]];
				result2 += grid[arr[half + i]][arr[half + j]];
				cnt++;
			}
		}
//		System.out.println(cnt+"%%");
		int res = Math.abs(result2 - result1);
		if (answer > res)
			answer = res;

	}

	void combination(int[] arr, int cur, int cnt)
	{
		if (arr.length== cnt)
		{
			for (int x : arr)
			{
				System.out.print(x);
			}
			System.out.println();
//			result(arr);
			return;
		}

		for (int i = cur; i < arr.length; i++)
		{
			if (visietd[i])
				continue;
			arr[cur] = i;
			visietd[i] = true;
			combination(arr, cur + 1, cnt + 1);
			visietd[i] = false;
			combination(arr, cur -1, cnt -1);
		}
	}
	
	

}
