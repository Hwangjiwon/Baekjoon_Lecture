package prac_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
