package Algo1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2239_스도쿠
{
	static int map[][] = new int[9][9];

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++)
		{
			String num = br.readLine().trim();
			for (int j = 0; j < 9; j++)
			{
				map[i][j] = num.charAt(j) - '0';
			}
		}

		loop(0, 0);

		for (int xx[] : map)
		{
			for (int x : xx)
			{
				System.out.print(x);
			}
			System.out.println();
		}
	}

	private static boolean loop(int r, int c)
	{
		if(c==9 && r<9) {
			return loop(r+1,0);
		}

		if (r >= 9 || c >= 9) {			
			return true;
		}

		if (map[r][c] != 0)
		{
			return (loop(r, c + 1) );
		} else
		{
			for (int n = 1; n < 10; n++)
			{
				if (check(r, c, n))
				{
					map[r][c] = n;
					if (loop(r, c + 1))
						return true;
					map[r][c] = 0;
				}
			}
		}

		return false;
	}

	private static boolean check(int r, int c, int n)
	{

		int rr = r / 3;
		int cc = c / 3;

		// 블럭 체크
		for (int br = rr * 3; br < (rr + 1) * 3; br++)
		{
			for (int bc = cc * 3; bc < (cc + 1) * 3; bc++)
			{

				if (n == map[br][bc])
					return false;
			}
		}

		for (int i = 0; i < 9; i++)
		{
			if (n == map[r][i] || n == map[i][c])
				return false;
		}

		return true;

	}

}
