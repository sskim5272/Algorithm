package ws.step16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{

	int e;
	int w;
	
	
	public Edge(int e, int w)
	{
		super();
		this.e = e;
		this.w = w;
	}


	@Override
	public int compareTo(Edge o)
	{
		// TODO Auto-generated method stub
		return this.w-o.w;
	}
	
}

public class BJ_1753_shortCut
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine().trim());
		int start = 0;
		int end = V - 1;
		final int INFINITY = Integer.MAX_VALUE;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		for (int i = 0; i < E; i++)
		{
			st = new StringTokenizer(br.readLine());
			String u = (st.nextToken());
			String v = (st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map.put(u + "+" + v, w);
		}
		
		
		
		Arrays.fill(distance, INFINITY);
		distance[K - 1] = 0;
		pq.add(new Edge(K-1,0 ));
		

		int min = 0, current = 0;

		for (int i = 0; i < V; i++)
		{
			min = INFINITY;
			// 1.방문하지 않은 정점중에 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
//			for (int j = 0; j < V; j++)
//			{
//				if (!visited[j] && distance[j] < min)
//				{
//					min = distance[j];
//					current = j;
//				}
//			}
			
			if(pq.isEmpty()) break;
			Edge e=pq.poll();
			
			current=e.e;
			min=e.w;
			visited[current] = true;
		

			// 2. 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 업데이트
			for (int j = 0; j < V; j++)
			{

				if (!visited[j]&&map.containsKey(Integer.toString(current + 1) + "+" + Integer.toString(j + 1))
						&& distance[j] > min + map.get(Integer.toString(current + 1) + "+" + Integer.toString(j + 1))
						&& map.get(Integer.toString(current + 1) + "+" + Integer.toString(j + 1)) != 0)
				{
					distance[j] = min + map.get(Integer.toString(current + 1) + "+" + Integer.toString(j + 1));
				}
			}

		}
		for (int x : distance)
		{
			if (x == INFINITY)
				System.out.print("INF\n");
			else
				System.out.print(x+"\n");
		}

	}
}
