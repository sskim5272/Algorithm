package ws.step08;

import java.util.LinkedList;
import java.util.Queue;

public class MirroBFS02 {
	static int N = 8;
	static int[][] map;
	static boolean[][] visited = new boolean[N][N];
	static int[][] visitedCnt = new int[N][N];
	static int moveCnt = 99999999;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	public static void main(String[] args) {
		map = new int[][] { 
			{ 0, 0, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 1 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 0 } 
		};

		bfs(0, 0, 0);
		System.out.println(moveCnt == 99999999 ? -1 : moveCnt);
	}

	static class Point {
		int x, y;
		int cnt = 0;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static void bfs(int x, int y, int cnt) {
		visitedCnt[x][y] = cnt;
		
		Point point = new Point(x, y, cnt);
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N - 1 && p.y == N - 1) {
				moveCnt = p.cnt;
				return;
			}
			visited[p.x][p.y] = true;
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if (check(nx, ny) == false) continue;
				
				visited[nx][ny] = true;
				visitedCnt[nx][ny] = p.cnt + 1;
				q.offer(new Point(nx, ny, p.cnt + 1));
			}
		}
	}
	private static boolean check(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || map[x][y] == 1) {
			return false;
		}
		return true;
	}
}
