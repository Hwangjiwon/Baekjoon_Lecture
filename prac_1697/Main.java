package prac_1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, K;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		dist = new int[100001];
		visited = new boolean[100001];
		bfs();

		bw.write(String.valueOf(dist[K]));
		bw.close();
		br.close();

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;

		while (!q.isEmpty()) {
			int cn = q.poll();

			if (cn == K)
				break;

			if (cn - 1 >= 0 && visited[cn - 1] == false) {
				visited[cn - 1] = true;
				q.add(cn - 1);
				dist[cn - 1] = dist[cn] + 1;
			}

			if (cn + 1 <= 100000 && visited[cn + 1] == false) {
				visited[cn + 1] = true;
				q.add(cn + 1);
				dist[cn + 1] = dist[cn] + 1;
			}

			if (cn * 2 <= 100000 && visited[cn * 2] == false) {
				visited[cn * 2] = true;
				q.add(cn * 2);
				dist[cn * 2] = dist[cn] + 1;
			}
		}

	}
}
