package ws.step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z
{
	static int N, r, c;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int ans = 0;

		System.out.println(solution(r, c, N)-1);
		
	}

	private static int solution(int r, int c, int n)
	{
//		System.out.println(r+" "+c+" "+n);
		int ans = 0;
		if (n <= 1||(r<2&&c<2))
		{
			if (r == 0 && c == 0)
			{
				return 1;
			}
			if (r == 0 && c == 1)
			{
				return 2;
			}
			if (r == 1 && c == 0)
			{
				return 3;
			}
			if (r == 1 && c == 1)
			{
				return 4;
			}
		}

		for (int i = 1; i <= N; i++)
		{
			int bound = (int) Math.pow(2, i) - 1;
			int innerbound = (int) Math.pow(2, i-1) - 1;
			
			if (r <= bound && c <= bound)
			{
				// 우상
				if (r <= innerbound && c > innerbound)
				{
//					System.out.println(11);
					ans += (int) Math.pow((innerbound + 1), 2);
					ans += solution(r, c - innerbound-1, i-1);
				}
				// 좌하
				else if (r > innerbound && c <= innerbound)
				{
//					System.out.println(22);
					ans += (int) Math.pow((innerbound + 1), 2) * 2;
					ans += solution(r - innerbound-1, c, i-1);
				}
				// 우하
				else
				{
//					System.out.println(33);
					ans += (int) Math.pow((innerbound + 1), 2) * 3;
					ans += solution(r - innerbound-1, c - innerbound-1, i-1);
				}
				break;
			}
		}

		return ans;
	}
}
