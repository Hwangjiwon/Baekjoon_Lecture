package prac_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 스타트와 링크
 * 
 * N은 짝수
 * N/2씩 나누어서 팀의 능력치(S) 차이의 최솟값
 * 
 */

public class Main {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);

		S = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(input[j]);
			}
		}

		dfs(0, 0);
		System.out.println(min);

		br.close();
	}

	public static void dfs(int idx, int cnt) {
		if (cnt == N / 2) {
			min = Math.min(min, cal());
			return;
		}

		for (int i = idx; i < N; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static int cal() {
		int start = 0, link = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] == true && visited[j] == true) {
					start += S[i][j];
				}

				if (visited[i] == false && visited[j] == false) {
					link += S[i][j];
				}
			}
		}
		return Math.abs(start - link);
	}
}
