package hw.step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_numberOrder
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int curNum;

		int beforeNum = 0;
		int ctCur = 0;
		int ctbefor = 0;

		int beforeNumMinus = 10;
		int ctCurMinus = 0;
		int ctbeforMinus = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++)
		{
			curNum = Integer.parseInt(st.nextToken());
			if (curNum >= beforeNum)
			{
				ctCur++;
				beforeNum = curNum;
			} else
			{
				beforeNum = 0;
				if (ctbefor < ctCur)
					ctbefor = ctCur;

				ctCur = 0;
			}				
			
			if (curNum <= beforeNumMinus)
			{
				ctCurMinus++;
				beforeNumMinus = curNum;
			} else
			{
				beforeNumMinus = 10;
				if (ctbeforMinus < ctCurMinus)
					ctbeforMinus = ctCurMinus;
				
				ctCurMinus = 0;
			}

		}
		
		if (ctbefor < ctCur)
			ctbefor = ctCur;
		if (ctbeforMinus < ctCurMinus)
			ctbeforMinus = ctCurMinus;
		
		System.out.println(Math.max(ctbeforMinus+1, ctbefor));
	}
}
