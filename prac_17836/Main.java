package prac_17836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int y, x, cnt;

	Dot(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int N, M, T;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int time = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]); // y
		M = Integer.parseInt(input[1]); // x
		T = Integer.parseInt(input[2]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		bfs();

		System.out.println(time <= T ? time : "Fail");

		br.close();

	}

	// (1,1) -> (N, M)
	// => (0,0) -> (N-1, M-1)
	public static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0, 0, 0));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int px = d.x;
			int py = d.y;
			int pc = d.cnt;

			if (px == M - 1 && py == N - 1) {
				time = Math.min(time, pc);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (!visited[ny][nx] && map[ny][nx] != 1) {
					visited[ny][nx] = true;
					q.add(new Dot(ny, nx, pc + 1));

					if (map[ny][nx] == 2) { // 그람
						time = (M - nx) + (N - ny) + pc - 1;
					}

				}
			}
		}
	}
}
