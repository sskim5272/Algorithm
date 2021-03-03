package Algo0118;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PG_KAKAO_단어변환
{
	static int size, ans;

	public static void main(String[] args)
	{
		System.out.println(
				new PG_KAKAO_단어변환().solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
	}

	public int solution(String begin, String target, String[] words)
	{
		int answer = 0;
		size = words.length;
		ans = size;
		boolean flag = false;
		List<String> list = new ArrayList<String>();
		for (String word : words)
		{
			list.add(word);
			if (word.equals(target))
				flag = true;
		}

		if (flag == false)
			return answer;

		dfs(begin, target, list);

		return ans;
	}

	private void dfs(String begin, String target, List<String> lst)
	{
		if (begin.equals(target)) {
			
			ans=Math.min(ans, size - lst.size());
		return;

		}
		for (int i = 0; i < lst.size(); i++)
		{
			int cnt = 0;
			String word = lst.get(i);

			for (int j = 0; j < word.length(); j++)
			{
				if (word.charAt(j) != begin.charAt(j))
					cnt++;
			}
			if (cnt > 1)
				continue;

			lst.remove(word);
			dfs(word, target, lst);
			lst.add(word);
		}

		
	}

}
