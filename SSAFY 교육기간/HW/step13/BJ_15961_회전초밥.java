package hw.step13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader bf;

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int answer = 0;
		int dish[] = new int[N];

		bf = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < N; i++)
		{
			dish[i] = sc.nextInt();
		}

		int l = 0;
		int r = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (l < N)
		{

			if (map.containsKey(dish[(r + N) % N]))
			{
				int val = map.get(dish[(r + N) % N]);
				map.put(dish[(r + N) % N], val + 1);
			} else
			{ // Map에 없는 Key면 1만 증가
				map.put(dish[(r + N) % N], 1);
			}

			if (map.containsKey(c))
			{
				answer = Math.max(answer, map.keySet().size());
			} else
			{
				answer = Math.max(answer, map.keySet().size() + 1);
			}

			if (r - l + 1 >= k)
			{

				int val = map.get(dish[(l + N) % N]);
				if (val == 1)
					map.remove(dish[(l + N) % N]);
				else
				{
					map.put(dish[(l + N) % N], val - 1);
				}
				l++;
				r++;
			} else
			{
				r++;
			}

		}

		System.out.println(answer);
	}

}