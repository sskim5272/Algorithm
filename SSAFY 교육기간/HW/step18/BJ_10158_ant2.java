package hw.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_ant2
{
	// 우상, 좌상, 좌하, 우하

	static int X;
	static int Y;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int curx = Integer.parseInt(st.nextToken());
		int cury = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		curx=curx+T;
		cury=cury+T;
		curx%=(2*X); 
		cury%=(2*Y);
		if(curx>X) curx=2*X-curx;
		if(cury>Y) cury=2*Y-cury;
		
		System.out.println(curx + " " + cury);
	}
}
