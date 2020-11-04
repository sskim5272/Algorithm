package Algo1030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Door
{
	char door[];
	int x;
	int y;
	int cnt;

	public Door(char door[], int x, int y, int cnt)
	{
		super();
		this.door = door[];
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class BJ_1194_달이차오른다가자
{
	static char map[][];
	static int N, M;
	static List<int[]> startList = new ArrayList<int[]>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Set<Character> keySet = new HashSet<Character>();
	static Set<Character> doorSet = new HashSet<Character>();

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for (int j = 0; j < M; j++)
			{
				map[i][j] = str.charAt(j);
				if (map[i][j] == '1')
				{
					startList.add(new int[] { j, i });
				} else if (map[i][j] >= 'a' && map[i][j] <= 'z')
				{
					keySet.add(map[i][j]);
				}
			}
		}
		// 맵핑 키 - door
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if (map[i][j] >= 'A' && map[i][j] <= 'Z')
				{
					if(!keySet.contains(map[i][j])) {
						map[i][j]='#';
					}
				} 
			}
		}

		for (int i = 0; i < startList.size(); i++)
		{
			int pos[] = startList.get(i);
			bfsOneToZero(pos[0], pos[1]);
		}

	}

	private static void bfsOneToZero(int x, int y)
	{
		Queue<Door> q = new LinkedList<Door>();

		q.offer(new Door('1', x, y, 0));

		while (!q.isEmpty())
		{

		}

	}

}
