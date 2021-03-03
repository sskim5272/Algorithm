package Algo1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18119_단어읽기
{
	static int N, M, answers[];
	static String words[];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new String[N];
		answers = new int[M];

		int mask = 0;
		for (int i = 0; i <= 'z' - 'a'; i++)
		{
			mask += Math.pow(2, i);
		}

		for (int i = 0; i < N; i++)
		{
			words[i] = br.readLine();			
		}

		for (int i = 0; i < M; i++)
		{
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int ch = 'z' - st.nextToken().charAt(0);
			
			if (x == 1)
			{
				mask &= ~(1<<ch) | ((false? 1:0)<<ch);;
			} else
			{
				mask &= ~(1<<ch) | ((true? 1:0)<<ch);;
			}
			
			boolean flag=true;
			
			for (String xx : words)
			{
				flag=true;
				for (int j = 0; j < xx.length(); j++)
				{
					int chch='z'-xx.charAt(j);
					if( (chch & mask)==0) {
						flag=false;
						break;
					}
				}
				if(flag) answers[i]++;
			}

		}
		
		for (int x : answers)
		{
			System.out.println(x);
		}

	}
}
