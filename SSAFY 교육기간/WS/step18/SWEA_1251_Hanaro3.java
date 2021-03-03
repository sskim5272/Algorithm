package ws.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.corba.se.spi.ior.MakeImmutable;

public class SWEA_1251_Hanaro3
{
	static int N;
	static long adjMatrix[][], E;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());

			adjMatrix = new long[N][N];
			int[] x = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
			{
				x[i] = Integer.parseInt(st.nextToken());
			}

			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
			{
				y[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					adjMatrix[i][j] = adjMatrix[j][i] = getDistance(x[i], x[j], y[i], y[j]);
				}
			}

			double E = Double.parseDouble(br.readLine());
			System.out.println("#" + t + " " + Math.round(E * makeMST()));
		}
	}

	private static double makeMST()
	{
		long[] minEdge = new long[N];
		boolean visited[] = new boolean[N];

		long result = 0;
		int cnt = 0;

		Arrays.fill(minEdge, Long.MAX_VALUE);

		while (true)
		{
			// 1단계 : 신장트리에 포함되지 않은 정점중 최소간선비용의 정점 선택
			long min = Long.MAX_VALUE;
			int minNo = 0;

			for (int i = 0; i < N; i++)
			{
				if (!visited[i] && min > minEdge[i])
				{
					min = minEdge[i];
					minNo = i;
				}
			}

			visited[minNo] = true;
			result += min;
			if (++cnt == N)
				break;
			// 2단계 선택된 정점에서 신장트리에 포홤되지 앟은 정점들로의 간선의 비용을 고려하여 minEdge 업데이트

			for (int i = 0; i < N; i++)
			{
				if (!visited[i] && adjMatrix[minNo][i] > 0 && minEdge[i] > adjMatrix[minNo][i])
				{
					minEdge[i]=adjMatrix[minNo][i];
				}
			}

		}

		return result;
	}

	private static long getDistance(int x1, int x2, int y1, int y2)
	{

		return (long) (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}


}
