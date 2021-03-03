package Algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16236_아기상어
{
	static int[][] grid;
	static int exp, N;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int row = 0; row < N; row++)
		{
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++)
			{
				grid[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int[] xx : grid)
		{
			for (int x : xx)
			{
				System.out.print(x);
			}
			System.out.println();
		}
	}
}