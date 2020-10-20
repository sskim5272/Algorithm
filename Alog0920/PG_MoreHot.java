package Alog0920;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        
        while(pq.peek()<K) {
        	if(pq.size()<2) return -1;
        	answer ++;
        	int top1=pq.poll();
        	int top2=pq.poll();
        	pq.add(top1+top2*2);
        }
        return answer;
    }
}


//int solution(vector<int> scoville, int K) {
//
//    int answer = 0;
//    priority_queue<int,vector<int>,greater<int>> pq;
//    
//    for(int i=0;i<scoville.size();i++){
//        pq.push(scoville[i]);
//    }
//    
//    while(pq.top()<K){
//        if (pq.size()<2) return -1;
//        answer++;
//        int top1=pq.top();
//        pq.pop();
//        int top2=pq.top();
//        pq.pop();
//        pq.push(top1+top2*2);
//    }
//    return answer;
//}
