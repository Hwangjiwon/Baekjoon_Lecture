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

		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < M; i++) {
			graph.add(new ArrayList<Integer>());
		}

		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}

		bw.write(cnt);
		bw.close();
		br.close();
	}

	public static void dfs(int v) {
		visited[v] = true;

		for (int u = 0; u < graph.get(v).size(); u++) {

			if (!visited[graph.get(v).get(u)]) {
				dfs(u);
			}
		}
	}
}
