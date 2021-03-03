package Algo1115;

import java.util.HashMap;
import java.util.Map;

public class PG_KAKAOA
{

	public int[] solution(String[] gems)
	{
		gems = new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
//		gems = new String[] { "ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//		gems = new String[] { "a", "a", "b" };
		int[] answer = { 0, gems.length };
		Map<String, int[]> map = new HashMap<String, int[]>();
		for (String gem : gems)
		{

			map.put(gem, new int[] { 1, 0 });

		}
		int gemCnt = map.size();

		for (int i = 0; i < gems.length; i++)
		{
			answer[1] = i + 1;
			// 이때까지 나온 보석 수 업데이트
			int[] temp123 = map.get(gems[i]);
			temp123[1]++;
			map.put(gems[i], temp123);
			

			if (map.get(gems[i])[0] == 1)
			{
				int[] temp = map.get(gems[i]);
				temp[0] = 0;
				gemCnt--;
				map.put(gems[i], temp);

			} else
			{
				String gem = gems[i]; // 비교할 문자
				int stNum = answer[0]; // 검사 시작 지점

				while (true)
				{
					boolean flag = true;
					System.out.println(gem + " i " + i + " st " + stNum + " cnt " + map.get(gem)[1] + " ans " + answer[0]);

					for (int j = stNum; j <= i; j++)
					{

						if (gem.equals(gems[j]))
						{
							if (map.get(gem)[1] == 1)
							{
								answer[0] = j;
								stNum=j+1;								
								System.out.println("break "+j);
								break; // 남은 보석 수가 1이면 아웃
							}

							// 같다면 보석 갯수 1줄인다
							int[] temp1234 = map.get(gem);
							temp1234[1]--;
							map.put(gem, temp1234);
							flag = false;
							answer[0] = j;

						} else
						{				
							stNum=j+1;								
							gem = gems[j];
							break;
						}
					}
					if (flag)
						break;
				}

			}
			System.out.println("=======");
			if (gemCnt == 0)
				break;
		}

		answer[0]++;
		System.out.println(answer[0] + " " + answer[1]);
		return answer;
	}

	public static void main(String[] args)
	{
		new PG_KAKAOA().solution(null);
	}

}
