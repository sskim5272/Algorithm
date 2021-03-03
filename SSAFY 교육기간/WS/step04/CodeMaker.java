package ws.step04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CodeMaker
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10, n;

		for (int test_case = 1; test_case <= T; test_case++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			sc.nextInt();
			n = 8;
			while (n-- > 0)
			{
				q.offer(sc.nextInt());
			}

			outer :while (true)
			{
				for (int minus = 1; minus <= 5; minus++)
				{
					int num = q.poll();
					num -= minus;
					if (num > 0)
					{
						q.offer(num);
					} else
					{
						q.offer(0);
						break outer;
					}
				}
			}
			
			System.out.printf("#%d", test_case);

			for (int i = 0; i < 8; i++)
			{
				System.out.printf(" %d", q.poll());
			}
			System.out.println();

		}
	}
}