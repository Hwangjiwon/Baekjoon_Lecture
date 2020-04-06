package prac_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.graalvm.compiler.nodes.java.ArrayLengthNode;

class Dot {
	int x, y;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 행
		M = Integer.parseInt(input[1]); // 열

		map = new char[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);

					for (int k = 0; k < N; k++) {
						Arrays.fill(visited[k], false);
						Arrays.fill(distance[k], 0);
					}
				}
			}
		}

		br.close();
	}

	public static void bfs(int y, int x) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int cx = d.x;
			int cy = d.y;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (map[ny][nx] == 'L' && !visited[ny][nx]) {
					q.add(new Dot(ny, nx));
					visited[ny][nx] = true;
					distance[ny][nx] = distance[cy][cx] + 1;
				}
			}
		}

	}
}
