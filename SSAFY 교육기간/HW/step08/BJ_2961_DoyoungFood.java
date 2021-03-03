package hw.step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2961_DoyoungFood
{
	static int ans, N;
	static int foods[][];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		foods = new int[N][2];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(in.readLine());
			foods[i][0] = Integer.parseInt(st.nextToken());
			foods[i][1] = Integer.parseInt(st.nextToken());
		}
		ans = Math.abs(foods[0][1] - foods[0][0]);
		for (int pick = 1; pick <= N; pick++)
		{
			combination(pick, 0, 1, 0);
		}
		System.out.println(ans);

	}

	private static void combination(int pick, int s, int mul, int add)
	{
		if (pick == 0)
		{
			if(ans>Math.abs(mul-add)) {
				ans=Math.abs(mul-add);
			}
			return;
		}

		for (int i = s; i < N; i++)
		{
			int temp=pick-1;
			combination(temp,i,mul*foods[i][0],add+foods[i][1]);
		}
	}
}
