package ws.step06;

import java.util.Arrays;

import hw.step04.Node;

public class MyLinkedStack
{
	Node top = null;

	class Node
	{
		// 내부 클래스
		String data;
		Node link;

		public Node(String data)
		{
			this.data = data;
		}

		public Node()
		{
		}

	}

	public void push(String nextLine)
	{
		Node newNode = new Node();
		newNode.data = nextLine;

		if (top == null)
		{
			top = newNode;
		} else
		{
			newNode.link = top;
			top = newNode;
		}
	}

	public boolean isEmpty()
	{
		return top == null;
	}

	public String pop()
	{
		String data = peek();
		top = top.link;
		return data;
	}

	public String peek()
	{
		return top.data;
	}

	public String toString()
	{
		String str = "";
		for (Node currNede = top; currNede != null; currNede = currNede.link)
		{
			str += currNede.data;
			if (currNede.link != null)
				str += ", ";
		}
		return "Stack " + "[" + str + "]";
	}

}
