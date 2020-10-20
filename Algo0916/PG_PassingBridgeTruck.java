package Algo0916;

import java.util.LinkedList;
import java.util.Queue;


class Solution
{

	public int solution(int bridge_length, int weight, int[] truck_weights)
	{
		int answer = 0;
		int min_idx = 0;
		int max_idx = truck_weights.length ;
		int weightOnBridge = 0;

		Queue<Integer> q = new LinkedList<Integer>();

		while (true)
		{
			answer++;
			if (weightOnBridge + truck_weights[min_idx] <= weight)
			{
				q.add(truck_weights[min_idx]);
				weightOnBridge += truck_weights[min_idx];
				min_idx++;
			} else
			{
				q.add(0);
			}

			if (q.size() >= bridge_length)
			{
				weightOnBridge -= q.peek();
				q.poll();
			}
			
			
			if (min_idx == max_idx)
				break;
		}

		return answer + bridge_length;
	}
}