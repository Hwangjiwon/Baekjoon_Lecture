package prac_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		visited = new boolean[N + 1];
		dfs(0, "");

		br.close();
	}

	public static void dfs(int cnt, String str) {
		if (cnt == M) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, str + i + " ");
				visited[i] = false;
			}
		}
	}

}
