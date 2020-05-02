package prac_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 벽 부수고 이동하기
 * 
 * 1,1 -> N, M
 * 최단경로 ==> bfs
 * 1개의 벽 뚫기 가능
 * 
 * N ==> y, 세로
 * M ==> x, 가로
 * 
 */

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split("");

			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}

	public static void bfs() {

	}
}
