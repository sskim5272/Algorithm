package ws.step20;

public class DP_test
{
	static int result[];
	public static void main(String[] args)
	{
		int N=3;
		result=new int[N];
		System.out.println(DP(N));
	}
	private static int DP(int i)
	{
		if(i==2) return 3; 
		if(i==1) return 2;
		
		if(result[i-1]!=0) return result[i];
		int answer=DP(i-1)*2+DP(i-2);
		result[i-1]=answer;
		
		return answer;
	}	
}
