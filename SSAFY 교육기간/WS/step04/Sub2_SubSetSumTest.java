package ws.step04;

import java.util.Scanner;

/*
5 21
5 6 10 11 16
==> 21의 합 경우의수 3가지
*/
//입력받은 자연수들로 가능한 부분집합의 합 구성 : 재귀+boolean배열
/**
 * 
 * @author taeheekim
 *
 */
public class Sub2_SubSetSumTest {

	static int N,totalCount,S;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		for(int i=0; i<N; ++i) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0);
		System.out.println("총 경우의 수 : "+totalCount);
	}
	
	private static void generateSubSet(int count) { // count: 현재까지 고려한 원소 수

		if(count==N) {
			int sum = 0;
			for(int i=0; i<N; ++i) {
				if(isSelected[i]) sum += input[i];
			}
			if(sum == S) {
				++totalCount;
				for(int i=0; i<N; ++i) {
					if(isSelected[i]) {
						System.out.print(input[i]+" ");
					}
				}
				System.out.println();
			}
			return;
		}
		isSelected[count] = true;
		generateSubSet(count+1);
		isSelected[count] = false;
		generateSubSet(count+1);
	}

}
