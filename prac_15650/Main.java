package prac_15650;

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
		dfs(0, 1, "");
		br.close();
	}

	public static void dfs(int cnt, int idx, String str) {
		if (cnt == M) {
			System.out.println(str);
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			dfs(cnt + 1, i, str + i + " ");
			visited[i] = false;

		}

	}

}
