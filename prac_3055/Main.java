package prac_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

class Dot {
	int y, x;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static Queue<Dot> dochi = new LinkedList<>();
	static Queue<Dot> water = new LinkedList<>();

	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j].charAt(0);
				if (map[i][j] == 'S')
					dochi.add(new Dot(i, j));
				if (map[i][j] == '*')
					water.add(new Dot(i, j));
			}
		}

		while (true) {
			result++;
			if (dochi.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}

			extendWater();
			if (bfs() == true) {
				System.out.println(result);
				return;
			}
		}

	}

	public static void extendWater() {
		int size = water.size();

		for (int k = 0; k < size; k++) {
			Dot d = water.poll();
			int px = d.x;
			int py = d.y;

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R)
					continue;

				if (map[ny][nx] == '.') {
					map[ny][nx] = '*';
					water.add(new Dot(ny, nx));
				}
			}
		}
	}

	public static boolean bfs() {
		int size = dochi.size();

		for (int k = 0; k < size; k++) {
			Dot d = dochi.poll();
			int px = d.x;
			int py = d.y;

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R)
					continue;

				if (map[ny][nx] == 'D')
					return true;

				if (map[ny][nx] == '.') {
					map[ny][nx] = 'S';
					dochi.add(new Dot(ny, nx));
				}
			}
		}
		return false;
	}
}
