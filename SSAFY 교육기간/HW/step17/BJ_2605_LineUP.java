package hw.step17;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2605_LineUP
{
	static int student[],N;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		student=new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			student[i] = Integer.parseInt(st.nextToken());
		}
		

		
		for (int num = 0; num < N; num++) {
			int step=student[num];
			list.add(num-step, num+1);
		}
		for(int x:list) {
			System.out.print(x+" ");
		}

	}

	

}
