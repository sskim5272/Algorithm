package ws.step11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class house
{
	int x;
	int y;
	int dis = 0;

	public house(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

}

public class BJ_15686_ChickenDelivery
{

	static int N, M;
	static List<house> houses12 = new ArrayList<house>();
	static List<house> Restaurant = new ArrayList<house>();
	static int ans ;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans=M*M*2*M;
		int chickCnt = 0;
		for (int r = 1; r <= N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++)
			{
				int t = Integer.parseInt(st.nextToken());
				if (t == 1)
					houses12.add(new house(c, r));
				if (t == 2)
				{
					Restaurant.add(new house(c, r));
					chickCnt++;
				}
			}
		}

		if (Restaurant.size() > M)
		{
			combination(M, 0, new int[chickCnt]);
		} else
		{

			int select[] = new int[chickCnt];
			for (int i = 0; i < chickCnt; i++)
			{
				select[i] = 1;
			}

			ans = findDis(houses12, select);
		}

		System.out.println(ans);
	}

	private static void combination(int m, int start, int[] select)
	{
		if (m == 0)
		{
			List<house> temp = new ArrayList<>(houses12);
			int tempAns = findDis(temp, select);
			if (tempAns < ans)
			{
				ans = tempAns;
			}
		}
		for (int i = start; i < m; i++)
		{
			select[i] = 1;
			combination(m - 1, i + 1, select);
			select[i] = 0;
		}

	}

	private static int findDis(List<house> houses, int[] select)
	{
		for (int i = 0; i < houses.size(); i++)
		{
			house temp = houses.get(i);
			int minDis = 2 * M;

			for (int j = 0; j < select.length; j++)
			{
				if (select[j] == 0)
					continue;
				house h = Restaurant.get(j);
				int dis = Math.abs(temp.x - h.x) + Math.abs(temp.y - h.y);
				if (dis < minDis)
				{
					minDis = dis;
				}
			}
			temp.dis = minDis;
			houses.set(i, temp);
		}

		int answer = 0;

		for (house h : houses)
		{
			answer += h.dis;
		}

		return answer;
	}

}
