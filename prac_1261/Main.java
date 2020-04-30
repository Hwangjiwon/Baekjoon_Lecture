package prac_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 알고스팟
 * 
 * 가로 M, 세로 N
 * (1,1) -> (N,M)
 * 부숴야 하는 벽의 최소 개수 ==> bfs, Dequeue이용해서 벽 뚫어야 하는 경우를 addLast, 안뚫어도 되는 경우는 addFirst
 * 상하좌우 이동가능  ==> dx, dy, Dot(y,x,cnt)
 * 0인 곳 이동 가능, 1인 곳 이동 불가 
 * 
 */

class Dot {
	int y, x, cnt;

	Dot(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]); // 가로, x
		N = Integer.parseInt(input[1]); // 세로, y

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		bfs();
		System.out.println(result);

		br.close();
	}

	public static void bfs() {
		Deque<Dot> q = new LinkedList<>();
		q.add(new Dot(1, 1, 0));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int px = d.x;
			int py = d.y;
			int pc = d.cnt;

			if (px == M && py == N) {
				result = Math.min(result, pc);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				int nc = pc;

				if (nx <= 0 || ny <= 0 || nx > M || ny > N)
					continue;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					
					if (map[ny][nx] == 0) {
						q.addFirst(new Dot(ny, nx, nc));
					} else if (map[ny][nx] == 1) {
						q.addLast(new Dot(ny, nx, nc + 1));
					}
				}
			}
		}
	}
}
