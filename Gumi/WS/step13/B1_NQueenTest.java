package ws.step13;

import java.util.Scanner;

public class B1_NQueenTest
{
	static int N;
	static int[] col;
	static int answer;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		setQueens(1);
		System.out.println(answer);
	}

	// 퀸을 현재 rowNo에 놓기
	private static void setQueens(int rowNo)
	{
		if (rowNo > N)
		{
//			System.out.println(answer++);
			answer++;
			return;
		}

		// 가능한 선택지 (1열 ~ N열)
		for (int j = 1; j <= N; j++)
		{
			col[rowNo] = j;
			if (checking(rowNo) == false)
			{
				continue;
			}
			setQueens(rowNo + 1);
		}

	}

	private static boolean checking(int rowNo)
	{
		for (int i = 1; i < rowNo; i++)
		{
			if (col[rowNo] == col[i] || (Math.abs(rowNo - i) == Math.abs(col[rowNo] - col[i])))
				return false;
		}
		return true;
	}

}
