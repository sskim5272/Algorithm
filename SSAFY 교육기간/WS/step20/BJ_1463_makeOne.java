package ws.step20;

import java.util.Scanner;

public class BJ_1463_makeOne
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer[] = new int[N + 1];
		answer[1] = 0;
		int mins = Integer.MAX_VALUE;
		for (int i = 2; i <= N; i++)
		{
			mins = answer[i - 1] + 1;
			if ((i % 3) == 0)
				mins = Math.min(mins, answer[(i / 3)] + 1);
			if ((i % 2) == 0)
				mins = Math.min(mins, answer[(i / 2)] + 1);
			answer[i] = mins;
		}

		System.out.println(answer[N]);
	}
}
