package ws.step16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2
{
	static class Vertex implements Comparable<Vertex>
	{
		int no, totalDistance;

		public Vertex(int no, int totalDistance)
		{
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o)
		{
			// TODO Auto-generated method stub
			return this.totalDistance - o.totalDistance;
		}

	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine().trim());
		int start = 0;
		int end = V - 1;
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		pq.add(new Vertex(start, distance[start]));

		int min = 0;
		Vertex current = null;

		while (pq.isEmpty())
		{

			min = INFINITY;
			// 1.방문하지 않은 정점중에 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			current=pq.poll();
			if(visited[current.no]) continue;
			visited[current.no] = true;
			
			
			if (current.no == end)
				break;

			// 2. 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 업데이트
			for (int j = 0; j < V; j++)
			{
				// min--
				if (!visited[j] && distance[j] > current.totalDistance + matrix[current.no][j] && matrix[current.no][j] != 0)
				{
					distance[j] = current.totalDistance + matrix[current.no][j];
					pq.offer(new Vertex(j, distance[j]));
				}
			}

		}

		System.out.println(distance[end]);

	}
}
