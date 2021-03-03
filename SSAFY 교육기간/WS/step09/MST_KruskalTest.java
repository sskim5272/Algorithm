package ws.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class MST_KruskalTest
{
	static class Edge implements Comparable<Edge>
	{
		int from, to, weight;

		public Edge(int from, int to, int weight)
		{
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o)
		{
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static Edge[] edgelist;
	static int parents[];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgelist = new Edge[E];
		parents = new int[V];
		int from, to, weight;
		for (int i = 0; i < E; i++)
		{
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(edgelist);
		make();
		int cnt = 0, result = 0;
		for (Edge edge : edgelist)
		{
			if (union(edge.from, edge.to))
			{
				result += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(result);

	}

	private static void make()
	{
		for (int i = 0; i < V; i++)
		{
			parents[i] = i;
		}
	}

	private static int find(int x)
	{
		if (parents[x] == x)
			return x;
		else
			return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y)
	{
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		parents[y] = x;
		return true;
	}
}
