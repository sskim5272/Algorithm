package Algo1209;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PG_KAKAO_오픈채팅방
{
	class Log
	{
		String id;
		int type;

		public Log(String id, int type)
		{
			super();
			this.id = id;
			this.type = type;
		}

	}

	public String[] solution(String[] record)
	{
		String[] answer = {};
		HashMap<String, String> map = new HashMap<String, String>();
		List<Log> logList = new ArrayList<Log>();
		for (String str : record)
		{
			String word[] = str.split(" ");

			if (word[0].equals("Enter"))
			{
				logList.add(new Log(word[1], 1));
			} else if (word[0].equals("Leave"))
			{
				logList.add(new Log(word[1], 0));
				continue;
			}
			map.put(word[1], word[2]);
			
		}

		answer = new String[logList.size()] ;
		int i = 0;
		for (Log log : logList)
		{
			if (log.type == 1)
			{
				answer[i] = map.get(log.id) + "님이 들어왔습니다.";
			} else
			{
				answer[i] = map.get(log.id) + "님이 나갔습니다.";
			}
			System.out.println(answer[i]);
			i++;
		}
		
		return answer;
	}

	public static void main(String[] args)
	{
		new PG_KAKAO_오픈채팅방().solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
}
