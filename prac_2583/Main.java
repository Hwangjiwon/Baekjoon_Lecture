package prac_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

class Dot {
	int y, x;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt; // 나누어 지는 영역의 개수
	static int width; // 영역의 넓이

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]); // x
		N = Integer.parseInt(input[1]); // y
		K = Integer.parseInt(input[2]);

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");

			int y1 = Integer.parseInt(input[0]);
			int x1 = Integer.parseInt(input[1]);

			int y2 = Integer.parseInt(input[2]);
			int x2 = Integer.parseInt(input[3]);

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		/*	
		 * 우선순위가 높은 것 먼저 출력 	
		 * [reverse]	
		 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());	
		 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				width = 0;
				if (map[i][j] == 0 && visited[i][j] == false) {
					bfs(i, j);
					pq.add(width);
					cnt++;
				}
			}
		}

		// print(map);

		System.out.println(cnt);
		while (!pq.isEmpty())
			System.out.print(pq.poll() + " ");

		br.close();
	}

	static void bfs(int y, int x) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int cx = dot.x;
			int cy = dot.y;
			width++;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (visited[ny][nx] == true)
					continue;

				if (map[ny][nx] == 0) {
					q.add(new Dot(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}

	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
