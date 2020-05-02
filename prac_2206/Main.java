package prac_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 벽 부수고 이동하기
 * 
 * 1,1 -> N, M
 * 최단경로 ==> bfs
 * 1개의 벽 뚫기 가능 ==> 뚫고가기, 안뚫고가기 나눠서 품
 * 
 * N ==> y, 세로
 * M ==> x, 가로
 * Dot(y,x,cnt,drill)
 * 
 */

class Dot {
	int y, x, cnt, drill;

	Dot(int y, int x, int cnt, int drill) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.drill = drill;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;
	static int drill;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split("");

			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}

	public static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(1, 1, 1, 0));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int px = d.x;
			int py = d.y;
			int pc = d.cnt;
			int pd = d.drill;

			if (px == M && py == N) {
				min = Math.min(min, pc);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx <= 0 || ny <= 0 || nx > M || ny > N)
					continue;

				if (pd == 1) { // 벽 부순적 있는 경우
					if (!visited[ny][nx][pd] && map[ny][nx] == 0) {
						visited[ny][nx][pd] = true;
						q.add(new Dot(ny, nx, pc + 1, pd));
					}
				} else { // 벽 부순적 없는 경우
					if (!visited[ny][nx][pd]) {
						visited[ny][nx][pd] = true;
						
						if (map[ny][nx] == 0) { // 벽 아닌 경우
							q.add(new Dot(ny, nx, pc + 1, pd));
						} else if (map[ny][nx] == 1) { // 벽인 경우
							q.add(new Dot(ny, nx, pc + 1, pd + 1));
						}
					}
				}
			}
		}
	}
}
