package Algo0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class BJ_9742_순영
{
	static int cnt = 0;
	static int checked[];
	static char chars[];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			chars = str.toCharArray();
			int N = chars.length;
			checked = new int[N];
			for (int i = 0; i < N; i++)
			{
				checked[i] = i;
			}
			int K = Integer.parseInt(st.nextToken().trim());

			Arrays.sort(chars);
			System.out.print(str + " " + K + " " + "=" + " ");

			cnt = 0;
			permutation(checked, 0, N, N, K);
			System.out.println();
		}
	}

	static void permutation(int[] arr, int depth, int n, int r, int K)
	{
		cnt++;
		if (cnt == K)
		{
			for (int i : arr)
			{
				System.out.print(chars[i]);
			}
		}

		for (int i = depth; i < n; i++)
		{
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r, K);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i)
	{
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}
