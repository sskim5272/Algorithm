/**
 * 중위표기법
 * - 연산자가 피연산자 사이에 나온다.
 * 
 * 후위표기법
 * - 연산자가 피연산자 뒤에 나온다.
 * - 53+   5 + 3
 * - 5 - 2 * 3  우선 순위를 생각해야 한다.
 * - 5 * 2 - 3  우선 순위를 생각해야 한다.
 *   523*- (?)
 *   523-* (?)
 *   52*3-
 *   
 *   
 *   
 *   (6+5*(2-8)/2)
 *   6528-*2/+
 *   
 *   
 *   
 * 구현하기
 * 1. 여는 괄호인 경우 스텍에 넣는다. 
 * 2. 숫자일 경우 별도의 공간에서 관리
 * 3. 연산자를 넣을때 우선순위를 따져서 스택에 넣으려는 연산자 우선순위가 스택의 가장 위쪽의 항목보다 우선순위가 같거나 낮다면 스택의 연산자를 꺼내서 피연산자에 추가한다.
 * 4. 닫는 괄호가 나온다면 여는 괄호가 나올때까지 피연산자 부분에 추가한다.
 * 
 */
package ws.step04;

import java.util.Stack;

public class CalcTest
{

	public static void main(String[] args)
	{
		String str = "(6+5*(2-8)/2)";

		// 후위표기식 만들
		String postOrder = doPostOrder(str);
		System.out.println(postOrder);
		// 계산하기 6528-*2/+

		int num = doCalc(postOrder);
		System.out.println(num);
	}

	static int doCalc(String s)
	{
		char[] srr = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int num1, num2, num3;
		for (char ch : srr)
		{
			if (ch >= '0' && ch <= '9')
			{
				stack.push(ch - '0'); // ch-'0'
			} else
			{
				num2 = stack.pop();
				num1 = stack.pop();
				num3 = calc(ch, num1, num2);
				stack.push(num3);
			}
		}
		return stack.pop();
	}

	static int calc(char ch, int num1, int num2)
	{
		int result = 0;
		switch (ch)
		{
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		return result;
	}

	static String doPostOrder(String s)
	{
		String result = "";
		char[] srr = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		char temp;
		// String str = "(6+5*(2-8)/2)";
		for (char ch : srr)
		{
			if (ch == '(')
			{
				stack.push(ch);
			} else if (ch >= '0' && ch <= '9')
			{
				result += ch;
			} else if (ch == ')')
			{
				while (!stack.isEmpty() && ((temp = stack.pop()) != '('))
				{

					result += temp;
				}
			} else
			{
				if (!stack.isEmpty() && getPrority(ch) <= getPrority(stack.peek()))
				{
					result += stack.pop();
				}
				stack.push(ch);
			}
		}
		return result;
	}

	static int getPrority(char ch)
	{
		int result = 0;
		switch (ch)
		{
		case '*':
		case '/':
			result = 2;
			break;
		case '+':
		case '-':
			result = 1;
			break;
		}
		return result;
	}

}
