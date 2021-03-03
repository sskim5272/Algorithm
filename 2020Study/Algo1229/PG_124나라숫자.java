package Algo1229;

public class PG_124나라숫자
{
	public static void main(String[] args)
	{
		for(int i=1;i<20;i++) {
			new PG_124나라숫자().solution(i);
			
		}
	}
	public String solution(int n) {
        String answer = "";
        String answer2 = "";
        String nums[]=new  String[] {"4","1","2"};
        String nums2[]=new  String[] {"1","2","4"};
        if(n<4) {
        	 return nums[n-1];
        }
        
        System.out.println("#############");
        System.out.println("n : "+ n);
        
        while(true){
        	System.out.println();
        }
    }
	
}
