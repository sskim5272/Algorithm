package ws.step05;

import java.util.Scanner;

public class RectangleRoom
{
	Scanner sc = new Scanner(System.in);
	int grid[][][];
	int N;
	int[] dx = { 0, -1, 0, +1 }; // �����¿� 0,1,2,3
	int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args)
	{
		new RectangleRoom().testCase();
	}

	private void testCase()
	{
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			int[] ans = solution();
			System.out.println("#" + t + " " + ans[0] + " " + ans[1]);
		}
	}

	private int[] solution()
	{
		N = sc.nextInt();
		grid = new int[N][N][2];
		int max=0;//��
		int low_digit=1000000;//����
		
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				grid[row][col][0] = sc.nextInt(); // ����
				grid[row][col][1] = -1; // �Ÿ���
			}
		}

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				grid[row][col][1] = search(row, col, -1);	
				if(max<grid[row][col][1]) max=grid[row][col][1];
			}
		}
		
		for (int xxx[][] : grid)
		{
			for (int xx[] : xxx)
			{
				if(xx[1]>max) {
					max=xx[1];
				}
			}
		}
		
		for (int xxx[][] : grid)
		{
			for (int xx[] : xxx)
			{
				if(xx[1]==max&& xx[0]<low_digit) {
					low_digit=xx[0];
				}
			}
		}
		return new int[] {low_digit,max};
	}

	// ������ x,y�� grid �ȿ� ��ġ,
	private int search(int row, int col, int predir)
	{
		int max = 1;
		//���� �Ǿ������� �װ� return 
		if (grid[row][col][1] != -1)
			return grid[row][col][1];

		// 4���� Ž��
		for (int dir = 0; dir < 4; dir++)
		{
			int ans = 1;
			int newCol = col + dx[dir];
			int newRow = row + dy[dir];

			if (newCol < 0 || newCol >= N || newRow < 0 || newRow >= N || predir == dir)
			{
				continue;
			}

			if ((grid[row][col][0] + 1) == grid[newRow][newCol][0])
			{
				ans += search(newRow, newCol, (dir + 2) % 4);
			}

			if (max < ans)
				max = ans;
		}

		return max;
	}

}
