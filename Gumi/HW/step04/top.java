package hw.step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class top
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언

		Stack<int[]> s = new Stack<int[]>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int h = Integer.parseInt(st.nextToken());

		int max[] = new int[] { 0, h };// pos,height
		s.push(max);
		sb.append("0 ");

		for (int i = 1; i < n; i++)
		{
			h = Integer.parseInt(st.nextToken());

			// max height
			if (max[1] < h)
			{
				max[0] = i;
				max[1] = h;
				s.clear();
				s.push(max);
				sb.append("0 ");
				continue;
			}	
			
			while (true)
			{
				if (h < s.peek()[1])
				{
					sb.append((s.peek()[0] + 1) + " ");
					s.push(new int[] { i, h });
					break;
				} else
				{
					s.pop();
				}
			}		
		
		}
		
		System.out.println(sb.toString());
	}
}
