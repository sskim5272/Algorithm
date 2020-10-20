package Algo1014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
	static boolean visited[];

	public int solution(int n, int[][] edge)
	{
		int answer = 0;
		visited=new boolean[n+1];
		ArrayList<ArrayList<Integer>> listGraph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n + 1; i++)
		{
			listGraph.add(new ArrayList<Integer>());
		}
		for (int xx[] : edge)
		{
			listGraph.get(xx[0]).add(xx[1]);
			listGraph.get(xx[1]).add(xx[0]);
		}


		Queue<Node> q = new LinkedList<Node>();
		visited[1] = true;

		for (int x : listGraph.get(1))
		{
			visited[x] = true;
			q.offer(new Node(x, 1));
		}
		int maxCnt = 0;
		while (!q.isEmpty())
		{
			Node node = q.poll();
			int cnt = node.cnt;
			int pos = node.pos;
			System.out.println(node.pos + " " + node.cnt);
			if (cnt > maxCnt)
			{
				maxCnt = cnt;
				answer = 0;
			}
			answer++;
			for (int x : listGraph.get(pos))
			{
				if(visited[x]==false) {
					visited[x] = true;
					q.offer(new Node(x, cnt+1));					
				}
			}

		}
		System.out.println(maxCnt);
		return answer;
	}

}

class Node
{
	int pos;
	int cnt;

	public Node(int pos, int cnt)
	{
		super();
		this.pos = pos;
		this.cnt = cnt;
	}
}