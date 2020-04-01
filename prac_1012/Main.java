package prac_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int y;
	int x;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int T, M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		T = Integer.parseInt(input[0]);
		for (int i = 0; i < T; i++) {
			input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); // 가로 x
			N = Integer.parseInt(input[1]); // 세로 y
			K = Integer.parseInt(input[2]); // 배추 개수

			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;

			for (int j = 0; j < K; j++) {
				input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				map[y][x] = 1;
			}
			// print(map);
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1 && !visited[j][k]) {
						bfs(j, k);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}

		

		br.close();
	}

	public static void bfs(int y, int x) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(y, x));

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int cx = dot.x;
			int cy = dot.y;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (map[ny][nx] == 1 && !visited[ny][nx]) {
					q.add(new Dot(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
