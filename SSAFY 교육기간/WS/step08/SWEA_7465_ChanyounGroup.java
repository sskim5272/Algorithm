package ws.step08;

import java.io.IOException;
import java.util.Scanner;

public class ChanyounGroup
{
	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws Exception
	{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int state;
		int x, y;
		for (int t = 1; t <= T; t++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n + 1];
			for (int i = 0; i < parents.length; i++)
			{
				parents[i] = i;
			}
			for (int i = 0; i < m; i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				unionSet(x, y);
			}
			int cnt = 0;
			for (int i = 1; i < parents.length; i++)
			{
				if (parents[i] == i)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	static int findSet(int x)
	{
		if (parents[x] == x)
		{
			return x;
		} else
		{
			// path compresstion
			return parents[x] = findSet(parents[x]);
		}
	}

	static void unionSet(int x, int y)
	{
		x = findSet(x);
		y = findSet(y);
		if (x != y)
		{
			parents[y] = x;
		}
	}

}
