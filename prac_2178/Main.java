package prac_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
	int x, y;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
		
		br.close();
	}

	public static void bfs(int y, int x) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int cx = dot.x;
			int cy = dot.y;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (visited[ny][nx] == false && map[ny][nx] == 1) {
					q.add(new Dot(ny, nx));
					visited[ny][nx] = true;
					map[ny][nx] = map[cy][cx] + 1;
				}
			}
		}
	}
}
