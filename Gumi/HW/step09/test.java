package hw.step09;


import java.util.*;

public class test
{
	static Scanner sc = new Scanner(System.in);
	   static int N,K;
	   static int[] visited = new int[100010];
	   
	   public static void main(String[] args) {
	      N = sc.nextInt();
	      K = sc.nextInt();
	      
	      if(N==K)
	         System.out.println(0);
	      else
	         bfs(N);
	      
	      sc.close();
	   }
	   
	   static void bfs(int n) {
	      Queue<Integer> q = new LinkedList<Integer>();
	      q.offer(n);
	      visited[n] = 1;
	      
	      while(!q.isEmpty()) {
	         int temp = q.poll();
	         
	         for(int i=0; i<3; i++) {
	            int next;
	            
	            if(i==0) { next = temp - 1; }
	            else if(i==1) { next = temp + 1; }
	            else { next = temp * 2; }
	            
	            if(next == K) {
	               System.out.println(visited[temp]);
	               return;
	            }
	            
	            if(next >= 0 && next < visited.length && visited[next] == 0) {
	               q.offer(next);
	               visited[next] = visited[temp] + 1;
	            }
	         }
	      }
	   }

}
