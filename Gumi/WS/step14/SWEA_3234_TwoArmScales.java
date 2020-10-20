package ws.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_TwoArmScales
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer, weight[];

	public static void main(String[] args) throws Exception
	{

		new SWEA_3234_TwoArmScales().testCase();
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
		answer = 0;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		weight = new int[N];
		int order[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			weight[i] = Integer.parseInt(st.nextToken());
			order[i] = i;
		}

		permutation(order, 0, N, N);

	}

	private void dfs(int[] arr, int start, int left, int right)
	{
		if (start == arr.length )
		{
			answer++;
			return;
		}

		int addWeight = weight[arr[start]];
		// 왼쪽에 놓는 경우
		if (addWeight + left <= right)
		{
			dfs(arr, start + 1, addWeight + left, right);
		}
		// 오른쪽에 놓는 경우
		dfs(arr, start + 1, left, addWeight + right);
	}

	void permutation(int[] arr, int depth, int n, int r)
	{
		if (depth == r)
		{
			dfs(arr, 0, 0, 0);
		}

		for (int i = depth; i < n; i++)
		{
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	void swap(int[] arr, int depth, int i)
	{
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
