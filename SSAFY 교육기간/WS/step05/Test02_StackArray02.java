package ws.step05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Test02_StackArray02
{
	Scanner sc = new Scanner(System.in);
	myArrayStack stack = new myArrayStack();
	//Stack<Integer> s = new Stack<Integer>();

	private int menu()
	{
		while (true)
		{
			System.out.println("---------------");
			System.out.println("1. input");
			System.out.println("2. pop");
			System.out.println("3. print all");
			System.out.println("0. exit");
			System.out.println("---------------");
			System.out.println("menu : ");
			return sc.nextInt();
		}
	}

	private void insert()
	{
		if (!stack.full())
		{
			System.out.print("�Է� : ");
			stack.push(sc.nextInt());
		} else
			System.out.println("memory limited");
	}

	private void getData()
	{
		if (!stack.isEmpty())
		{
			System.out.println("get num : " + stack.pop());
		} else
		{
			System.out.println("Stack empty!");
		}
	}

	private void selecte()
	{
		System.out.println(stack);
	}

	private void exit()
	{
		System.exit(0);
	}

	public void service()
	{
		while (true)
		{
			switch (menu())
			{
			case 0:
				exit();
				break;
			case 1:
				insert();
				break;
			case 2:
				getData();
				break;
			case 3:
				selecte();
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		new Test02_StackArray02().service();
	}
}
