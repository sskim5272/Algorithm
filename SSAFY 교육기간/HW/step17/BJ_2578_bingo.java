package hw.step17;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2578_bingo
{
	static int board[][] = new int[5][5];
	static int call[][] = new int[5][5];

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
			{
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
			{
				call[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		int ct=0;
		int bingo=0;
		loop: for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				ct++;
				int n = call[i][j];				
				if(check(n)>=3) {
					System.out.println(ct);
					break loop;
					
				}

			}
		}

	}

	private static int check(int n)
	{
		int ans=0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board[i][j] == n)
					board[i][j] = 0;
			}
		}

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board[i][j] != 0)
					break;
				if (j == 4)
					ans++;
			}
		}

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board[j][i] != 0)
					break;
				if (j == 4)
					ans++;
			}
		}
		for (int i = 0; i < 5; i++)
		{
			if (board[i][i] != 0)
				break;
			if (i == 4)
				ans++;
		}
		
		for (int i = 0; i < 5; i++)
		{
			if (board[i][4-i] != 0)
				break;
			if (i == 4)
				ans++;
		}

		return ans;
	}

}
