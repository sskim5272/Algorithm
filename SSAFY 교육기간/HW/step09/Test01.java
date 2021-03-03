package hw.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import sun.font.CharToGlyphMapper;

public class Test01
{
	public static void main(String[] args) throws Exception
	{
		new Test01().testcase();

	}

	private void testcase() throws IOException
	{
		for (int i = 1; i <= 10; i++)
		{
			System.out.println("#" + i + " " + solutoin(change()));

		}
	}

	private int solutoin(String change)
	{
		Stack<Integer> s = new Stack<Integer>();
		System.out.println(change);
		for (int i = 0; i < change.length(); i++)
		{
			char ch = change.charAt(i);
			if (ch <= '9' && ch >= '0')
			{
				s.push(ch - '0');

			} else if (ch == '+')
			{
				s.push(s.pop() + s.pop());
			} else
			{
				s.push(s.pop() * s.pop());
			}
		}

		return s.pop();
	}

	private String change() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st=new StringTokenizer(in.readLine());
		Stack<Character> s1 = new Stack<Character>();
		
		in.readLine();
		String st = in.readLine();
		String math = "";
		for (int i = 0; i < st.length(); i++)
		{
			char ch = st.charAt(i);
			if (ch <= '9' && ch >= '0')
			{
				math += Character.toString(ch);

			} else
			{
				while (true)
				{
					if (s1.isEmpty())
					{
						s1.push(ch);
						break;
					} else
					{
						if (ch == '+')
						{
							math += Character.toString(s1.pop());
						} else if (s1.peek() == '+')
						{
							s1.push(ch);
							break;
						} else
						{
							math += Character.toString(s1.pop());
						}
					}
				}
			}
		}
		while (!s1.isEmpty())
		{
			math += Character.toString(s1.pop());
		}

		return math;
	}
}
