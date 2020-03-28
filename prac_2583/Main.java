package prac_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] vistied;
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
		vistied = new boolean[N][M];
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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				width = 0;
				if (map[i][j] == 0) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		print(map);
		br.close();
	}

	static void bfs(int y, int x) {
		
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
