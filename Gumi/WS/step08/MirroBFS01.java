package ws.step08;

import java.util.LinkedList;
import java.util.Queue;

public class MirroBFS01 {
	static int N = 8;
	static int[][] map;
	static boolean[][] visited = new boolean[N][N];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static String answer = "불가능";
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

		bfs(0, 0);
		System.out.println(answer);
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y) {
		Point point = new Point(x, y);
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N - 1 && p.y == N - 1) {
				answer = "가능";
				return;
			}
			visited[p.x][p.y] = true;
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if (check(nx, ny) == false) continue;
				
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
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
