package Algo0916;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1
{
	public int[] solution(String[] genres, int[] plays)
	{
		int[] answer = {};
		int onlyGenreCnt = 0;
		//N=genres.length
		Map<String, List<SongInfo>> productPlays = new HashMap<>();
		for (int i = 0; i < genres.length; i++)
		{
			List<SongInfo> tempList = new ArrayList<SongInfo>();
			if (productPlays.containsKey(genres[i]))
			{
				tempList = productPlays.get(genres[i]);
			}
			tempList.add(new SongInfo(i, plays[i]));
			productPlays.put(genres[i], tempList);
		}

		List<GenreInfo> genreRank = new ArrayList<GenreInfo>();
		for (String key : productPlays.keySet())
		{
			int sum = 0;
			productPlays.get(key).sort(null);
			if (productPlays.get(key).size() == 1)
				onlyGenreCnt++;
			for (SongInfo Song : productPlays.get(key))
			{
				sum += Song.palys;
			}
			genreRank.add(new GenreInfo(key, sum));
		}
		

		genreRank.sort(null);

		answer = new int[genreRank.size() * 2 - onlyGenreCnt];
		System.out.println(answer.length);
		int index = 0;
		for (GenreInfo genre : genreRank)
		{
			int cnt = 0;
			for (SongInfo song : productPlays.get(genre.name))
			{
				if (cnt == 2)
					break;
				answer[index++] = song.id;
				cnt++;
			}
		}

		return answer;
	}

	class SongInfo implements Comparable<SongInfo>
	{
		int id;
		int palys;

		public SongInfo(int id, int palys)
		{
			this.id = id;
			this.palys = palys;
		}

		@Override
		public int compareTo(SongInfo o)
		{
			return -this.palys + o.palys;
		}
	}

	class GenreInfo implements Comparable<GenreInfo>
	{
		String name;
		int count;

		public GenreInfo(String name, int count)
		{
			super();
			this.name = name;
			this.count = count;
		}

		@Override
		public int compareTo(GenreInfo o)
		{
			return -this.count + o.count;
		}
	}
}