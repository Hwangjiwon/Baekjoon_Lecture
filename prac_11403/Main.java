package prac_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[][] result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		map = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[j] == false) {
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}

		br.close();
	}

	public static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int dy = q.poll();

			for (int i = 0; i < N; i++) {
				if (map[dy][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
					result[start][i] = 1;
				}
			}
		}
	}
}
