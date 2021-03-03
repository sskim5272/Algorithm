package ws.step13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_shortestPath
{
	static int home[] = new int[2];
	static int office[] = new int[2];
	static int grid[][];
	static int answer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception
	{
		new SWEA_1247_shortestPath().testCase();
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

	private void solution() throws Exception
	{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		grid = new int[N][2];

		st = new StringTokenizer(br.readLine());
		office[0] = Integer.parseInt(st.nextToken());
		office[1] = Integer.parseInt(st.nextToken());
		home[0] = Integer.parseInt(st.nextToken());
		home[1] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
		{
			grid[i][0] = Integer.parseInt(st.nextToken());
			grid[i][1] = Integer.parseInt(st.nextToken());
		}

		int order[] = new int[N];
		for (int i = 0; i < N; i++)
		{
			order[i] = i;
		}
		answer=200*11;
		permutation(order, 0, N, N);

	}

	void permutation(int[] arr, int depth, int n, int r)
	{
		if (depth == r)
	{
//			for(int x: arr) {
//				System.out.print(x);
//			}
//			System.out.println();
			findPath(arr);
		}

		for (int i = depth; i < n; i++)
		{
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	private void findPath(int[] arr)
	{
		int sum=calDis(office[0],grid[arr[0]][0],office[1],grid[arr[0]][1]);
		int n=arr.length;
		for (int i = 0; i < n-1; i++)
		{
			sum+=calDis(grid[arr[i]][0],grid[arr[i+1]][0],grid[arr[i]][1],grid[arr[i+1]][1]);
		}
		sum+=calDis(home[0],grid[arr[n-1]][0],home[1],grid[arr[n-1]][1]);
		
		if (answer>sum) {
			answer=sum;
		}
	}

	private int calDis(int x1, int x2, int y1, int y2)
	{
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

	void swap(int[] arr, int depth, int i)
	{
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}
