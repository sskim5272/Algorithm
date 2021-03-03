package ws.step12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406_ArrayRotation
{
	static int N, M, K, ans;
	static int grid[][];
	static int rotate[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, +1, 0, -1 };

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 100 * M;
		grid = new int[N][M];
		rotate = new int[K][3];

		for (int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++)
			{
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++)
		{
			st = new StringTokenizer(br.readLine());
			rotate[k][0] = Integer.parseInt(st.nextToken());
			rotate[k][1] = Integer.parseInt(st.nextToken());
			rotate[k][2] = Integer.parseInt(st.nextToken());
		}
		int order[] = new int[K];
		for (int k = 0; k < K; k++)
			order[k] = k;
		permutation(order, 0, K, K);
		System.out.println(ans);
	}

	static void solution(int tempGrid[][], int order[])
	{
		for (int i = 0; i < order.length; i++)
		{
			int r = rotate[order[i]][0]-1;
			int c = rotate[order[i]][1]-1;
			int s = rotate[order[i]][2];

			for (int step = 1; step <= s; step++)
			{
				int nr = r - step;
				int nc = c - step;
				int temp1=0,temp2=0;
				temp1=tempGrid[nr][nc];
				for (int dir = 0; dir < 4; dir++)
				{
					for (int k = 0; k < step*2; k++)
					{
						nr+=dy[dir];
						nc+=dx[dir];
						
						temp2=temp1;
						temp1=tempGrid[nr][nc];
						
						tempGrid[nr][nc]=temp2;						
					}
				}
			}
		}
		
		for(int[] xx:tempGrid) {
			int sum=0;
			for(int x:xx) {
				sum+=x;
			}
			if(ans>sum) ans=sum;
		}		

	}

	static void permutation(int[] arr, int depth, int n, int r)
	{
		if (depth == r)
		{
			int temp[][]=new int [N][M];
			for (int row = 0; row < N; row++)
			{
				for (int c = 0; c < M; c++)
				{
					temp[row][c] = grid[row][c];
				}
			}
			
			solution(temp, arr);
		}

		for (int i = depth; i < n; i++)
		{
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i)
	{
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
