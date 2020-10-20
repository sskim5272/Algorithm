package ws.step05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PerfectSuffle
{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		new PerfectSuffle().testcase();
	}

	private void testcase()
	{
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			solution(test_case);
		}

	}

	private void solution(int test_case)
	{
		int N = sc.nextInt();
		Queue<String> s1 = new LinkedList<String>();
		Queue<String> s2 = new LinkedList<String>();

		for (int i = 0; i < (N + 1) / 2; i++)
		{
			s1.offer(sc.next());
		}
		for (int i = 0; i < N / 2; i++)
		{
			s2.offer(sc.next());
		}

		System.out.print("#" + test_case + " ");
		while (true)
		{
			if (s1.isEmpty() == false)
				System.out.print(s1.poll() + " ");
			if (s2.isEmpty() == false)
				System.out.print(s2.poll() + " ");
			else
				break;
		}
		System.out.println();

	}
}
