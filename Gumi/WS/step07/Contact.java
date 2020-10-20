package ws.step07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact
{
	Scanner sc = new Scanner(System.in);
	static int map[][];
	static boolean visited[];
	static int maxcnt=0;

	public static void main(String[] args)
	{
		new Contact().testCase();
	}

	private void testCase()
	{
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			int ans = solutioin();
			System.out.println("#" + t + " " + ans);
		}

	}

	private int solutioin()
	{
		int N=sc.nextInt();
		int start=sc.nextInt();
		map=new int[101][101];
		visited=new boolean[101];

		while(N-->0) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			map[from][to]=1;
		}	
		bfs(start,0);
		
		return 0;
	}
	
	private int bfs(int from, int cnt )
	{
		Queue<Integer> q=new LinkedList<Integer>();
		cnt++;
		for(int i=1;i<=100;i++) {
			if(map[from][i]==1) {
				q.offer(i);
				visited[i]=true;
			}
		}
		
		while(!q.isEmpty()) {
			int from1= q.poll();
//			bfs()
		}
		
		return 0; 
	}
}
