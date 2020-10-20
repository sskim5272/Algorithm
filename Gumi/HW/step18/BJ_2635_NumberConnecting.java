package hw.step18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_2635_NumberConnecting
{
	public static void main(String[] args)
	{
		
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int half=(int)(N/2);
		int cnt=0;
		int max=0;
		int before=100;
		int cur;
		int temp;
		List<Integer> anslist=new ArrayList<Integer>();
		List<Integer> templist=new ArrayList<Integer>();
		for(int i=half;i<=N;i++) {
			cnt=0;
			cur=i;
			templist.clear();
			before=N;
			while(cur>=0) {
				templist.add(before);
				cnt++;
				temp=before-cur;
				before=cur;
				cur=temp;
			}
			templist.add(before);
			
			if(templist.size()>anslist.size()) {
				anslist.clear();
				for(int x:templist) {
					anslist.add(x);
				}
			}
		}
		System.out.println(anslist.size());
		for(int x:anslist) {
			System.out.print(x+" ");
		}
	}
}
