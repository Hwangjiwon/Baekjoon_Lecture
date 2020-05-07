package prac_18290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * NM과 K(1)
 * 
 * NM의 격자판에서 K개 선택
 * 선택한 수를 모두 더한 값의 최대값 구하기
 * 선택한 수가 인접해서는 안됨
 * 
 */

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j, 0, 0);
			}
		}
		br.close();
	}

	public static void dfs(int y, int x, int cnt, int sum) {
		if (cnt == K) {
			System.out.println(sum);
			return;
		}

		
	}
}
