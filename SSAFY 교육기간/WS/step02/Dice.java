package ws.step02;

import java.util.Arrays;
import java.util.Scanner;

public class Dice
{
	private static int N,numbers[],totalCnt;
	private static boolean isSelected[];
	
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		numbers=new int[N];
		isSelected=new boolean[7];
		
		int mode= sc.nextInt();
		
		totalCnt=0;
		
		switch (mode)
		{
		case 1: // 중복 수열		
			dicce1(0);
			break;
		case 3: // 중복 수열		
			dicce3(0,0);
			break;
		case 2: // 중복 수열		
			dicce2(0,0);
			break;
		case 4: // 중복 수열		
			dicce4(0,0);
			break;

		default:
			break;
		}
		System.out.println("total count : "+totalCnt);
	}
	
	private static void dicce1(int cnt) //cnt : 현재가까지 던지 주사위수
	{
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			numbers[cnt]=i;
			dicce1(cnt+1);
		}
	}
	
	private static void dicce2(int cnt,int start) //cnt : 현재가까지 던지 주사위수
	{
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=6;i++) {
			if(isSelected[i]==false) continue;
			numbers[cnt]=i;			
			dicce2(cnt+1,i);
			isSelected[i]=true;
		}
	}
	private static void dicce3(int cnt,int start) //cnt : 현재가까지 던지 주사위수
	{
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;			
			dicce3(cnt+1,i);
		}
	}
	
	private static void dicce4(int cnt,int start) //cnt : 현재가까지 던지 주사위수
	{
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;			
			dicce4(cnt+1,i+1);
		}
	}
}
