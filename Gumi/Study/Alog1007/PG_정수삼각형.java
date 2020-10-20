package Alog1007;

public class PG_정수삼각형
{
	class Solution
	{
		public int solution(int[][] triangle)
		{
			int answer = 0;
			if (triangle.length == 1)
				return triangle[0][0];

			for (int row = 1; row < triangle.length; row++)
			{
				triangle[row][0] += triangle[row - 1][0];
				
				for (int col = 1; col < row; col++)
				{
					triangle[row][col] += Math.max(triangle[row - 1][col], triangle[row - 1][col - 1]);
				}
				triangle[row][row] += triangle[row - 1][row - 1];
			}
			for (int x : triangle[triangle.length - 1])
			{
				answer = Math.max(answer, x);
			}
			return answer;
		}
	}
}
