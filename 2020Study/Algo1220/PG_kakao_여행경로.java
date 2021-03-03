package Algo1220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PG_kakao_여행경로
{
	static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	static String[] answer;
	
	public String[] solution(String[][] tickets)
	{

		answer = new String[tickets.length+1];

		for (String[] str : tickets)
		{
			String from = str[0];
			String to = str[1];

			List<String> tempList;
			if (map.containsKey(from))
			{
				tempList = map.get(from);
				tempList.add(to);
				tempList.sort(null);
			} else
			{
				tempList = new ArrayList<String>();
				tempList.add(to);
			}
			map.put(from, tempList);
		}

		answer[0]="ICN";
		dfs(1, "ICN", tickets.length+1);

		for(String str: answer) {
			System.out.println(str);
		}
		return answer;
	}

	private boolean dfs(int cnt, String from, int totalCnt)
	{
		if (cnt == totalCnt)
		{
			return true;
		}

		List<String> templist = map.get(from);

		if (templist == null )
			return false;

		for (int idx = 0; idx < templist.size(); idx++)
		{
			String to = templist.get(idx);
			templist.remove(idx);
			map.put(from, templist);
			answer[cnt]=to;

			if (dfs(cnt + 1, to, totalCnt))
				return true;
			
			templist.add(to);
			templist.sort(null);
			map.put(from, templist);

		}

		return false;

	}

	public static void main(String[] args)
	{
		new PG_kakao_여행경로().solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
				{ "ATL", "ICN" }, { "ATL", "SFO" } });
	}
}
