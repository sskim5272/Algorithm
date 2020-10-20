package ws.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1251_Hanaro
{
	static int xPos[], yPos[],parents[] ,min, N;
	static double answer, E;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			xPos = new int[N];
			yPos = new int[N];
			parents = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				xPos[j]=Integer.parseInt(st.nextToken().trim());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				xPos[j]=Integer.parseInt(st.nextToken().trim());
				parents[j]=j;
			}
			E=Integer.parseInt(br.readLine().trim());
			
			solution();
			
			System.out.println();
		}
	}

	private static void solution()
	{
		
	}
}
