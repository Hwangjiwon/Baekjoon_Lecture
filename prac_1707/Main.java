package prac_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int V, E;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] color;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int K = Integer.parseInt(input[0]);

		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);

			// 정점만큼 인접리스트 생성
			graph = new ArrayList<>();
			for (int j = 0; j < V; j++) {
				graph.add(new ArrayList<>());
			}

			// 양방향 연결
			for (int j = 0; j < E; j++) {
				input = br.readLine().split(" ");
				graph.get(Integer.parseInt(input[0]) - 1).add(Integer.parseInt(input[1]) - 1);
				graph.get(Integer.parseInt(input[1]) - 1).add(Integer.parseInt(input[0]) - 1);
			}

			color = new int[V];
			for (int j = 0; j < V; j++) {
				if (color[j] == 0) {
					color[j] = 1;
					bfs(j);
				}
			}

			// check
			System.out.println(check());
		}
		br.close();
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int idx = q.poll();

			for (int i = 0; i < graph.get(idx).size(); i++) {
				int nx = graph.get(idx).get(i);

				if (color[nx] == 0) {
					if (color[idx] == 1)
						color[nx] = -1;
					else if (color[idx] == -1)
						color[nx] = 1;

					q.add(nx);
				}
			}

		}
	}

	public static String check() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				if (color[i] == color[graph.get(i).get(j)])
					return "NO";
			}
		}
		return "YES";
	}

}
