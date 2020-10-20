package ws.step02;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution_Ladder1
{

	public static void main(String args[])
	{
		// Unhandled exception type FileNotFoundException
//		System.setIn(new FileInputStream("src/input (2).txt"));

		Scanner sc = new Scanner(System.in);

		int T = 10;
		int Answer = 0;
		int ladder[][] = new int[100][100];
		int x = 0;
		int y = 0;
		int connerPos[] = new int[2];
		boolean goingLeft= false;
		boolean goingRight= false;
		boolean goingUp=true;
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			x = sc.nextInt();
			for (int row = 0; row < 100; row++)
			{
				for (int col = 0; col < 100; col++)
				{
					ladder[col][row] = sc.nextInt();
				}
			}

			// find end position
			for (int i = 0; i < 100; i++)
			{
				if (ladder[i][99] == 2)
				{
					x = i;
					y = 99;
				}
			}
			
//			System.out.println("\n"+x + " " + y);
			
			while (true)
			{
				if (y==0) break;
				
				if (x > 0 && ladder[x - 1][y] == 1 && goingLeft)
				{
					x--;
					goingRight=false;
//					System.out.println("left");
				}
				//
				else if (x < 99 && ladder[x + 1][y] == 1&& goingRight)
				{
					goingLeft=false;
					x++;
//					System.out.println("right");
				} 
				else {
					goingLeft=true;
					goingRight=true;
					y--;
//					System.out.println("up");
				}

			}

			System.out.println("#" + test_case + " " + x);

		}

	}

}
