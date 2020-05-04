package prac_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * R행 C열 
 * . 빈곳 ,* 물, X 돌
 * D 비버의 굴, S 고슴도치
 * S->D 최소시간 ==> bfs
 * 물은 매 분마다 상하좌우로 확장 ==> dx,dy
 * 고슴도치 상하좌우 이동가능 ==> dx,dy
 * 물이 찰 예정인 칸으로 이동불가
 * 
 */

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j].charAt(0);
				if(map[i][j] == 'D') {
					
				}
			}
		}
		br.close();
	}

}
