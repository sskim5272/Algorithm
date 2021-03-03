package Alog1007;

import java.util.Arrays;
import java.util.Comparator;

public class PG_단속카메라
{
	class Solution {
	    public int solution(int[][] routes) {
	 
	    	Arrays.sort(routes, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] s1, int[] s2) {
	                return s1[1] - s2[1];
	            }
	        });
	    	
	    	int max=routes[0][1];
	    	int answer = 0;
	    	
	    	for(int i=0;i<routes.length;i++) {
	    		
	    		if(max>=routes[i][0]) {
	    			max=Math.min(max, routes[i][1]);
	    		}
	    		else {
	    			answer++;
	    			max=routes[i][1];
	    		}
	    	}
		
	        
	        return answer;
	    }
	}
}
