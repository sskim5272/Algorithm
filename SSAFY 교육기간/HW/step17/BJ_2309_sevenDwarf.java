package hw.step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2309_sevenDwarf
{
	static boolean done=false;
	static int dwarfs[] = new int[9];
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dwarfs[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < 9; i++)
		{
			st = new StringTokenizer(br.readLine());
			dwarfs[i] = Integer.parseInt(st.nextToken());
		}
		boolean selected[] = new boolean[9];

		combination(10, 0, 0, selected);
		

	}

	private static void combination(int n, int c, int start, boolean selecte[])
	{
		if(done) {
			return;
		}
		
		if (c == 7)
		{
			
			int sum = 0;
			for (int i = 0; i < 9; i++)
			{
				if (selecte[i])
				{
					sum += dwarfs[i];
					list.add(dwarfs[i]);
				}
			}
			if (sum != 100)
			{
				list.clear();
			}
			else {
				done=true;
				Collections.sort(list);
				for (int i : list)
				{
					System.out.println(i);
				}
			}
			return;
		}

		for (int i = start; i < 9; i++)
		{
			selecte[i] = true;
			combination(n, c + 1, i + 1, selecte);
			selecte[i] = false;
		}

	}

}
