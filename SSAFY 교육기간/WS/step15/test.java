package ws.step15;

public class test
{
	public static void main(String[] args)
	{
		int arry[] = new int[5];

		for (int i = 0; i < arry.length; i++)
		{
			arry[i] = i;

		}
		permutation(arry, 0, arry.length, arry.length);
	}

	private static void permutation(int arry[], int depth, int n, int r)
	{
		if (r == depth)
		{
			for (int x : arry)
			{
				System.out.print(x);
			}
			System.out.println();
		}
		
		for(int i=depth;i<n;i++) {
			swap(arry,depth,i);
			permutation(arry,depth+1,n,r);
			swap(arry,depth,i);
			
		}

	}

	private static void swap(int[] arry, int depth, int i)
	{
		int temp=arry[i];
		arry[i]=arry[depth];
		arry[depth]=temp;
	}
//	
//	
//	void permutation(int[] arr, int depth, int n, int r)
//	{
//		if (depth == r)
//		{
//			dfs(arr, 0, 0, 0);
//		}
//
//		for (int i = depth; i < n; i++)
//		{
//			swap(arr, depth, i);
//			permutation(arr, depth + 1, n, r);
//			swap(arr, depth, i);
//		}
//	}
//
//	void swap(int[] arr, int depth, int i)
//	{
//		int temp = arr[depth];
//		arr[depth] = arr[i];
//		arr[i] = temp;

}
