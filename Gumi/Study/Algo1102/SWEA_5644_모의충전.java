package Algo1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_모의충전
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, A, map[][][], path[][], pos[][];
	static int dx[] = { 0, 0, +1, 0, -1 };
	static int dy[] = { 0, -1, 0, 1, 0 };

	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#"+test_case+" "+solution());
		}
	}

	private static int solution() throws IOException
	{
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int ans = 0;
		int ans1 = 0;
		map = new int[10][10][2];
		path = new int[M][2];
		pos = new int[2][2];
		pos[0] = new int[] { 0, 0 };
		pos[1] = new int[] { 9, 9 };

		for (int i = 0; i < 2; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
			{
				path[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < A; j++)
		{
			setMap();
		}
		
		ans=map[0][0][0];
		ans1=map[9][9][0];
		for (int dir[] : path)
		{
			pos[0][0]+=dx[dir[0]]; //x1
			pos[0][1]+=dy[dir[0]]; //y1
			pos[1][0]+=dx[dir[1]]; //x2
			pos[1][1]+=dy[dir[1]]; //y2
			int p1=map[pos[0][1]][pos[0][0]][0];
			int p2=map[pos[1][1]][pos[1][0]][0];
			
			if(pos[0][0]==pos[0][1]&&pos[0][0]==pos[0][1]) {
				ans+=map[pos[0][1]][pos[0][0]][0];
				ans1+=map[pos[0][1]][pos[0][0]][1];
			}
			else{
				ans+=map[pos[0][1]][pos[0][0]][0];
				ans1+=map[pos[1][1]][pos[1][0]][0];
			}   
			System.out.println(map[pos[0][1]][pos[0][0]][0]+" "+map[pos[1][1]][pos[1][0]][0]);
		}
		
		return ans+ans1;
	}

	private static void setMap() throws IOException
	{
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		System.out.println(x+" "+y);
		add(x-1, y-1, P);
		q.offer(new int[] { x-1, y-1, cnt });
		while (!q.isEmpty())
		{
			int info[] = q.poll();
			x = info[0];
			y = info[1];
			cnt = info[2];
			if (cnt >= C)
				return;
			for (int dir = 1; dir < 5; dir++)
			{
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10)
				{
					add(nx, ny, P);
					q.offer(new int[] { nx, ny, cnt+1 });
				}
			}
		}
	}

	private static void add(int x, int y, int p)
	{
		if (map[y][x][1] < p)
		{
			if (map[y][x][0] < p)
			{
				map[y][x][1] = map[y][x][0];
				map[y][x][0] = p;
			} else
			{
				map[y][x][1] = p;
			}
		}
	}

}
