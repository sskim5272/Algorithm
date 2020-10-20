package Algo1011;

class Solution1
{
	static int parents[];

	public int solution(int n, int[][] computers)
	{
		int answer = n;
		parents = new int[n];
		for (int i = 0; i < n; i++)
		{
			parents[i]=i;
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = i+1; j < n; j++)
			{
				if(computers[i][j]==1) unionSet(i, j);
			}
		}
		for (int i = 0; i < n; i++) {
			if(parents[i]==i) continue;
			answer--;
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
