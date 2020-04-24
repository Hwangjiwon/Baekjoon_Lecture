package prac_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 안전 영역
 * 
 * 행과 열 N(2~100)
 * 높이는 1~100
 * 
 * 물에 잠기지 않는 최대 개수
 * 1만큼 잠길때 안전영역 개수
 * 2만큼 잠길때 안전영역 개수
 * ... 
 * 최대 높이-1만큼 잠길때 안전영역 개수
 */
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

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
			}
		}

		br.close();
	}

}
