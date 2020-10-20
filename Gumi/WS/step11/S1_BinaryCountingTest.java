package ws.step11;

import java.util.Scanner;

public class S1_BinaryCountingTest
{
	static int N;
	static int[] numbers;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++)
		{
			numbers[i] = sc.nextInt();

		}

		int caseCount = 1 << N;
		generateSubset(caseCount);
	}

	private static void generateSubset(int caseCount)
	{
		for (int flag = 0; flag < caseCount; flag++)
		{
			for (int j = 0; j < N; j++)
			{
				if ((flag & (1 << j)) != 0)
				{
					System.out.print( numbers[N-j-1]+" ");
				}
			}
			System.out.println();
		}

	}
}
