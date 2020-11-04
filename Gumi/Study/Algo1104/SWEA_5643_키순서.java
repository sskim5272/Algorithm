package Algo1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5643_키순서
{
	static int N, M;
	static boolean map[][];
	static BufferedReader br ;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int T;
		T=Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#"+test_case+" "+solution());	
		}
	}



	private static int solution() throws IOException
	{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[from][to] = true;
		}

		for (int k = 1; k < N + 1; k++)
		{
			for (int i = 1; i < N + 1; i++)
			{
				for (int j = 1; j < N + 1; j++)
				{
					if (map[i][k] && map[k][j])
						map[i][j] = true;
				}
			}
		}

		for (int k = 1; k < N + 1; k++)
		{
			for (int i = 1; i < N + 1; i++)
			{
				if(map[k][i]) map[i][k]=true;
			}
		}
		
		int ans=0;
		
		loop :for (int k = 1; k < N + 1; k++)
		{
			map[k][k]=true;
			for (int i = 1; i < N + 1; i++)
			{
				if(map[k][i]==false) continue loop;
			}
			ans++;
		}
		
		return ans;
	}
}
