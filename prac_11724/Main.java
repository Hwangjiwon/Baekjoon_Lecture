package prac_11724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int idx) {
		visited[idx] = true;

		for (int i : graph.get(idx)) {
			if (!visited[i])
				dfs(i);
		}
	}

}
