package Algo1229;

public class PG_스킬트리
{
	public static void main(String[] args)
	{
//		new PG_스킬트리().solution("CBDK", new String[] {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"});
		new PG_스킬트리().solution("CBDㄴ", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
	}
	
	public int solution(String skill, String[] skill_trees)
	{
		int answer = 0;

		for (String tree : skill_trees)
		{
			int masteridex = 0;
			
			for (int i = 0; i < tree.length(); i++)
			{
				char ch=tree.charAt(i);
				//스킬체크
				
				if(ch==skill.charAt(masteridex) && masteridex<skill.length())
					masteridex++;
				 
				
				if(check(masteridex,skill,ch)==false) break;
				
				if (i == tree.length() - 1)
					answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}

	private boolean check(int masteridex, String skill,char ch)
	{
		for(int i=masteridex;i<skill.length();i++) {
			if(skill.charAt(i)==ch) return false;
		}
		
		return true; 
		
	}
}
