package ws.step21;

import java.io.*;
import java.util.*;

public class JO_2283_RGBTown
{
	static int N, colors[][], bestCombi[][], ans[];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		colors = new int[N][3];
		bestCombi = new int[N][3];
		ans = new int[N];

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}
		bestCombi[0][0] = colors[0][0];
		bestCombi[0][1] = colors[0][1];
		bestCombi[0][2] = colors[0][2];

		ans[0] = Math.min(bestCombi[0][0], Math.min(bestCombi[0][1], bestCombi[0][2]));
		for (int i = 1; i < N; i++)
		{
			for (int clr = 0; clr < 3; clr++)
			{
				int sum1=Integer.MAX_VALUE;
				int sum2=Integer.MAX_VALUE;
				
				if (clr == 0)
				{
					sum1=bestCombi[i-1][1]+colors[i][clr];
					sum2=bestCombi[i-1][2]+colors[i][clr];
				}
				if (clr == 1)
				{
					sum1=bestCombi[i-1][0]+colors[i][clr];
					sum2=bestCombi[i-1][2]+colors[i][clr];
				}
				if (clr == 2)
				{
					sum1=bestCombi[i-1][0]+colors[i][clr];
					sum2=bestCombi[i-1][1]+colors[i][clr];
				}
				
				bestCombi[i][clr]=Math.min(sum1, sum2);
			
			}
			ans[i] = Math.min(bestCombi[i][0], Math.min(bestCombi[i][1], bestCombi[i][2]));
		}
		System.out.println(ans[N-1]);
	}
}
