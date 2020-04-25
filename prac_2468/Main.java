package prac_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* ���� ����
 * 
 * ��� �� N(2~100)
 * ���̴� 1~100
 * 
 * ���� ����� �ʴ� �ִ� ����
 * 1��ŭ ��涧 �������� ����
 * 2��ŭ ��涧 �������� ����
 * ... 
 * �ִ� ����-1��ŭ ��涧 �������� ����
 */
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max;
	static int result = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				max = Math.max(max, map[i][j]);
			}
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < N; j++)
				Arrays.fill(visited[j], false);
			int cnt = 0;

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] > i && !visited[y][x]) {
						cnt++;
						dfs(i, y, x);
					}
				}
			}
			result = Math.max(result, cnt);
		}

		System.out.println(result);

		br.close();
	}

	public static void dfs(int hight, int y, int x) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return;

		if (visited[y][x] || map[y][x] <= hight)
			return;

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			dfs(hight, ny, nx);
		}

	}
}
