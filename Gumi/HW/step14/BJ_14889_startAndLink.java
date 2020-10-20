package hw.step14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_startAndLink
{
	static int N,grid[][];
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken().trim());
		grid=new int[N][N];

		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
			}	
		}
		
		combination(new boolean[N],N,0,N/2 );
		System.out.println(answer);
		
	}
	
	private static void combination(boolean visited[],int depth, int curcnt, int r)
	{
		if(r == 0) {
//			for(boolean x:visited) System.out.print(x+" ");
//			System.out.println();
			Solution(visited);
	        return;
	    } 

	    for(int i=curcnt; i<depth; i++) {
	        visited[i] = true;
	        combination(visited, depth,i+1,r-1 );
	        visited[i] = false;
	    }
		
	}

	private static void Solution(boolean[] visited)
	{
		int ans1=0;
		int ans2=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i]&&visited[j]) {
					ans1+=grid[i][j];
				}
				
				if(visited[i]==false&&visited[j]==false) {
					ans2+=grid[i][j];
				}
			}	
		}
		
		answer=Math.min(answer, Math.abs(ans2-ans1));
	}
}
