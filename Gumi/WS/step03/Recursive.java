package ws.step03;

import java.util.Scanner;

public class Recursive
{
	// sum
	private static int recursive(int val)
	{
		if (val == 0)
			return 0;
		return val += recursive(--val);
	}

	// pow
	private static int recursive2(int val, int cnt)
	{
		if (cnt == 0)
			return 1;
		return val *= recursive2(val, --cnt);
	}

	// pibonacci
	private static int recursive3(int val)
	{
		if (val == 0 || val == 1)
			return val;
		return recursive3(val - 1) + recursive3(val - 2);
	}

	// digit sum
	private static int recursive4(int val)
	{
		if (val / 10 == 0)
			return val;
		return val % 10 + recursive4(val / 10);
	}

	// array sum 
	private static int recursive5(int idx,int val[])
	{
		if(idx==0) return 0;
		
		return val[idx-1]+recursive5(--idx, val);
	}
	
	// search
	private static int recursive6(int idx,int val[],int find)
	{
		if(val.length==idx) return -1;
		if(val[idx]==find) return 1;
		return recursive6(++idx, val, find);
	}
	
	// combination
	private static void combiantion(int idx,int nums[],int isvisited[])
	{

	}
	
	//
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int [] nums={2,3,5,7, 12,6};
//		System.out.println(recursive(sc.nextInt()));
//		System.out.println(recursive2(sc.nextInt(), sc.nextInt()));
//		System.out.println(recursive3(sc.nextInt()));
//		System.out.println(recursive4(sc.nextInt()));
//		System.out.println(recursive5(4,nums ));
		System.out.println(recursive6(0, nums, 99));
		
		
	}
}
