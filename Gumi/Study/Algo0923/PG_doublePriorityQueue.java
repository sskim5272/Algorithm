package Algo0923;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


	class Solution
	{
		public int[] solution(String[] operations)
		{
			int[] answer = {};
			HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
			PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
			StringTokenizer st;

			int incnt=0;
			int outcnt=0;
			for (int i = 0; i < operations.length; i++)
			{
				st = new StringTokenizer(operations[i]);
				String oper = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				int out;
				if (oper.equals("I"))
				{
					List<Integer> list=new ArrayList<Integer>();
					if(map.containsKey(num)) {
						list=map.get(num);
					}
					list.add(num);
					map.put(num, list);
					
					pq1.add(num);
					pq2.add(num);
					incnt++;
				} else
				{
					outcnt++;
					if (num == -1)
					{						
						 out=pq2.poll();
					} else
					{
						out=pq1.poll();						
					}
				}

			}
			
			if (incnt-outcnt>0) {
				answer =new int[]{pq1.peek(),pq2.peek()};
			}{
				answer =new int[]{0,0};
			}

			return answer;
		}
	}

