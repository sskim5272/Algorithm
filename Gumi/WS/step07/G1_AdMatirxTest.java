package ws.step07;

import java.util.Scanner;

public class G1_AdMatirxTest
{
	static int N;
	static boolean [][] adjMatrix;
	
	
	
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		N=in.nextInt();
		adjMatrix= new boolean[N][N];
		
		int cnt=in.nextInt();
		for(int i=0;i<cnt;i++) {
			int from=in.nextInt();
			int to=in.nextInt();
			adjMatrix[from][to]=true;
			adjMatrix[to][from]=true;
		}
	}
}
