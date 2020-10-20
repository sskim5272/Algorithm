package ws.step04;

import java.util.Scanner;

// 입력받은 자연수들로 가능한 부분집합 구성 : 재귀+boolean배열
/**
 * 
 * @author taeheekim
 *
 */
public class Sub1_SubSetTest {

	static int N,totalCount;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
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
			++totalCount;
			for(int i=0; i<N; ++i) {
				System.out.print((isSelected[i]?input[i]:"X")+" ");
			}
			System.out.println();
			return;
		}
		isSelected[count] = true;
		generateSubSet(count+1);
		isSelected[count] = false;
		generateSubSet(count+1);
	}

}
