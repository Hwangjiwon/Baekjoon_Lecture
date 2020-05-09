package prac_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 숫자판 점프
 * 
 * 5*5 숫자판
 * 0~9까지 숫자가 적혀있음
 * 임의의 위치에서 인접한 네방향으로 5번 이동하면서  ==> dx,dy
 * 한번 거쳤던 칸 다시 거쳐도 됨
 * 각칸의 숫자를 차례로 이어붙여 6자리수만든다 ==> String
 * 그렇게 만들어진 서로다른 수의  개수? ==> Set
 */

public class Main {
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sol(i, j);
			}
		}

		br.close();
	}

	public static void sol(int y, int x) {

	}
}
