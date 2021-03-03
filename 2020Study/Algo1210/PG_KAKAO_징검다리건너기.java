package Algo1210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PG_KAKAO_징검다리건너기
{
	public int solution(int[] stones, int k)
	{
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> nums = new ArrayList<Integer>();

		int answer = 0;
		int idx = 0;
		Integer[] templist=new Integer[stones.length];

		for (int x : stones)
		{
			templist[idx]=x;
			List<Integer> temp = new ArrayList<Integer>();
			if (map.containsKey(x))
			{
				temp = map.get(x);
				temp.add(stones[idx++]);
			} else
			{
				temp.add(idx++);
			}
			map.put(x, temp);
		}

		List<Integer> listStones = Arrays.asList(templist);

		listStones.sort(null);

		nums.add(listStones.get(0));
		for (int n : listStones)
		{
			if (nums.get(nums.size() - 1) < n)
				nums.add(n);
		}

		for (int n : nums)
		{
			for (int index : map.get(n))
			{
				boolean flagLeft = false;
				boolean flagRight = false;
				System.out.println("index : " + index + " n : " + n);
				if (index < k || index > stones.length - k)
					continue;
				for (int i = index - k; i < index; i++)
				{
					System.out.println(i+"~"+stones[i]);
					if (stones[i] >= n)
					{
						System.out.println(i + " " + stones[i]);
						flagLeft = true;
						break;
					}
				}

				for (int i = index + 1; i <= index + k; i++)
				{
					System.out.println(i+"~"+stones[i]);
					if (stones[i] >= n)
					{
						System.out.println(i + " " + stones[i]);
						flagRight = true;
						break;
					}
				}

				if (flagLeft ==false  || flagRight ==false)
				{
					System.out.println(answer);
					return answer;
				}
			}
			answer++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args)
	{
		new PG_KAKAO_징검다리건너기().solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3);
	}
}
