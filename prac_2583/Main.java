package prac_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] vistied;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		map = new int[M][N];
		vistied = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");

			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);

			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		print(map);
		br.close();
	}

	static void print(int[][] map) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
