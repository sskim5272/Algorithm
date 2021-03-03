package ws.step05;

public class myArrayStack
{
	
	int top = -1;
	final int capacity = 5;
	int nums[] = new int[capacity];

	public boolean full()
	{
		return top == capacity - 1;
	}

	public void push(int nextInt)
	{
		nums[++top] = nextInt;
	}
	
	public int peek()
	{
		return nums[top];
	}

	public boolean isEmpty()
	{
		return top == -1;
	}

	public int pop()
	{
		return nums[top--];
	}

	public String toString()
	{
		String msg = " ";
		for (int i = 0; i <= top; i++)
		{
			msg = msg + Integer.toString(nums[i]) + " ";
		}
		return msg;
	}

}
