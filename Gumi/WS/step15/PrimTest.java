package ws.step15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int input[][] = new int[N][N];
		int minEdge[] = new int[N];
		boolean visited[] = new boolean[N];

		for (int i = 0; i < N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		} // i부터 j노드 까지 비용을 모두 배열에 저장

		int minVertex, min, result = 0;
		// 0번 정점을 시작 정점으로 시작 한다고 가정
		minEdge[0] = 0;

		for (int c = 0; c < N; c++)
		{
			// 신장트리에 포함되지 않은 정점 중 최소간선 비용의 정점 찾기

			min = Integer.MAX_VALUE;
			minVertex = 0;

			for (int i = 0; i < N; i++)
			{
				if(!visited[i]&& min >minEdge[i]) {
					min=minEdge[i];
					minVertex=i;
				}
			}
			
			result+=min; // 신장 트리 비용 누적
			visited[minVertex]=true; //신장 트리에 포함 시킹
			
			for(int i=0;i<N;i++) {
				if(!visited[i]&& input[minVertex][i]!=0 &&minEdge[i]>input[minVertex][i]){
					minEdge[i]=input[minVertex][i];
				}
			}

		}

	}
}
