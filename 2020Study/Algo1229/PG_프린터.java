package Algo1229;
import java.util.LinkedList;
import java.util.Queue;

public class PG_프린터
{
	public static void main(String[] args)
	{
		new PG_프린터().solution(new int[] {1,1,1}, 2);
	}

	public int solution(int[] priorities, int location)
	{
		
		int answer = 0;
		int maxNum = 0;
		int numCnt[] = new int[10];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int x : priorities)
		{
			q.offer(x);
			numCnt[x] += 1;
			maxNum = Math.max(maxNum, x);
		}

		while (true)
		{
			int num = q.poll();
			if (num < maxNum)
			{
				q.offer(num);
				if (location == 0)
				{
					location = q.size();
					
				}
			} else
			{				
				answer++;
				
				if(numCnt[maxNum]==1) {
					maxNum--;
					while( maxNum>0 &&  numCnt[maxNum]==0  ) {
						maxNum--;
					}
				}
				else {
					numCnt[maxNum]-=1;
				}
				
				if (location == 0)
				{
					System.out.println(answer);
					return answer;
				}
			}
			location--;

		}
	}

}
