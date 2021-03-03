package Algo1011;

import java.util.Arrays;
import java.util.Comparator;

class Solution
{

	static int parents[];

	public int solution(int n, int[][] costs)
	{
		int answer = 0;
		parents = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			parents[i]=i;
		}

		Arrays.sort(costs, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] s1, int[] s2)
			{
				return s1[2] - s2[2];
			}
		});
		int ct=0;
		for(int i=0;i<n;i++) {
			if (ct==n-1) break;
			int start=costs[i][0];
			int end=costs[i][1];
			int cost=costs[i][2];
			
			if(findSet(start)==findSet(end)) continue;
			System.out.println(cost);
			unionSet(start, end);
			answer+=cost;
			ct++;
		}
		for(int x:parents) {
			System.out.print(x+" ");
			
		}

		return answer;
	}
	
	static int findSet(int x)
	{
		if (parents[x] == x)
		{
			return x;
		} else
		{
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
