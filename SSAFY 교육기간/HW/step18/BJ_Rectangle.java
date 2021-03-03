package hw.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Rectangle
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x1min, x1max, y1min, y1max;
		int x2min, x2max, y2min, y2max;

		for (int i = 0; i < 4; i++)
		{
			st = new StringTokenizer(br.readLine());
			x1min = Integer.parseInt(st.nextToken());
			x1max = Integer.parseInt(st.nextToken());
			y1min = Integer.parseInt(st.nextToken());
			y1max = Integer.parseInt(st.nextToken());
			
			x2min = Integer.parseInt(st.nextToken());
			x2max = Integer.parseInt(st.nextToken());
			y2min = Integer.parseInt(st.nextToken());
			y2max = Integer.parseInt(st.nextToken());
		}
	}
}
