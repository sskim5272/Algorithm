package hw.step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2564_Guard
{
	static boolean board[][] = new boolean[100][100];
	static int pos[][];

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		pos = new int[N][2];

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());
		int gdir = Integer.parseInt(st.nextToken());
		int gdis = Integer.parseInt(st.nextToken());
		int x, y;
		if (gdir == 1)
		{
			y = row;
			x = gdis;
		} else if (gdir == 2)
		{
			y = 0;
			x = gdis;
		} else if (gdir == 3)
		{
			y = row - gdis;
			x = 0;
		} else
		{
			y = row - gdis;
			x = col;
		}

		int ans = 0;
		for (int xx[] : pos)
		{
			int dir = xx[0];
			int dis = xx[1];

			int x1, y1;

			if (dir == 1)
			{
				y1 = row;
				x1 = dis;
			} else if (dir == 2)
			{
				y1 = 0;
				x1 = dis;
			} else if (dir == 3)
			{
				y1 = row - dis;
				x1 = 0;
			} else
			{
				y1 = row - dis;
				x1 = col;
			}

			// 같은 경우
			if ((gdir < 3 && dir < 3))
			{
				if (gdir == dir)
				{
					ans += Math.abs(x1 - x);
				} else
				{

					int t1 = Math.abs(y1 - y) + Math.abs(x + x1);
					int t2 = Math.abs(y1 - y) + col - x + col - x1;
					ans += Math.min(t1, t2);
				}

			} else if ((gdir > 2 && dir > 2))
			{
				if (gdir == dir)
				{
					ans += Math.abs(y1 - y);
				} else
				{
					int t1 = Math.abs(x1 - x) + Math.abs(y + y1);
					int t2 = Math.abs(x1 - x) + row - y + row - y1;
					ans += Math.min(t1, t2);
				}
			} else
			{
				ans += (Math.abs(x - x1) + Math.abs(y - y1));
			}
		}
		System.out.println(ans);

	}
}
