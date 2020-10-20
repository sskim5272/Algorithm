package ws.step05;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Test02_StackArray01
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		final int CAPACITY = 5;
		int[] data = new int[CAPACITY];
		int top = -1;

		while (true)
		{
			System.out.println("---------------");
			System.out.println("1. input");
			System.out.println("2. pop");
			System.out.println("3. print all");
			System.out.println("0. exit");
			System.out.println("---------------");
			System.out.println("menu : ");
			int menu = sc.nextInt();

			switch (menu)
			{
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.print("�Է� : ");
				if (top < CAPACITY - 1)
					data[++top] = sc.nextInt();
				else System.out.println("memory limited");
				break;
			case 2:
				if (top>=0) {
					System.out.println(data[top]);
					data[top--]=0;
				}
				else {
					System.out.println("memory empty!");
				}
				
				break;
			case 3:
				System.out.println(Arrays.toString(data));
				break;
			default:
				break;
			}

		}
	}
}
