package hw.step10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1992_QuadTree
{
	static int grid[][];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		grid = new int[N][N];
		for (int row = 0; row < N; row++)
		{
			String temp = br.readLine();
			for (int col = 0; col < N; col++)
			{
				grid[row][col] = temp.charAt(col) - '0';
			}
		}

		solution(0, 0, N, N);

	}

	private static void solution(int stRow, int stCol, int rowBound, int colBound)
	{
//		System.out.println(stRow+" "+stCol +" "+ rowBound+" "+ colBound);
		int flag = grid[stRow][stCol];
		outer: for (int row = stRow; row < rowBound; row++)
		{
			for (int col = stCol; col < colBound; col++)
			{
				if (flag != grid[row][col])
				{
					flag = -1;
					break outer;
				}
			}
		}

		if (flag != -1)
		{
			System.out.print(flag);
			return;
		}

		System.out.print("(");
		// 1사분면
		solution(stRow							, stCol							, stRow + ((rowBound - stRow) / 2), stCol + ((colBound - stCol) / 2));
		// 2사분면
		solution(stRow							, stCol + ((colBound - stCol) / 2), stRow + ((rowBound - stRow) / 2), colBound);
		// 3사분면
		solution(stRow + ((rowBound - stRow) / 2), stCol							, rowBound						, stCol + (colBound - stCol)/2);
		// 4사분면
		solution(stRow + ((rowBound - stRow) / 2)	, stCol + ((colBound - stCol) / 2), rowBound						, colBound);

		System.out.print(")");
	}
}
