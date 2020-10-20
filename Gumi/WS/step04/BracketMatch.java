package ws.step04;

import java.util.Scanner;
import java.util.Stack;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class BracketMatch
{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		new BracketMatch().tesetcase();
	}

	private void tesetcase()
	{

		int T = 10;
//		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			int ans = solution();
			System.out.println("#" + test_case + " " + ans);
		}

	}

	private int solution()
	{
		int N;
		N = sc.nextInt();
		char[] input = sc.next().toCharArray();
		Stack<Character> s = new Stack<>();
		int result = 1;

		outer: for (char c : input)
		{
			switch (c)
			{
			case '(':

			case '{':

			case '<':

			case '[':
				s.push(c);
				break;
			default:
				if (check(s, c) == false)
				{
					result = 0;
					break outer;
				}
				s.pop();
			}
		}

		return result;
	}

	private boolean check(Stack<Character> s, char c)
	{
		if (s.empty() == true)
			return false;
		char ch=s.pop();
		switch (c)
		{
		case ')': return ch=='(';

		case '}':return ch=='{';

		case '>':return ch=='<';

		case ']':return ch==']';
		}

		return false;
	}
}
