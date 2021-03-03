package hw.step06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1863_ReligionCnt
{
	static int parents[];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];

		for (int i = 0; i < parents.length; i++)
		{
			parents[i] = i;
		}

		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		int ans = 0;
		for (int i = 1; i < parents.length; i++)
		{
			if (parents[i] == i)
				ans++;
		}

		System.out.println(ans);

	}

	private static int findSet(int x)
	{
		if (parents[x] == x)
			return x;
		else
			return parents[x] = findSet(parents[x]);
	}

	private static void union(int x, int y)
	{
		x = findSet(x);
		y = findSet(y);
		if (x != y)
			parents[y] = x;
	}

}
