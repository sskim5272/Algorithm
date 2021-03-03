package hw.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2477_chamwaeArea
{
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int pos[][] = new int[6][2];

		int preX = 0;
		int preY = 0;

		int maxX = 0;
		int maxY = 0;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++)
		{
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());
			preX += dis * dx[dir];
			preY += dis * dy[dir];
			pos[i] = new int[] { preX, preY };
			if (Math.abs(maxX) < Math.abs(preX))
			{
				maxX = preX;
			}
			if (Math.abs(maxY) < Math.abs(preY))
			{
				maxY = preY;
			}
			if (Math.abs(minX) > Math.abs(preX))
			{
				minX = preX;
			}
			if (Math.abs(minY) > Math.abs(preY))
			{
				minY = preY;
			}
		}

		int midX = 0;
		int midY = 0;

		for (int i = 0; i < 6; i++)
		{
			int tempx = pos[i][0];
			int tempy = pos[i][1];
			if (tempx == maxX || tempx == 0 || tempy == maxY || tempy == 0)
			{
				continue;
			}
			midX = tempx;
			midY = tempy;

		}
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < 6; i++)
		{
			int tempx = pos[i][0];
			int tempy = pos[i][1];
			if (tempx == midX || tempy == midY)
			{
				if(tempx == midX && tempy == midY) continue;
				list.add(new int[] { tempx, tempy });
			}

		}
		int allArea = maxX * maxY;
		int subArea = Math.abs((list.get(0)[0] - list.get(1)[0]) * (list.get(0)[1] - list.get(1)[1]));

		System.out.println(K * (allArea - subArea));
	}
}
