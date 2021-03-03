package ws.step03;

import java.util.Scanner;

public class BattlefieldOfSangHO
{
	static Scanner sc = new Scanner(System.in);
	char grid[][];
	int[] pos = new int[2];

	public static void main(String[] args)
	{
		new BattlefieldOfSangHO().testcase();
	}

	int dx[] =
	{ 0, 0, -1, 1 }; // �����¿�
	int dy[] =
	{ -1, +1, 0, 0 };

	private void testcase()
	{
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			solution();

			System.out.print("#" + test_case + " ");
			for (char xx[] : grid)
			{
				for (char x : xx)
				{
					System.out.print(x);
				}
				System.out.println();
			}
		}
	}

	private void S()
	{
		int dir = 0;
		int x = pos[0];
		int y = pos[1];
		int H = grid.length;
		int W = grid[0].length;

		for (int i = 0; i < 4; i++)
		{
			if ("^v<>".charAt(i) == grid[y][x])
				dir = i;
		}

		while (true)
		{
			x += dx[dir];
			y += dy[dir];
			if (x < 0 || y < 0 || x >= W || y >= H)
				break;

			if (grid[y][x] == '#')
				break;

			else if (grid[y][x] == '*')
			{
				grid[y][x] = '.';
				break;
			}
		}

	}

	private void move(int dir)
	{
		int xGo = pos[0] + dx[dir];
		int yGo = pos[1] + dy[dir];
		int H = grid.length;
		int W = grid[0].length;

		grid[pos[1]][pos[0]] = "^v<>".charAt(dir);

		if (xGo < 0 || yGo < 0 || xGo >= W || yGo >= H)
			return;

		char state = grid[yGo][xGo];

		if (state == '.')
		{
			grid[yGo][xGo] = "^v<>".charAt(dir);
			grid[pos[1]][pos[0]] = '.';
			pos[0] = xGo;
			pos[1] = yGo;
		}

	}

	private void solution()
	{
		int H, W, CT, x, y;
		x = 0;
		y = 0;
		H = sc.nextInt();
		W = sc.nextInt();
		grid = new char[H][W];

		for (int i = 0; i < H; i++)
		{
			String msg = sc.next();
			for (int j = 0; j < W; j++)
			{
				if ('^' == msg.charAt(j) || 'v' == msg.charAt(j) || '<' == msg.charAt(j) || '>' == msg.charAt(j))
				{
					pos[0] = j;
					pos[1] = i;
				}
				grid[i][j] = msg.charAt(j);
			}
		}
		
		CT = sc.nextInt();
		String order = sc.next();
		char menu = '0';

		for (int i = 0; i < CT; i++)
		{
			menu = order.charAt(i);

			switch (menu)
			{
			case 'U':
				move(0);
				break;
			case 'D':
				move(1);
				break;
			case 'L':
				move(2);
				break;
			case 'R':
				move(3);
				break;
			case 'S':
				S();
				break;
			default:
				break;
			}
		}

	}

}
