package ws.step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class chyoungsGroup
{
	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x, y;
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
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
//			Set<Integer> set=new TreeSet<Integer>();
//			for(int i=1;i<parents.length;i++) {
//				set.add(parents[i]);
//			}
			int cnt = 0;
			for (int i = 1; i < parents.length; i++)
			{
				if (parents[i] == i)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static int findSet(int x)
	{
		if (x == parents[x])
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
