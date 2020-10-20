package hw.step16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_Hamiton
{
	static int N, grid[][],answer=Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		grid = new int [N][N];
		for (int r = 0; r < N; r++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken().trim());
			}
		}
		int arr[] = new int[N - 1];

		for (int r = 1; r < N; r++)
		{
			arr[r - 1] = r;
		}

		permutation(arr, 0, N - 1, N-1);
		
		System.out.println(answer);
	}

	static void permutation(int[] arr, int depth, int n, int r)
	{
		if (depth == r)
		{
			
			solution(arr);
			return;
		}

		for (int i = depth; i < n; i++)
		{
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	private static void solution(int[] arr)
	{
		int from = 0;
		int to = 0;
		int totalcnt = 0;
		for (int i = 0;i<N-1; i++)
		{
			to = arr[i];
//			System.out.print(from+" "+to+"~");
			if(grid[from][to]==0) return;
			totalcnt += grid[from][to];
			from = to;
		}
//		System.out.print(from+" "+to+"~");
//		System.out.println();
		
		if(grid[from][0]==0) return;
		totalcnt += grid[from][0];
		
		answer=Math.min(totalcnt, answer);

	}

	static void swap(int[] arr, int depth, int i)
	{
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
