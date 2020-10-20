package ws.step01;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	private static int reconstructoin(char[] nums, boolean iszero, int start)
	{
		int ans = 0;

		if (start >= nums.length)
			return 0;

		for (int i = start; i < nums.length; i++)
		{
			if (iszero && nums[i] == '0')
			{

				nums[i] = 1;
				ans++;
				ans += reconstructoin(nums, false, i++);

			} else if (iszero == (nums[i] == '1'))
			{
				nums[i] = 0;
				ans++;
				ans += reconstructoin(nums, true, i++);
			}
		}

		return ans;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			String input = sc.nextLine();
			char nums[] = new char[input.length()];
			for (int i = 0; i < input.length(); i++)
			{
				nums[i] = input.charAt(i);
			}
			
			System.out.println("\n"+nums.length);
			for(char x:nums) {
				System.out.print(x);
			}

			System.out.println("#" + test_case + " " + reconstructoin(nums, true, 0));
		}
	}
}