package ws.step04;

import java.util.LinkedList;
import java.util.Queue;

public class MyChew
{
	public static void main(String[] args)
	{
		Queue<int[]> queue=new LinkedList<int[]>();
		int N=20;
		int person=1;
		
		queue.offer(new int[] {person,1});
		
		while(N>0) {
			if(!queue.isEmpty()) {
				int[]p=queue.poll();
				int availableCnt=(N>+p[1])?p[1]:N;
				N-=availableCnt;
				if(N==0) {
					System.out.println("마지막 마이쮸 : "+p[0]);
				}
				else {
					System.err.println(p[0]+"번이 "+availableCnt+" 개수만큼 가져갑니다. 남은 개수 :"+N);
					p[1]++;
					queue.offer(p);
					queue.offer(new int[] {++person,1});
				}
				
			}
		}
	}
	
	
}
