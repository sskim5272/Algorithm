package ws.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5585_MoneyChange
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());

		int coins[] = { 500, 100, 50,10,5, 1 };
		int cnt = 0;
		for (int i = 0; i < coins.length; i++)
		{

			if (N < coins[i])
				continue;
			cnt += N / coins[i];
			N = N % coins[i];

		}
		System.out.println(cnt);
	}
}
