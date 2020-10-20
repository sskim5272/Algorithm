package ws.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6118_HideSeek
{
	static class State
	{
		int pos;
		int act;
		int cnt;

		public State(int pos, int act, int cnt)
		{
			this.pos = pos;
			this.act = act;
			this.cnt = cnt;
		}

	}

	static int N, K;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}

	private static int bfs()
	{
		q.offer(new int[] {N-1, 0, 0}); // x-1
		q.offer(new int[] {N+1, 1, 0}); // x+1
		q.offer(new int[] {N*2, 2, 0}); // x*2

		while (!q.isEmpty())
		{
			int [] s = q.poll();
			if (s[0] < K / 4 || s[0] > K * 2)
				continue;
			if (s[0] == K)
				return s[1];
			switch (s[0])
			{
			case 0:
				q.offer(new int[]{s[0] - 1, 0, s[2] + 1});
				q.offer(new int[]{s[0] +1, 1, s[2] + 1});
				q.offer(new int[]{s[0] *2, 2, s[2] + 1});
				break;                                
			case 1:
				q.offer(new int[]{s[0] - 1, 0, s[2] + 1});
				q.offer(new int[]{s[0] + 1, 1, s[2] + 1});
				q.offer(new int[]{s[0] * 1, 2, s[2] + 1});
				break;
			case 2:
				q.offer(new int[]{s[0] - 1, 0, s[2] + 1});
				q.offer(new int[]{s[0] + 1, 1, s[2] + 1});
				q.offer(new int[]{s[0] * 2, 2, s[2] + 1});
				break;
			}

		}

		return 0;
	}
}
