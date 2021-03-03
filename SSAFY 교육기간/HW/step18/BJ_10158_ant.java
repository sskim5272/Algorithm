package hw.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_ant
{
	// 우상, 좌상, 좌하, 우하
	static int dx[] = { 1, -1, -1, 1 };
	static int dy[] = { 1, 1, -1, -1 };
	static int stx = 0;
	static int sty = 0;
	static int stdis = 0;
	static int stdir = 0;
	static int X;
	static int Y;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int curx = Integer.parseInt(st.nextToken());
		int cury = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int TT = T;
		boolean flag = false;
		int dir = 0;

		check(curx, cury, dir);
		int ct=0;
		while (T > 0)
		{
			if (stx == curx && sty == cury && dir == stdir)
			{
				ct++;
				if(ct==2) {
					int cnt = TT +stdis- T;
					T = T % cnt;					
				}
			}

			if (curx == X)
			{
				if (cury == Y)
					dir = 2;
				else if (cury == 0)
					dir = 1;
				else if (dir == 0)
					dir = 1;
				else if (dir == 3)
					dir = 2;

			} else if (curx == 0)
			{
				if (cury == Y)
					dir = 3;
				else if (cury == 0)
					dir = 0;
				else if (dir == 1)
					dir = 0;
				else if (dir == 2)
					dir = 3;
			} else if (cury == Y)
			{

				if (dir == 0)
					dir = 3;
				else if (dir == 1)
					dir = 2;
			} else if (cury == 0)
			{

				if (dir == 2)
					dir = 1;
				else if (dir == 3)
					dir = 0;
			}

			int dis = 1;
			if (flag)
			{
				dis = 1;
			} else if (dir == 0)
			{
				dis = Math.min(X - curx, Y - cury);
			} else if (dir == 1)
			{
				dis = Math.min(curx, Y - cury);
			} else if (dir == 2)
			{
				dis = Math.min(curx, cury);
			} else if (dir == 3)
			{
				dis = Math.min(X - curx, cury);
			}

			if (dis >= T)
			{
				curx += dx[dir] * T;
				cury += dy[dir] * T;
				break;
			} else
			{
				T = T - dis;
			}

			curx += dx[dir] * dis;
			cury += dy[dir] * dis;

		}
		System.out.println(curx + " " + cury);
	}

	private static void check(int curx, int cury, int dir)
	{
		if (curx == X)
		{
			if (cury == Y)
				dir = 2;
			else if (cury == 0)
				dir = 1;
			else if (dir == 0)
				dir = 1;
			else if (dir == 3)
				dir = 2;

		} else if (curx == 0)
		{
			if (cury == Y)
				dir = 3;
			else if (cury == 0)
				dir = 0;
			else if (dir == 1)
				dir = 0;
			else if (dir == 2)
				dir = 3;
		} else if (cury == Y)
		{

			if (dir == 0)
				dir = 3;
			else if (dir == 1)
				dir = 2;
		} else if (cury == 0)
		{

			if (dir == 2)
				dir = 1;
			else if (dir == 3)
				dir = 0;
		}

		int dis = 1;

		if (dir == 0)
		{
			dis = Math.min(X - curx, Y - cury);
		} else if (dir == 1)
		{
			dis = Math.min(curx, Y - cury);
		} else if (dir == 2)
		{
			dis = Math.min(curx, cury);
		} else if (dir == 3)
		{
			dis = Math.min(X - curx, cury);
		}

		stdis=dis;
		stdir = dir;
		stx += dx[dir] * dis;
		sty += dy[dir] * dis;

	}
}
