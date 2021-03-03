package ws.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_HamburgerDiet
{
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, L;
	static int ans=0;
	static int foods[][];
 
	public static void main(String[] args) throws IOException 
	{
		st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++)
		{
			System.out.println("#" + t + " " + solution());
			ans=0;
		}
	}

	private static int solution() throws IOException
	{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		foods = new int[N][2];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(in.readLine());
			foods[i][0]=Integer.parseInt(st.nextToken());
			foods[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++)
		{
			Combination(i, 0, 0, 0);
		}

		return ans;
	}

	private static void Combination(int pick, int s, int tastesum, int Calsum)
	{
			
		if(Calsum>L) return;
		
		if (pick == 0)
		{
			ans=Math.max(ans,tastesum);
			return;
		}

		for (int i = s; i < N; i++)
		{

			Combination(pick - 1, i + 1, tastesum + foods[i][0], Calsum + foods[i][1]);
			
		}
		
	}
}
