package ws.step08;
import java.io.IOException;
import java.util.Scanner;

public class SW_D4_3289_서로소_집합
{
	static int n, m;
	static int[] parents;
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int state;
		int x, y;
		StringBuilder sb;
		for(int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n + 1];
			for(int i = 0; i< parents.length; i++) {
				parents[i] = i;
			}
			for(int i = 0; i < m; i++) {
				state = sc.nextInt();
				x = sc.nextInt();
				y = sc.nextInt();
				switch(state) {
				case 0 :
					unionSet(x, y);
					break;
				case 1 :
					if(findSet(x) == findSet(y)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
					break;
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		}

	}
	static int findSet(int x) {
		if(parents[x] == x) {
			return x;
		}else {
			//path compresstion
			return parents[x] = findSet(parents[x]);
		}
		
	}
	static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x != y) {
			parents[y] = x;
		}
	}

}