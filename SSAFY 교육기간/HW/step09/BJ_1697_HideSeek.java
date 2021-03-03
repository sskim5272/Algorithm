package hw.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_HideSeek
{

	static int N, K;
	static Queue<int[]> q = new LinkedList<int[]>();
	static boolean check[] = new boolean[100040];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K)
			System.out.println(0);
		else
			System.out.println(bfs());
	}

	private static int bfs()
	{
		q.offer(new int[] { N, 0 });
		check[N] = true;

		while (!q.isEmpty())
		{
			int[] s = q.poll();
			int pos = s[0];
			if (pos == K)
				return s[1];

			if (pos < 0 || pos > 100010)
				continue;

			if (pos - 1 >= 0 && check[pos - 1] == false)
			{
				check[pos - 1] = true;
				q.offer(new int[] { pos - 1, s[1] + 1 });
			}
			if (pos + 1 >= 0 && check[pos + 1] == false)
			{
				check[pos + 1] = true;
				q.offer(new int[] { pos + 1, s[1] + 1 });
			}
			if (pos * 2 >= 0 && pos * 2 < 100020 && check[pos * 2] == false)
			{
				check[pos * 2] = true;
				q.offer(new int[] { pos * 2, s[1] + 1 });
			}

		}

		return 0;
	}
}
