package ws.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom
{
	static int time[][];

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		time = new int[N][2];

		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(in.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new timecomparator());
		int ans=0;
		int end=0;
		
		for(int i=0;i<N;i++) {
			if (time[i][0]<end) continue;
			ans++;
			end=time[i][1];			
		}
		
		System.out.println(ans);
	}

	static class timecomparator implements Comparator<int[]>
	{

		@Override
		public int compare(int[] o1, int[] o2)
		{
			if (o1[1] != o2[1])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		}

	}

}
