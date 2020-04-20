package prac_2667;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] map, visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static LinkedList<Integer> danji = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] == 1 && visited[i][j] == 0) {
					cnt = 1;
					dfs(i, j);
					danji.add(cnt);
				}
		}
		Collections.sort(danji);
		bw.append(danji.size() + "\n");

		for (int i = 0; i < danji.size(); i++)
			bw.append(danji.get(i) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int y, int x) {
		visited[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
				dfs(ny, nx);
				cnt++;
			}

		}
		return cnt;
	}
}
