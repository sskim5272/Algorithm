package ws.step06;

import java.util.Scanner;

public class CalculatiorValidation
{
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		new CalculatiorValidation().testCase();
	}

	private void testCase()
	{
		int T = 10;
		for (int t = 1; t <= 10; t++)
		{
			System.out.println("#" + t + " " + solution());
		}
	}

	private int solution()
	{
		int N=sc.nextInt();
		char []graph=new char[N+1];
		
		while(N-->0) {
			String [] strs;
			strs=sc.nextLine().split(" ");
//			graph[strs[0].charAt(0)-'0']=
		}
		
		
		
		
		
		return 0;
	}

}
