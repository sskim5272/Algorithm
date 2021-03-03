package Algo0117;

import java.util.ArrayList;
import java.util.List;

public class PG_KAKAO_N으로표현
{
	static List<List<Integer>> lstlst = new ArrayList<List<Integer>>();

	public static void main(String[] args)
	{
		System.out.println(new PG_KAKAO_N으로표현().solution(7, 772376));
	}

	public int solution(int N, int number)
	{
		int answer = 1;

		List<Integer> temp = new ArrayList<Integer>();
		temp.add(N);
		lstlst.add(temp);

		if (N == number)
			return 1;

		while (answer < 8)
		{
			answer++;
			if (cal(N, number, answer) == true)
				return answer+1;
		}

		return -1;
	}

	public static boolean cal(int N, int number, int idx)
	{
		List<Integer> temp = new ArrayList<Integer>();
		int tempNum = 0;
		for (int i = 0; i < idx; i++)
		{
			tempNum += (int) Math.pow(10, i) * N;
		}
		System.out.println(tempNum);
		temp.add(tempNum);

		for (int i = 0; i < idx-1; i++)
		{
			for (int n1 : lstlst.get(i))
			{
				if( (idx-i)<0) continue;
				
				for (int n2 : lstlst.get(idx - i))
				{
					temp.add(n1 * n2);
					temp.add(n1 + n2);
					temp.add(n1 - n2);

					if (n1 > 0 && N > 0)
						temp.add(n1 / N);
				}
			}
		}

		for (int num : temp)
		{
			if (num == number)
			{
				System.out.println(num);
				return true;
			}
		}
		lstlst.add(temp);

		return false;

	}

}
