/*
I M N            
紐⑤뱺 �뵿���씠 �씛�깋(O)�쑝濡� 移좏빐吏� M X N �씠誘몄�瑜� �깉濡� 留뚮뱺�떎 

C
紐⑤뱺 �뵿���쓣 �씛�깋(O)�쑝濡� 移좏빐�꽌 �몴瑜� 吏��슫�떎. �씠誘몄��쓽 �겕湲곕뒗 諛붾�뚯� �븡�뒗�떎.

L X Y C
(X, Y) �뵿���쓣 二쇱뼱吏� �깋(C)�쑝濡� 移좏븳�떎.

V X Y1 Y2 C
X�뿴�뿉 Y1�뻾怨� Y2�뻾 (Y1, Y2 �룷�븿) �궗�씠�뿉 二쇱뼱吏� �깋(C)�쑝濡� �닔吏� 諛⑺뼢 吏곸꽑�쓣 湲뗫뒗�떎.
 
H X1 X2 Y C
Y�뻾�뿉 X1�뿴怨� X2�뿴 (X1, X2 �룷�븿) �궗�씠�뿉 二쇱뼱吏� �깋(C)�쑝濡� �닔�룊 諛⑺뼢 吏곸꽑�쓣 湲뗫뒗�떎.

K X1 Y1 X2 Y2 C
二쇱뼱吏� �깋(C)�쑝濡� 梨꾩썙吏� 吏곸궗媛곹삎�쓣 洹몃┛�떎. (X1, Y1)�� �쇊履� �쐞 �걹�젏, (X2, Y2)�뒗 
�삤瑜몄そ �븘�옒 �걹 �젏�쓣 �쓽誘명븳�떎.

F X Y C
R �쁺�뿭�쓣 二쇱뼱吏� �깋(C)�쑝濡� 梨꾩슦�뒗�뜲 �쁺�뿭 R�� �떎�쓬怨� 媛숈씠 �젙�쓽�맂�떎. (X,Y)�뵿���� R�뿉 �냽�븳�떎. 
(X,Y) �뵿��怨� �깋�씠 媛숆퀬 R�뿉 �룷�븿�맂 �뵿��怨� 留욌떯�� 遺�遺꾩씠 �븯�굹�씪�룄 �엳�떎硫� 洹� �뵿���룄 
R �쁺�뿭�뿉 �룷�븿�맂�떎. 

S NAME
�뙆�씪紐낆� �엯�젰諛쏆� 洹몃�濡� 異쒕젰�븯怨� 洹� �뮘�뿉 �쁽�옱 �씠誘몄��쓽 �궡�슜�쓣 異쒕젰�븳�떎.

X
�꽭�뀡�쓣 醫낅즺�븳�떎.


異쒕젰 >>
S NAME �씠�씪�뒗 紐낅졊�씠 �엳�쓣 �븣留덈떎 NAME�쑝濡� 二쇱뼱吏� �뙆�씪紐낆쓣 異쒕젰�븯怨� �쁽�옱 �씠誘몄��쓽 �궡�슜�쓣 異쒕젰�븳�떎.
媛� �뻾�� 媛� �뵿���쓽 �깋�쓣 �굹���궡�뒗 臾몄옄濡� �몴�떆�맂�떎. 異쒕젰 �삁瑜� 李멸퀬�븯�옄
I, C, L, V, H ,K, F, S, X瑜� �젣�쇅�븳 臾몄옄濡� �젙�쓽�맂 紐낅졊�씠 �엳�쑝硫� 洹� 以� �쟾泥대�� 臾댁떆�븯怨�
�떎�쓬 紐낅졊�쑝濡� �꽆�뼱媛꾨떎. �떎瑜� �삤瑜섏뿉 ���빐�꽌�뒗 �봽濡쒓렇�옩�쓽 �뻾�룞�쓣 �삁痢≫븷 �닔 �뾾�떎.

�젣怨듬릺�뒗 quiz01.txt �뙆�씪�쓽 �궡�슜�쓣 �씠�슜�븯�뿬 �뜲�씠�꽣瑜� �엯�젰諛쏄퀬 �븘�옒�쓽 寃곌낵媛� �굹�삤�룄濡� 肄붾뵫 �옉�꽦

異쒕젰寃곌낵>
one.bmp
OOOOO
OOOOO
OAOOO
OOOOO
OOOOO
OOOOO
two.bmp
JJJJJ
JJZZJ
JWJJJ
JWJJJ
JJJJJ
JJJJJ
three.bmp
OMMMO
OMMMO
OMMMO
OOOOO
OOOOO
OOOOO
four.bmp
JJZZJ
JJZZJ
WWZZJ
WWJJJ
JJJJJ
JJJJJ
 */
package ws.step03;

import java.util.Scanner;

public class SelfTest01
{
	int M, N, menu;
	Scanner sc = new Scanner(System.in);
	char grid[][];
	int[] dx =
	{ 0, 0, -1, 1 };
	int[] dy =
	{ 1, -1, 0, 0 };

	private void C()
	{
		for (int i = 0; i < M; i++)
			
			
			
		{
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = 'O';
			}
		}

	}

	private void L(int x, int y, char color)
	{
		grid[y][x] = color;
	}

	private void V(int x, int y1, int y2, char color)
	{
		for (int st = y1; st <= y2; st++)
		{
			grid[st][x] = color;
		}
	}

	private void H(int x1, int x2, int y, char color)
	{
		for (int st = x1; st <= x2; st++)
		{
			grid[y][st] = color;
		}

	}

	private void K(int x1, int y1, int x2, int y2, char color)
	{
		for (int c = x1; c <= x2; c++)
		{
			for (int r = y1; r <= y2; r++)
			{
				grid[r][c] = color;
			}
		}

	}

	private void findAndChange(int x, int y, char findcolor, char changeColor)
	{
		if (grid[y][x] != findcolor)
		{
			return;
		}

		grid[y][x] = changeColor;

		for (int i = 0; i < 4; i++)
		{
			if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < N && y + dy[i] < M)
				findAndChange(x + dx[i], y + dy[i], findcolor, changeColor);
		}
		return;
	}

	private void F(int x, int y, char color)
	{
		System.out.println(x+" "+y);
		char findColor = grid[y][x];
//		grid[y][x] = color;
		findAndChange(x, y, findColor, color);
		return;
	}

	private void S(String msg)
	{
		System.out.println(msg);
		for (char xx[] : grid)
		{
			for (char x : xx)
			{
				System.out.print(x);
			}
			System.out.println();
		}
	}

	public void service()
	{

		int x, y, x1, x2, y1, y2;
		char color;
		String msg = "";
		if (sc.next().charAt(0) == 'I')
		{
			M = sc.nextInt();
			N = sc.nextInt();
		}
		grid = new char[M][N];
		C();

		outer: while (true)
		{
			menu = sc.next().charAt(0);
			switch (menu)
			{
			case 'C':
				C();
				break;
			case 'L':
				L(sc.nextInt() - 1, sc.nextInt() - 1, sc.next().charAt(0));
				break;
			case 'V':
				V(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.next().charAt(0));
				break;
			case 'H':
				H(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.next().charAt(0));
				break;
			case 'K':
				K(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.next().charAt(0));
				break;
			case 'F':
				F(sc.nextInt() - 1, sc.nextInt() - 1, sc.next().charAt(0));
				break;
			case 'S':
				S(sc.next());
				break;
			case 'X':
				break outer;

			default:
				break;
			}
		}

	}

	public static void main(String[] args)
	{
		new SelfTest01().service();

	}

}
